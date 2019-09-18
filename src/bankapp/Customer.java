package bankapp;

public class Customer
{
   private String firstName;
   private String lastName;
   private String streetAddress;
   private String password;
   private String city;
   private String province;
   private String postalCode;
   private BankAccount chequing;
   private BankAccount savings;
   private int branchNum;
   private String branchAddress;

   public Customer ()
   {
   }

   public Customer (String firstName, String lastName, String password, String streetAddress, String city, String province, String postalCode, boolean type1, int accountNum1, double balance1, double interest1, boolean type2, int accountNum2, double balance2, double interest2)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.streetAddress = streetAddress;
      this.password = password;
      this.city = city;
      this.province = province;
      this.postalCode = postalCode;
      this.chequing = new BankAccount(type1, accountNum1, balance1, interest1);
      this.savings = new BankAccount(type2, accountNum2, balance2, interest2);
   }

   public String toString ()
   {
      return this.firstName + ", " + this.lastName + ", " + this.password + ", " + this.streetAddress + ", " + this.city + ", " + this.province + ", " + this.postalCode + ", " + this.chequing.getType() + ", " + this.chequing.getAccountNum() + ", " + this.chequing.getBalance() + ", " + this.chequing.getInterest() + ", " + this.savings.getType() + ", " + this.savings.getAccountNum() + ", " + this.savings.getBalance() + ", " + this.savings.getInterest() + "\n";
   }

   public String getFirstName ()
   {
      return firstName;
   }

   public void setFirstName (String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName ()
   {
      return lastName;
   }

   public void setLastName (String lastName)
   {
      this.lastName = lastName;
   }

   public String getStreetAddress ()
   {
      return streetAddress;
   }

   public void setStreetAddress (String streetAddress)
   {
      this.streetAddress = streetAddress;
   }

   public String getPassword ()
   {
      return password;
   }

   public void setPassword (String password)
   {
      this.password = password;
   }

   public String getCity ()
   {
      return city;
   }

   public void setCity (String city)
   {
      this.city = city;
   }

   public String getProvince ()
   {
      return province;
   }

   public void setProvince (String province)
   {
      this.province = province;
   }

   public String getPostalCode ()
   {
      return postalCode;
   }

   public void setPostalCode (String postalCode)
   {
      this.postalCode = postalCode;
   }

   public BankAccount getChequing ()
   {
      return chequing;
   }

   public void setChequing (BankAccount chequing)
   {
      this.chequing = chequing;
   }

   public BankAccount getSavings ()
   {
      return savings;
   }

   public void setSavings (BankAccount savings)
   {
      this.savings = savings;
   }

   public void setBranchNum (int branchNum)
   {
      this.branchNum = branchNum;
   }

   public void setBranchAddress (String branchAddress)
   {
      this.branchAddress = branchAddress;
   }


   public int getBranchNum (String city)
   {
      if ("Milton".equals(city)) {
         branchNum = 1;
      }
      else if ("Burlington".equals(city)) {
         branchNum = 2;
      }
      else if ("Oakville".equals(city)) {
         branchNum = 3;
      }
      else if ("Guelph".equals(city)) {
         branchNum = 4;
      }
      return this.branchNum;
   }

   public String getBranchAddress (int branchNum)
   {
      switch (branchNum) {
         case 1:
            branchAddress = "880 Main Street E,\n Milton,\n Ontario\n L9T 0J4";
            break;
         case 2:
            branchAddress = "547 Brant Street,\n Burlington,\n Ontario\n L7R 2G6";
            break;
         case 3:
            branchAddress = "489 Dundas Street W,\n Oakville,\n Ontario\n L6M 4M2";
            break;
         case 4:
            branchAddress = "338 Speedvale Avenue E,\n Guelph,\n Ontario\n N1E 1N5";
            break;
         default:
            break;
      }
      return branchAddress;
   }




}
