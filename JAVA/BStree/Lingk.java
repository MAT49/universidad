/* @author: Ha K Hwang 

Purpose
    The purpose of this class is to create blueprint for Lingk data structure.
It will mimick a node of linked list, and contain the data portion, pointer to
the right child, and to the left child.
*/
package BStree;

public class Lingk {    
  
    int data;
    Lingk rc;   //link to right child
    Lingk lc;   //link to left child
    
    //constructor
    public Lingk(int b)
    {
        data = b;
        rc = null;
        lc = null;                
    }

}