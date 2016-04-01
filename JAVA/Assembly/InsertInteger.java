/*
Question (clarified with a function example).

You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
Write a method to insert M into N such that M starts at bit j and ends at bit i. 
You can assume that the bits j through i have enough space to fit all of M. 
That is, if M = 10011, you can assume that there are at least 5 bits between j and i. You
would not, for example, have j = 3 and i = 2, because M could not fully fit
between bit 3 and bit 2.

EXAMPLE
Input: N = 1024 = (10000000000) base 2,
       M = 19 = (10011) base 2
       i = 2
       j = 6

Output: N = (1100) base 10 = (10001001100) base 2

Write your program in high level language like C or Java.
You can test your program in your personal computer. Running on Solar machine is not 
required.

>> and << are shifting operators in C and Java language, & is logical AND, | is logical OR and 
~ is for 1's complement.
e.g of left shift:
int N = 1024;
int i = 2;
int m = N<<i;    // m = 4096


int embedMIntoN(int N, int M, int i, int j)
{
    
}
e.g .  
           int answer = embedMIntoN(1024, 19, 2, 6);
           answer =  1100 (decimal number)

Deadline: 22nd April Midnight.
 */
package Assembly;
import java.lang.*;
import java.util.*;


public class InsertInteger {

    static int M, N, i, j;
    
    public static void main(String args[])
    {
        
        //int base = 2;

        System.out.print("\nPlease enter decimal value for M: ");
        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        //M = Integer.parseInt(Integer.toString(scan.nextInt(), base ) );

        System.out.print("\nPlease enter decimal value for N: ");
        N = scan.nextInt();
        //N = Integer.parseInt(Integer.toString(scan.nextInt(), base ) );

        System.out.print("\nPlease enter decimal value for i: ");
        i = scan.nextInt();
        //i = Integer.parseInt(Integer.toString(scan.nextInt(), base ) );
        
        System.out.print("\nPlease enter decimal value for j: ");
        j = scan.nextInt();
        //j = Integer.parseInt(Integer.toString(scan.nextInt(), base ) );


        //System.out.println("\n\nM : " + M + "\tN : " + N + "\ti : " + i + "\tj : " + j);
        
        
        int answer = embedMIntoN(M, N, i, j);
        //int answer = embedMIntoN(1024, 19, 2, 6);
        System.out.println("\n" + answer + " is result when N is inserted to M from i to j positions");


    }
    //chops off right tail (left shift, then right shift)
    //clears bottom bits of left side of M (left shift, then right shift)
    //adds N to left side (OR)
    //shifts it by how many chopped right bits (left shift)
    //adds left side and chopped off right tail (OR)
    private static int embedMIntoN(int M, int N, int i, int j)
        {
            int bitSize = 32;

            int mR = M << (bitSize - i);
                //System.out.println(mR + " mR1");            
            mR = mR >>> (bitSize -i);   
                //System.out.println(mR + " mR2");
            
            int mL = M >>> (j+1);
                //System.out.println(mL + " mL1");                
            mL = mL << (j-i+1);
                //System.out.println(mL + " mL2");    
                
            int answer = mL | N; 
                //System.out.println(answer + " answer");
                
            answer = answer << i;
            
            answer = answer | mR;                
   
            return answer;

        }
 
}
