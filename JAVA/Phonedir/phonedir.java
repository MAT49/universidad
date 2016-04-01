/* @author: Ha K Hwang      
       
Purpose:
    The purpose of this program is to gain experience with Linked List and to be able to use the Java Library. 
    The class uses objects created using records.java and puts them to linked list.
    This program maintains a list of records containing names and phone numbers. 
    The program will prompt the user for a command, execute the command, then prompt the user for another command.
    
    The output will look like:

        Current record is: Barry Drake 770-591-8071

        a     Show all records

        d     Delete the current record

        f     Change the first name in the current record

        l     Change the last name in the current record

        n     Add a new record

        p     Change the phone number in the current record

        q     Quit

        s     Select a record from the record list to become the current record

        Please select the command from the list: n

        Enter first name: Ada

        Enter last name: Caswell

        Enter phone number: 770-251-3456

        Current record is: Ada Caswell 770-251-3456 

Solution: 
    - Create while loop to continue running program until 'q' is pressed
    - Create switch or if/else if for each of command char pressed
    - Create method to terminate program when 'q' is pressed
    - Create object from records.java from user input
    - Create a counter to track down current position in linked list
    - Create a method to add object to linked list in alphabetical order of last name
    - Create a method to delete the current record
    - Create a method to change first name field of object at current linked list
    - Create a method to change phone number of object at current linked list
    - Create a method to select a new position in linked list
    - Create a method to change last name of object at current linked list and re-add it in alphabetical order of last name   
  
Data structures to be used: 
    - One Linked List to hold records.java objects
           
Description of how to use program and expected input/output:
    - The program requires user input for command (single character press)
    - This program also requires user input for first, last names and phone number for each object in the form of String.
    - The program will display the corresponding message for each command pressed
    - The program will continue until 'q' is pressed, upon which it terminates
 */
package Phonedir;

import java.util.*;

