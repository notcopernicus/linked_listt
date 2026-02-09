
import java.util.Scanner;


public class mainDriver {
   public static void main (String [] args) {
   
   // write main method logic here

   Scanner kb = new Scanner(System.in);


   System.out.println("1) Enroll Student");
   
   System.out.println("2) Drop Student");

   System.out.println("3) Show enrolled");

   System.out.println("4) Show waitlist");

   System.out.println("5) Search by ID");

   System.out.println("5) Export roster");

   System.out.println("6) Bulk import from CSV");

   System.out.println("7) Export roster");

   System.out.println("Q) Quit");

   
   int choice = kb.nextInt();
   String input = "x";



   while (!input.equals("Q"))
    {
      
      if (choice == 1)
      {
         // write code to enroll students
      }

      if (choice == 2)
      {
         //write code to drop students
      }

      if (choice == 3) {
      /// write code to show enrolled students
      }

      if (choice == 4) {
         // write code to show waitlist
      }
   
      if (choice == 5)
      {
         // write code to enroll students
      }
   
      if (choice == 6)
         {
            //write code to drop students
         }
   
      if (choice == 7) {
         /// write code to show enrolled students
      }

}


