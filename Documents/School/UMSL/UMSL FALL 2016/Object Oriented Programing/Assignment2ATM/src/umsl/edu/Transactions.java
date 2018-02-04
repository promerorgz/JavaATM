//package umsl.edu;
//
//import java.io.IOException;
//import javax.swing.JOptionPane;
//import static umsl.edu.ATM_Account.ac;
//
//
//public class Transactions
//{
////    public static Transactions tr = new Transactions();
//    public Transactions (ATM_Account account) throws IOException
//    { 
//   
//        String[] trans = { "Deposit", "Withdraw", "Check Balance", "Exit"};
//    
//        String trinput = (String)JOptionPane.showInputDialog(null, "Select One...", "UMSL ATM", JOptionPane.PLAIN_MESSAGE, null,trans,trans[0]);
//    
//    
//   switch (trinput)
//       
//    {
//       case "Deposit":
//           ac.deposit();
//           
//                     
//       break;
//       
//       case "Load Account":
//           ac.withdraw();
//           
//       break;
//       
//       case "Save Account":
//           ac.checkBalance();
//           JOptionPane.showMessageDialog(null, "Account has been Saved.", "Success!", JOptionPane.INFORMATION_MESSAGE);  
//           
//       break;
//       
//       case "Access Account":
//            ac.getInterest();
//       break;
//       
//       case "Exit":
//           System.exit(0);          
//    }
//  }
////        Scanner s = new Scanner(System.in);
////        while(true)
////        {
////            System.out.println("Automated Teller Machine");
////            System.out.println("Choose 1 for Withdraw");
////            System.out.println("Choose 2 for Deposit");
////            System.out.println("Choose 3 for Check Balance");
////            System.out.println("Choose 4 for Interest");
////            System.out.println("Choose 5 for EXIT");
////            System.out.print("Choose the operation you want to perform: ");
////            int n = s.nextInt();
////            switch(n)
////            {
////                case 1:
////                try {
////                    account.withdraw();
////                } catch (IOException ex) {
////                    Logger.getLogger(Transactions.class.getName()).log(Level.SEVERE, null, ex);
////                }
////                break;
//// 
////                case 2:
////                try {
////                    account.deposit();
////                } catch (IOException ex) {
////                    Logger.getLogger(Transactions.class.getName()).log(Level.SEVERE, null, ex);
////                }
////                break;
//// 
////                case 3:
////                try {
////                    account.checkBalance();
////                } catch (IOException ex) {
////                    Logger.getLogger(Transactions.class.getName()).log(Level.SEVERE, null, ex);
////                }
////                break;
////                case 4:
////            
////                try {
////                    account.getInterest();
////                } catch (IOException ex) {
////                    Logger.getLogger(Transactions.class.getName()).log(Level.SEVERE, null, ex);
////                }
////                break;
////                
////                    
////                case 5:
//////                System.exit(0);
//                
//            }
//           
//        