public class phonedir 
{
    public static void main (String[] args)
    {
        System.out.println("A Program to keep a Phone Directory:\n\n");
        LinkedList<records> record = new LinkedList<records> ();
        records obj, temp;
        int select = -1;        //current linkedlist selection "pointer"
        // loops forever until 'q' is pressed
        while (true)
        {
            showMenu();     //prints menu items
            Scanner scan = new Scanner(System.in);
            char input = scan.next().toLowerCase().charAt(0);
            //scenario for each user key press
            switch (input)
            {
                //displays all record
                case 'a':
                    System.out.println("\nFirst Name\t\tLast Name\t\tPhone Number\n");
                    System.out.println("---------------------------------------------------------------------");
                    //loops through all record
                    for (int i=0; i<record.size(); i++)
                    {
                        System.out.println("\n" + record.get(i).getfName() + "\t\t\t" + record.get(i).getlName() + "\t\t\t" + record.get(i).getPhoneNo());
                    }
                    break;
                //deletes current record    
                case 'd':
                    if (select>=0)
                    {
                        System.out.println("Record removed: " + record.get(select).getfName() + " " + record.get(select).getlName() + " " + record.get(select).getPhoneNo());
                        record.remove(select);
                        select = -1;                        
                    }else
                    {
                        System.out.println("No current record");
                    }
                    
                    break;
                //changes first name of object at current position of linked list    
                case 'f':
                    if (select>=0)
                    {
                        System.out.print("Please enter the new first name:\t");
                        String nFN = scan.next();
                        record.get(select).setfName(nFN);
                        System.out.println("Current record is: " + record.get(select).getfName() + " " + record.get(select).getlName() + " " + record.get(select).getPhoneNo());
                    }else
                    {
                        System.out.println("No current record");
                    }                    
                    break;
                //changes last name of object    
                case 'l':
                    if (select>=0)
                    {
                        System.out.print("Please enter the new last name:\t");
                        String nLN = scan.next();
                        temp = record.get(select);  //copy into another object
                        record.remove(select);      //remove old object
                        temp.setlName(nLN);         //change last name
                        //adds to first if linked list is empty
                        if (record.isEmpty() )
                        {
                            record.addFirst(temp);
                            select = 0;
                        //if not empty
                        } else if (record.getLast().getlName().compareToIgnoreCase(temp.getlName() ) > 0)
                        {
                            for (int i=0; i<record.size(); )
                            {
                                //compare last name of the last record and new record
                                //if new last name is prior to last record's last name
                                //then add to position, if not, iterate 
                                if (record.get(i).getlName().compareToIgnoreCase(temp.getlName() ) > 0)
                                {
                                    record.add(i, temp);
                                    select = i;
                                    break;
                                }else
                                {              
                                    i++;
                                }
                            }
                        } else      //if new last name has later alphabet than all present last names in record
                        {
                            record.addLast(temp);
                            select = record.size()-1;      
                        }                        
                        System.out.println("Current record is: " + record.get(select).getfName() + " " + record.get(select).getlName() + " " + record.get(select).getPhoneNo());
                    }else
                    {
                        System.out.println("No current record");
                    }      
                    break;
                //creates new records object and adds it to linked list    
                case 'n':                    
                    System.out.print("Enter first name:\t");                    
                    String fN = scan.next();                                     
                    
                    System.out.print("Enter last name:\t");
                    String lN = scan.next();
                    
                    System.out.print("Enter phone number:\t");
                    String pN = scan.next();
                    
                    obj = new records(fN, lN, pN);
                    //adds to first if linked list is empty
                    if (record.isEmpty() )
                    {
                        record.addFirst(obj);
                        select = 0;
                    //if not empty    
                    } else if (record.getLast().getlName().compareToIgnoreCase(obj.getlName() ) > 0)
                    {
                        for (int i=0; i<record.size(); )
                        {
                            if (record.get(i).getlName().compareToIgnoreCase(obj.getlName() ) > 0)
                            {
                                record.add(i, obj);
                                select = i;
                                break;
                            }else
                            {              
                                //System.out.println("testing!!! "+  record.getLast().getlName().compareToIgnoreCase(obj.getlName()));
                                i++;
                            }
                        }
                    //compare last name of the last record and new record
                    //if new last name is prior to last record's last name
                    //then add to position, if not, iterate 
                    } else 
                    {
                        record.addLast(obj);
                        select = record.size()-1;      
                    }
                    System.out.println("Current record is " + record.get(select).getfName() + " "+ record.get(select).getfName() +", " + record.get(select).getPhoneNo());                    
                    break;
                //changes phone number of object at current linked list    
                case 'p':
                    if (select>=0)
                    {
                        System.out.print("Please enter the new phone number:\t");
                        String nPN = scan.next();
                        record.get(select).setPhoneNo(nPN);
                        System.out.println("Current record is: " + record.get(select).getfName() + " " + record.get(select).getlName() + " " + record.get(select).getPhoneNo());
                    }else
                    {
                        System.out.println("No current record");
                    }
                    break;
                //exits program, breaks while loop    
                case 'q':                    
                    System.exit(0);
                    break;
                //changes current linked list selection    
                case 's':
                    int counter = 0;
                    //if linked list is not empty
                    if (!record.isEmpty() )
                    {
                        System.out.print("Please enter the first name:\t");
                        String sFN = scan.next();

                        System.out.print("Please enter the last name:\t");
                        String sLN = scan.next();
                        
                        for (int i=0; i<record.size(); counter++)                            
                        {
                            //if first and last names that user entered match the
                            //first and last names of any of the objects in linked list
                            if ( !( (record.get(i).getfName().compareToIgnoreCase(sFN) == 0) && (record.get(i).getlName().compareToIgnoreCase(sLN) == 0) ) )
                            {
                                i++;
                            }else
                            {
                                select = i;
                                System.out.println("Current record is: " + record.get(select).getfName() + " " + record.get(select).getlName() + " " + record.get(select).getPhoneNo());
                                break;
                            }
                        }
                        //if there was no match of both in the linked list
                        if (counter > record.size()-1)
                        {
                            System.out.println("No matching record found\n");
                        }
                    }else       //if linked list was empty
                    {
                        System.out.println("No matching record found\n");
                    }
                    break;
                //if user enters non-specified command 
                default:
                    //throw new IllegalArgumentException("Please enter the correct command: " + input);
                    System.out.println("Please enter the correct command.");
                    break;
            } //end of switch
        } //end of while
                
    } //end of main method  
    //prints menu items
    //Precondition: takes nothing
    //Postcondition: no return, just prints menu    
    public static void showMenu()
    {
        System.out.println("\na     Show all records\n");
        System.out.println("d     Delete the current record\n");
        System.out.println("f     Change the first name in the current record\n");
        System.out.println("l     Change the last name in the current record\n");
        System.out.println("n     Add a new record\n");
        System.out.println("p     Change the phone number in the current record\n");
        System.out.println("q     Quit\n");
        System.out.println("s     Select a record from the record list to become the current record\n");
        System.out.println("\nPlease select the command from the list: \n");
    }   
} //end of class
