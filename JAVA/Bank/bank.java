/*  bank.java     @author: Ha K Hwang     CSC 3410     4/13/2015
       
Purpose:
    The purpose of this program is to gain experience with with Queues, to gain 
    experience with library functions that generates random numbers and provide 
    time, and to use arrays and/or vectors.
    This program runs for programmer-specified time (default is 120 seconds), 
    and simulates a Queue at a bank. Customers are randomly generated at 2-5 
    seconds, and occupy one of five tellers for a time of 2-6 seconds. 
    At the end of the time, program displays on the screen:

        The total amount of customers that visited the bank for that 2 minutes.
        The total amount of customers that each teller helped.
        The total amount of time that each teller was occupied.
        The total amount of customers that did not get to see a teller.
     
    The output will look like:

        Total number of customers for this interval is 40

        Total number of customers served by Bank.teller@7852e922 is 9
        Total amount of time teller #Bank.teller@7852e922 spent is 27 seconds

        Total number of customers served by Bank.teller@4e25154f is 9
        Total amount of time teller #Bank.teller@4e25154f spent is 24 seconds

        Total number of customers served by Bank.teller@70dea4e is 8
        Total amount of time teller #Bank.teller@70dea4e spent is 24 seconds

        Total number of customers served by Bank.teller@5c647e05 is 7
        Total amount of time teller #Bank.teller@5c647e05 spent is 21 seconds

        Total number of customers served by Bank.teller@33909752 is 7
        Total amount of time teller #Bank.teller@33909752 spent is 19 seconds

        Total number of customers who did not get served is 0


Would you like to run again? Press 'y' to run again, 'n' to quit:	

Solution:
    - Create teller class with counters for customers seen, busy time, countdown
    - Create customer class with randomly generated time needed with teller
    - Create loop to iterate once in every one second
    - Create conditions to inside loop to carry out counting
    - Create if/else if to offer into queue or poll out of queue 
    - Create method to print out results
    - Create while loop to run program again if 'y', and quit if 'n' is pressed
    - Create method to terminate program when 'n' is pressed
  
Data structures to be used: 
    - 1 ArrayList : customer objects (initial)
    - 1 Queue : customer objects (passed into from ArrayList)
    - 1 Array : 5 teller objects

           
Description of how to use program and expected input/output:
    - The program requires no initial user input
    - The program will display the total counts of customers served by each teller
    - The program will display the total time of each teller used to serve customers
    - The program will display the number of customers not served at the end
    - The program will display the total number of customers present at bank
    - The program will run again if 'y' is pressed, or quit if 'n' is pressed
 */
package Bank;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class bank {
    public static void main(String args[] )
    {   
        int numOfTellers = 5;
        int timeLimit = 120;         //time limit in seconds
        int countDown;
        int notServedTotal = 0;
        int custTotal = numOfTellers;    //initial total num of customers
        int custNotServed = 0;
   
        teller[] tellers = new teller[numOfTellers];
        ArrayList<customer> customers = new ArrayList<customer>();    
        Queue<customer> waitQueue = new LinkedList<customer>();

        //loops until user types 'n' on very bottom while loop    
        while(true)
        {
    //        customer one = new customer();
    //        System.out.println(one.timeNeeded);//
    //        teller first = new teller();
    //        System.out.println(first.custSeen + " " + first.busyTime + " " + first.timeToFree + " " + first.custTotal); 

            //create initial customers and tellers
            for (int i = 0; i < tellers.length; i++)
            {
               tellers[i] = new teller();      
               waitQueue.offer(new customer() );               
//               System.out.println(tellers[i]);
//               System.out.println(waitQueue.element() );
            }
            
            countDown = generateRandomNumber();            
            //continues for the timeLimit duration
            //http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/TimeUnit.html
            //http://stackoverflow.com/questions/2550536/java-loop-for-a-certain-duration
            for (long stop=System.nanoTime()+ TimeUnit.SECONDS.toNanos(timeLimit);stop>System.nanoTime();)
            {
                //cheap trick to force approximately 1 second iteration
                //http://smartsoftwarefactory.blogspot.com/2012/05/waning-threadsleep-called-in-loop.html
                try{Thread.sleep(1000);}catch(Exception e){}
                
                //creates customer for every 2-6 randomly generated seconds              
                if (countDown == 0)
                {
                    customers.add(new customer() );
                    waitQueue.offer(customers.remove(0));
                    countDown = generateRandomNumber();
                }
                countDown--;         
                
                //adds customer to Queue and starts counting
                if (!waitQueue.isEmpty() )
                    //System.out.println(waitQueue.element() );
                for (int i = 0; i < tellers.length; i++)
                {
                    if (tellers[i].timeToFree == 0)
                    {
                        if (!waitQueue.isEmpty() )
                        {
                            tellers[i].timeToFree = waitQueue.poll().timeNeeded;
                            tellers[i].custSeen++;
                            custTotal++;
                        }
                    } else
                    {
                        tellers[i].busyTime++;
                        tellers[i].timeToFree--;
                    }
                  
                } //end of for
            } //end of time duration "for loop"
            
            //count customers still in Queue after bank closes
            while (!waitQueue.isEmpty() )
            {
                waitQueue.poll();
                custNotServed++;               
            }
            
            custTotal += custNotServed; 
            
            //print various counters
            System.out.println("\n\nTotal number of customers for this interval is " + custTotal + "\n");
            
            for (int i = 0; i < tellers.length; i++)
            {
                System.out.println("Total number of customers served by " + tellers[i] + " is " + tellers[i].custSeen);            
                System.out.println("Total amount of time teller #" + tellers[i] + " spent is " + tellers[i].busyTime + " seconds\n");
            }
            
            System.out.println("Total number of customers who did not get served is " + custNotServed);
            
            //asks user to run program again if 'y' is pressed
            boolean askAgain = true;
            while (askAgain)
            {
                System.out.print("\n\nWould you like to run again? Press 'y' to run again, 'n' to quit:\t");
                Scanner input = new Scanner(System.in);
                char cond = input.next().charAt(0); 

                if (cond == 'y')
                {
                    askAgain = false;
                }
                else if (cond == 'n')
                {
                     System.exit(0);
                }
                else
                {            
                    System.out.println("Please enter 'y' or 'n'");
                }
            } //end of while
        } //end of while
    } //end of main method

    //method generates random number between 2-6
    //Precondition: takes nothing
    //Postcondition: returns int
    private static int generateRandomNumber()
    {                    
        int minNum = 2;
        int maxNum = 6;
        Random random = new Random();    
        int randomNum = random.nextInt((maxNum - minNum) + 1) + minNum;
        return randomNum;
    }
    
} //end of class
