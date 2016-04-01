/*  teller.java     @author: Ha K Hwang     CSC 3410     4/13/2015 

Purpose
    The purpose of this class is to create a blueprint for "teller" at a bank.
    Each teller keeps counts of customers seen, busy time with customer, and
    time until serving next customer.
*/
package Bank;

public class teller 
{
    public int custSeen;
    public int busyTime;
    public int timeToFree;
    
    public teller()
    {
        custSeen = 1;
        busyTime = 0;
        timeToFree = 0;
    }
}
