package bankapp;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Rich Smith at ZenOfProgramming.com
 */
public class CustomerList
{
   private ArrayList<Customer> arr;



   public ArrayList<Customer> getArr ()
   {
      return arr;
   }

   public void add (Customer c)
   {
      this.arr.add(c);
   }

   public CustomerList () throws FileNotFoundException
   {
      this.arr = new ArrayList<Customer>();

      File myFile = new File("customerdata.txt");
      Scanner s = new Scanner(myFile);

      while (s.hasNext()) {
         String line = s.nextLine();
         String[] fields = line.split(", ");
         Customer newCustomer = new Customer(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], Boolean.parseBoolean(fields[7]), Integer.parseInt(fields[8]), Double.parseDouble(fields[9]), Double.parseDouble(fields[10]), Boolean.parseBoolean(fields[11]), Integer.parseInt(fields[12]), Double.parseDouble(fields[13]), Double.parseDouble(fields[14]));

         arr.add(newCustomer);
      }
      for (int i = 0; i < arr.size(); i++) {
         System.out.println(arr.get(i).toString());
      }
   }

   public Customer findCustomer (String user, String pass)
   {
      for (int i = 0; i < arr.size(); i++) {
         if (arr.get(i).getLastName().equals(user) && arr.get(i).getPassword().equals(pass)) {
            return arr.get(i);
         }
      }
      return null;
   }

   public void writeToFile () throws IOException
   {
      File myFile = new File("customerdata.txt");
      FileWriter writer = new FileWriter(myFile, false);
      for (int i = 0; i < arr.size(); i++) {
         writer.write(arr.get(i).toString());
      }
      writer.close();
   }

//   public void addCustomer (Customer createCustomer)
//   {
//      for (int i = 0; i < arr.size(); i++) {
//         if (arr.get(i) == null);
//         arr.set(i, createCustomer);
//      }
//
//   }




}
