/* @author: Ha K Hwang 

Purpose
    The purpose of this class is to create a blueprint for linked list-like
data connecting nodes. It contains methods to add each node to appropriate
location (left child, right child) and to output the infix conversion result.
*/
package BStree;
public class Lingklist {
    
    Lingk head;     //first node
    
    //constructor
    public Lingklist(){
         head = null;       //first node object set to null
    }  

    //recursive method compares value, then assigns left/right child position, 
    //then creates a Lingk (Node) in that position
    //Precondition: takes Lingk object and int 
    //Postcondition: returns Lingk object
    public Lingk add(Lingk old, int next)
    {
        if (old == null)
        {
            old = new Lingk(next);    //Lingk object created if empty
        }
        else
        {
            if (next < old.data)      //if value is less, assign to left child
            {
                old.lc = add(old.lc, next);
            }
            else        //else, assign to right child
            {
                old.rc = add(old.rc, next);
            }
        }
        return old;
    }
    //method starts off recursive method add(Lingk old, int next) 
    //Precondition: takes int
    //Postcondition: calls recursive method add(Lingk old, int next)    
    public void add(int next)
    {
        head = add(head, next);     //starts from first Node, and calls other add method
    }  
    
    
    //recursive infix method carries out infix conversion of binary tree contained Lingk objects
    //Precondition: takes Lingk object
    //Postcondition: returns nothing, prints the data (int) of current Lingk
    public void infix(Lingk object)
    {
        if (object != null)
        {
            infix(object.lc);
            System.out.print(object.data +" ");
            infix(object.rc);
        }
    }   
    //method starts recursive method infix(Lingk object)
    //Precondition: takes int
    //Postcondition: returns nothing, calls recursive method infix(object)
    public void infix()
    {
        infix(head);        //start from head, call the other infix method
    }

}