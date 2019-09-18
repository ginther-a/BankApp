package bankapp;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class BankAccount
{
   private boolean type;
   private int accountNum;
   private double balance;
   private double interest;
   private double moneyIn;
   private double moneyOut;
   private String accountName;


   public BankAccount (boolean type, int accountNum, double balance, double interest)
   {
      this.type = type;
      this.accountNum = accountNum;
      this.balance = balance;
      this.interest = interest;
   }

   public void deposit (double moneyIn)
   {
      this.balance += moneyIn;
   }

   public void withdraw (double moneyOut)
   {
      this.balance -= moneyOut;
   }

   public double getBalance (double interest)
   {
      this.balance *= interest;
      return this.balance;
   }

   public double getBalance ()
   {

      return this.balance;
   }

   public String getAccountName (boolean type)
   {
      if (type == true) {
         this.accountName = "Chequing";
      }
      else {
         this.accountName = "Savings";
      }
      return this.accountName;
   }


   public int getAccountNum ()
   {
      return accountNum;
   }

   public double getInterest ()
   {
      return interest;
   }

   public boolean getType ()
   {
      return type;
   }



}
