/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umsl.edu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import static umsl.edu.ATM_Account.ac;

/**
 *
 * @author Pablo
 */
public class ATMmenu 
{
    static ATM_Account[] acctArray = new ATM_Account[3];
    static boolean acctsLoaded = false;
    static boolean acctsPop = false;
   static ATMmenu am = new ATMmenu();
  static String[] choices = { "Create Account", "Load Account", "Save Account", "Access Account", "Exit"};

  public static void main (String args[]) throws IOException
  {
    
//    String[] choices = { "Create ATM_Account", "Load ATM_Account", "Save ATM_Account", "Access ATM_Account", "Exit"};
    String Menuinput = (String)JOptionPane.showInputDialog(null, "Select One...", "UMSL ATM", JOptionPane.PLAIN_MESSAGE, null,choices,choices[0]);
    
    
   switch (Menuinput)
       
    {
       case "Create Account":
           am.createAccounts();
           
           
           
                     
       break;
       
       case "Load Account":
           am.loadAccounts();
           
       break;
       
       case "Save Account":
           am.saveAccount();
           JOptionPane.showMessageDialog(null, "Account has been Saved.", "Success!", JOptionPane.INFORMATION_MESSAGE);  
           
       break;
       
       case "Access Account":
            am.selectAccounts();
       break;
       
       case "Exit":
           System.exit(0);          
    }
  }
  
  
  public void createAccounts() throws IOException
    {
        if(acctsPop)
        {
           JOptionPane.showMessageDialog(null,"Accounts have already been created.", "Populate Accounts", JOptionPane.PLAIN_MESSAGE);
        }
        else
        {
            for(int i=0; i<acctArray.length;i++)
            {
                acctArray[i] = new ATM_Account();

                acctsPop = true;
            
            }
            
           JOptionPane.showMessageDialog(null, "Accounts have been created.", "Success!", JOptionPane.INFORMATION_MESSAGE);
            ATMmenu am = new ATMmenu();  
            am.main();
        }
        
    }
        
        
  public void loadAccounts() throws IOException
  {
      try 
      {
          FileInputStream inStream = new FileInputStream("E://AssignmentATM.File1.txt");
          ObjectInputStream is = new ObjectInputStream(inStream);
          acctArray = (ATM_Account[]) is.readObject();
          is.close();
          JOptionPane.showMessageDialog(null, "Account has been loaded.", "Success!", JOptionPane.INFORMATION_MESSAGE);       

      }
      catch (Exception e)
      {
          JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
      }
      acctsLoaded = true;
      am.main();
  }


public void saveAccount() throws IOException
{
    try
    {
      FileOutputStream outStream = new FileOutputStream("E://AssignmentATM.File1.txt");  
            ObjectOutputStream os = new ObjectOutputStream(outStream);
            os.writeObject(acctArray);
            os.flush();
            os.close();
    }
    catch (IOException e)
    {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    am.main();

}
public void selectAccounts() throws IOException
    {
    String[] accts = { "Account 1", "Account 2", "Account 3", "Exit"};
    String acctinput = (String)JOptionPane.showInputDialog(null, "Select One...", "UMSL ATM", JOptionPane.PLAIN_MESSAGE, null,accts,accts[0]);
     String[] trans = { "Deposit", "Withdraw", "Check Balance", "Exit"};
        
    switch (acctinput)
        
    {
       case "Account 1":
//            ATM_Account account = acctArray[0];
        
           String trinput = (String)JOptionPane.showInputDialog(null, "Select One...", "UMSL ATM", JOptionPane.PLAIN_MESSAGE, null,trans,trans[0]);
    
    
                switch (trinput)

                         {
                            case "Deposit":
                                ac.deposit();


                            break;

                            case "Withdraw":
                                ac.withdraw();

                            break;

                            case "Check Balance":
                                ac.checkBalance();

                            break;

                            case "Get Interest":
                                 ac.getInterest();
                            break;

                            case "Exit":
                                System.exit(0);          
                         }
                am.selectAccounts();
                     
       break;
       
       case "Account 2":
                       
//           ATM_Account account2 = acctArray[1];

                   
           String trinput2 = (String)JOptionPane.showInputDialog(null, "Select One...", "UMSL ATM", JOptionPane.PLAIN_MESSAGE, null,trans,trans[0]);
    
    
                switch (trinput2)

                         {
                            case "Deposit":
                                ac.deposit();


                            break;

                            case "Withdraw":
                                ac.withdraw();

                            break;

                            case "Check Balance":
                                ac.checkBalance();

                            break;

                            case "Get Interest":
                                 ac.getInterest();
                            break;

                            case "Exit":
                                System.exit(0);          
                         }
                am.selectAccounts();
           
    
       break;
       
       case "Account 3":
           
//            ATM_Account account3 = acctArray[2];

             
           String trinput3 = (String)JOptionPane.showInputDialog(null, "Select One...", "UMSL ATM", JOptionPane.PLAIN_MESSAGE, null,trans,trans[0]);
    
    
                switch (trinput3)

                         {
                            case "Deposit":
                                ac.deposit();


                            break;

                            case "Withdraw":
                                ac.withdraw();

                            break;

                            case "Check Balance":
                                ac.checkBalance();

                            break;

                            case "Get Interest":
                                 ac.getInterest();
                            break;

                            case "Exit":
                                System.exit(0);          
                         }
                am.selectAccounts();
           
           
       break;
        

       
       case "Exit":
           System.exit(0);
           am.main();
    }
    }
    public void main() throws IOException 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
      
    
    String[] choices = { "Create Account", "Load Account", "Save Account", "Access Account", "Exit"};
    String Menuinput = (String)JOptionPane.showInputDialog(null, "Select One...", "UMSL ATM", JOptionPane.PLAIN_MESSAGE, null,choices,choices[0]);
    
    
   switch (Menuinput)
    {
       case "Create Account":
           am.createAccounts();
           //JOptionPane.showInputDialog(null, "Select One...", "UMSL ATM", JOptionPane.PLAIN_MESSAGE, null,choices,choices[0]);
                     
       break;
       
       case "Load Account":
           am.loadAccounts();
           
       break;
       
       case "Save Account":
           am.saveAccount();
           JOptionPane.showMessageDialog(null, "Account has been Saved.", "Success!", JOptionPane.INFORMATION_MESSAGE);       
           
       break;
       
       case "Access Account":
            am.selectAccounts();
       break;
       
       case "Exit":
           System.exit(0);          
    }
    

    }
}