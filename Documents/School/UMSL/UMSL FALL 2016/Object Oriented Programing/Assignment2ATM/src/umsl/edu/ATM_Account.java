/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umsl.edu;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author cdsyc8
 */
public class ATM_Account implements Serializable
        
{
   public static ATM_Account ac = new ATM_Account();
    
   public  ATM_Account()
   
    {
        balance = 100;
        interest = 0.05;
        Date initDate = new Date();
    }
    
    public double balance;
    public double interest;
    public Date initDate;
    public int firstdate;
    public int seconddate;
    public Calendar cal1 = new GregorianCalendar();
    public Calendar cal2 = new GregorianCalendar();
    public boolean dateflag = false;


  public  void deposit() throws IOException
    {
        if(dateflag == true)
        {
            getDate2();
            getInterest();
        }
        else
        {
            getDate1();
        }

        String dep = JOptionPane.showInputDialog(null, "Enter amount to deposit: ");
        double deposit = Double.parseDouble(dep);               
        
        balance = balance + deposit;
        JOptionPane.showMessageDialog(null, "Deposit successful");
        JOptionPane.showMessageDialog(null, "New balance: $" + balance);
    }

    public void withdraw() throws IOException
    {
       if(dateflag == true)
        {
            getDate2();
            getInterest();
        }
        else
        {
            getDate1();
        }



        String wd = JOptionPane.showInputDialog(null, "Enter amount to withdraw: ");
        double withdraw = Double.parseDouble(wd);               
        
        JOptionPane.showMessageDialog(null, "Money has been withdrawn");
        JOptionPane.showMessageDialog(null, "New balance: $" + balance);

        if(balance >= withdraw)       
        {
            balance = balance - withdraw;
            JOptionPane.showMessageDialog(null,"New balance: " + balance);
            JOptionPane.showMessageDialog(null,"Please collect your money");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Insufficient Balance", "ERROR", JOptionPane.ERROR_MESSAGE);
        }                
    }

    public void checkBalance() throws IOException
    {
        if(dateflag == true)
        {
            getDate2();
            getInterest();
        }
        else
        {
            getDate1();
        }

        String cb = getBalance();
        JOptionPane.showMessageDialog(null, "Your balance is:" + cb);

    }

    private void getDate1() throws IOException
    {
        String date1 = JOptionPane.showInputDialog(null, "Enter date (mm/dd/yyyy): ");
    
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(date1, pos);
        cal1.setTime(date);

        firstdate = cal1.get(Calendar.DAY_OF_YEAR);
        dateflag = true;
    }

    private void getDate2() throws IOException

    {
        String date2 = JOptionPane.showInputDialog(null, "Enter date (mm/dd/yyyy): ");

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date date= new Date();
        date = formatter.parse(date2, pos);

        cal2.setTime(date);
        int seconddate = cal2.get(Calendar.DAY_OF_YEAR);


            if (firstdate > seconddate) 
            {
                JOptionPane.showMessageDialog(null, "Enter future date","ERROR", JOptionPane.ERROR_MESSAGE);               
                getDate2();
            }
    }

  public  void getInterest() throws IOException
    {
        int seconddate = cal2.get(Calendar.DAY_OF_YEAR);
        int datediff = seconddate - firstdate;
        double rate = .05/365;
        double ratetime = Math.pow(1+rate,datediff);
        double newInterest = balance * ratetime;
        JOptionPane.showMessageDialog(null,"Current interest: " + newInterest);
    }

    public String getBalance() throws IOException
    {
        NumberFormat currencyFormatter;
        String currencyOut;

        currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        currencyOut = currencyFormatter.format(balance);

        return currencyOut;
    }


}