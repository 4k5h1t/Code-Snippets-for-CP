import java.io.*;
import java.util.Scanner;

public class PhonebookDriver {

    public static void main(String[] args) throws FileNotFoundException {
        
        PhoneBook b = new PhoneBook();

        //parsing a CSV file into Scanner class constructor  
        Scanner sc = new Scanner(new File("Advanced Question 2/50-contacts.csv"));  
        sc.useDelimiter(",");   //sets the delimiter pattern  
        while (sc.hasNext()){   //returns a boolean value  
            String fname = sc.next();
            String lname = sc.next();
            String number = sc.next();
            String email = sc.next();
            b.insert(fname, lname, number, email);
        }   
        
        System.out.println("\nContacts in 50-contacts.csv has been added ");

        Scanner cin = new Scanner (System.in);
        int choice = 0;

        while (choice != 6){
            System.out.println("--------------------------------------------------------");
            System.out.println("\nEnter number corresponding to required function :");
            System.out.println("1. Insert new Contact");
            System.out.println("2. Display Phonebook");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display First Contact");
            System.out.println("5. Display Last Contact");
            System.out.println("6. Exit");

            System.out.print("\nYour Choice : ");
            choice = cin.nextInt();

            switch(choice){
                case 1: {
                    System.out.print("\nEnter Contact first name : ");
                    String fname = cin.next();
                    System.out.print("\nEnter Contact last name : ");
                    String lname = cin.next();
                    System.out.print("\nEnter Contact Phone number(s) [Separated by |] : ");
                    String number = cin.next();
                    System.out.print("\nEnter Contact email ID(s) [Separated by |] : ");
                    String email = cin.next();
                    b.insert(fname, lname, number, email);
                    System.out.println("\nInserted Successfully\n");
                    break;
                }
                case 2: {
                    b.Display();
                    break;
                }
                case 3: {
                    System.out.print("\nEnter first name of contact : ");
                    String x = cin.next();
                    b.Search(x);
                    break;
                }
                case 4: {
                    b.DisplayFirst();
                    break;
                }
                case 5: {
                    b.DisplayLast();
                    break;
                }
                case 6: {
                    break;
                }
                default: {
                    System.out.println("Invalid Choice...");
                    break;
                }
            }
        }
        cin.close();        
    }    
}