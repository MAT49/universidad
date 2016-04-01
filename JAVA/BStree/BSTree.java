/*  BSTree.java     @author: Ha K Hwang     CSC 3410     4/22/2015
       
Purpose:
    The purpose of this program is to gain experience with Binary Search Trees, by doing the following:

        1. Generate 50 random integer numbers ranging from 1 – 99.
        2. Store these numbers in a data structure of your choice and display the data on the screen.
        3. Now build a Binary Search Tree using this set of numbers.
        4. After building the tree, use an infix recursive method to display the data on the screen. 
        5. To build the Binary Search Tree, you must create your own Linked List. 

    The output will look like:

        numbers are : 15 70 52 47 8 85 78 29 17 8 73 7 45 99 84 21 84 20 44 13 20 56 78 31 59 13 82 47 67 36 40 13 57 41 21 49 82 61 64 69 94 48 12 23 57 17 43 8 92 33 

         data is : 7 8 8 8 12 13 13 13 15 17 17 20 20 21 21 23 29 31 33 36 40 41 43 44 45 47 47 48 49 52 56 57 57 59 61 64 67 69 70 73 78 78 82 82 84 84 85 92 94 99 BUILD SUCCESSFUL (total time: 0 seconds)

Solution:
    - Generate 50 random integers and assign it to an Array
    - Create a class to mimick a Node
    - Create a class to mimick a LinkedList
    - Create a method inside mimicked LinkedList to add Nodes
    - Create a method inside mimicked LinkedList to carry out infix operation
    - Create method to print out results
  
Data structures to be used: 
    - 1 Lingk class : to mimick Node of LinkedList (data, pointer to left/right child)
    - 1 Lingklist : to mimick LinkedList (add Nodes, infix return Nodes methods)
    - 1 Array : initial random generated numbers stored

           
Description of how to use program and expected input/output:
    - The program requires no initial user input
    - The program will display the 50 random integers
    - The program will display the 50 numbers using infix operation
 */

package BStree;
import java.util.Random;

public class BSTree {
    
    public static void main(String args[] )
    {
    
        int[] array = new int[50];
        
        //create 50 random integers from 1 to 99
        int minNum = 1;
        int maxNum = 99;
        Random random = new Random();
        int randomNum = random.nextInt((maxNum - minNum) + 1) + minNum;
        
        //print out 50 random integers
        System.out.print("\n\nnumbers are : ");
        for (int i=0; i<50; i++)
        {
            array[i] =  random.nextInt((maxNum - minNum) + 1) + minNum;
            System.out.print(array[i] +" ");
        }
        
        //creates linked list        
        Lingklist list = new Lingklist();
        
        for (int i=0; i<50; i++)
        {
            list.add(array[i]);
        }
        
        //print out infix result
        System.out.print("\n\n data is : ");
        list.infix();
    }
}
