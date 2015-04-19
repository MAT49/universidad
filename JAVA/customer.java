/*  customer.java     @author: Ha K Hwang     CSC 3410     4/13/2015

Purpose
    The purpose of this class is to create a blueprint for "customer" at a bank.
    Each customer has a predetermined time he/she will spend with a teller, 
    randomly generated between 2-5 seconds.
*/
package Bank;

import java.util.Random;

public class customer {
    public int timeNeeded;
    
    int minNum = 2;
    int maxNum = 5;
    Random random = new Random();
    
    //generate random number
    int randomNum = random.nextInt((maxNum - minNum) + 1) + minNum;
    
    public customer()
    {
        timeNeeded = randomNum;
    }
}
