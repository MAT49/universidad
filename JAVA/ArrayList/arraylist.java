/* @author: Ha K Hwang      
       
Purpose:
    The purpose of this program is to implement the ArrayList data Structure that exist in the java library. The class should accept any type of Objects.
    
    The output will look like:

    ArrayList.arraylist@15db9742 has been created
    ArrayList.arraylist@6d06d69c has been created
    --------------------------------------
    null
    null
    null
    null
    4
    --------------------------------------
    null
    null
    null
    null
    4
    test
    null
    null
    null
    null
    --------------------------------------
    null
    null
    Z
    null
    null
    4
    test
    null
    null
    null
    --------------------------------------
    ArrayList.arraylist@6d06d69c has value of Z at index 2
    ArrayList.arraylist@6d06d69c has a size of 10
    is ArrayList.arraylist@6d06d69c empty? : false
    is ArrayList.arraylist@15db9742 empty? : true
    is Z in the arraylist? true
    is Z in the arraylist? false
    the location of 'test' is 6
    the location of 5 is -1
    --------------------------------------
    null
    null
    Z
    null
    null
    4
    test
    null
    null
    null
    --------------------------------------
    null
    null
    null
    null
    4
    test
    null
    null
    null  

Solution: 
    - Create constructor for default Object array with size 10
    - Create constructor for user defined Object array with size n
    - Create method to get index of array
    - Create method to get size of array
    - Create method to find if array is empty (i.e. null)
    - Use above to create method to add an Object to the end of array
    - Use above to create method to add an Object at specified index
    - Create method to find if an Object is present in array
    - Create method to find index of an Object
    - Create method to remove an Object from an array and reduce size by one      
  
Data structures to be used: 
    - One Object array to hold initial objects
    - Three Object arrays to hold newly sized arrays for adding/subtracting
           
Description of how to use program and expected input/output:
    - The program does not require any user input.
    - The program will output 56 lines of text containing:
        creation of empty arrays, arrays with values added, value of Object at index, array size, whether array is empty, 
        if a value is in the array, index of a value if present, index of a value, and removal of a value from array
 */
package ArrayList;

public class arraylist {
    Object[] al, al2, al3, al4;
    int num;    //size of array
    int increment;  //array increment value
    int loc;    //index of array
    //default constructor creatse an arraylist object with a default size of 10
    public arraylist(){
        num = 10;
        increment = 10;
        al = new Object[num];
    }
    //constructor accepts a parameter of type int and sets the size
    public arraylist(int n){
        num = n;
        increment = n;
        al = new Object[num];         
    }
    //places a value at the end of the arraylist
    //Precondition: Takes an Object
    //Postcondition: No return.
    public void add(Object x)
    {
        if (al[al.length-1] == null)
            al[al.length-1] = x;
        else
        {
            num += increment;
            al2 = new Object[num];
            System.arraycopy(al, 0, al2, 0, al.length);
            al2[al.length] = x;
            al = al2;
        }        
    }       
    //places a value at a given location
    //Precondition: Takes an int and an Object
    //Postcondition: No return.
    public void add(int index, Object x)
    {
        int ind = index;
        if (al[al.length-1] == null)
        {
            for (int i = al.length-2; i>=ind; i--)
            {
                al[i+1] = al[i];
            }
            al[ind] = x;
        } else
        {
            num += increment;
            al3 = new Object[num];
            System.arraycopy(al, 0, al3, 0, ind-1);
            al3[ind] = x;
            System.arraycopy(al, ind, al3, ind+1, al.length-ind);                        
            al = al3;         //redirect al address to al3 array address   
        }
    //System.out.println("num is " + num);
    }    
    //retrieves a value from a given location
    //Precondition: Takes an int
    //Postcondition: return an Object.
    public Object get(int index)
    {
        return al[index];
    }
    //number of elements in the the arraylist
    //Precondition: No parameter
    //Postcondition: returns an int.
    public int size()
    {
        return al.length;
    }
    //checks if the arraylist is empty
    //Precondition: No parameter
    //Postcondition: returns a boolean.
    public boolean isEmpty()
    {
        boolean empty = true;
        for (int i=0; i<=al.length-1; i++) {
            if (al[i] == null) {
                empty = true;
            } else
            {
                empty = false;
                break;
            }
        }
        return empty;
    }
    //checks if a particular object exist in the arraylist
    //Precondition: takes an Object
    //Postcondition: returns a boolean.
    public boolean isIn(Object ob)
    {
        boolean isIt = false;
        if (isEmpty() != true)
        {
            for (int i = 0; i<=al.length-1; i++)
                {
                    if (al[i] == ob) {
                        isIt = true;
                        break;
                    } else
                    {
                        isIt = false;
                    }
                }                
        }
        return isIt;
    }    
    //return the location of first occurrence of an Object starting from index 0
    //Precondition: takes an Object
    //Postcondition: returns an int, loc variable points to index.
    public int find (Object n)
    {
        loc = -1;   //returns -1 if search item is not in the arraylist
        if (isEmpty() != true)
        {
            for (int i = 0; i<=al.length-1; i++)
                {
                    if (al[i] == n) {
                        loc = i;
                        break;
                    } 
                }                
        }
        return loc;
    }    
    //removes the first occurrence of an Object starting from location 0
    //Precondition: takes an Object
    //Postcondition: No return.
    public void remove (Object n)
    {        
        if (find(n) >= 0)
        {
            al4 = new Object[num-1];
            System.arraycopy(al, 0, al4, 0, loc-1);
            System.arraycopy(al, loc+1, al4, loc, al.length-loc-1);        
            al = al4;
        }
    }    
    /* function to check if content is an object
    public void myMethod(Object obj) {
    if (obj instanceof Object) {
        System.out.println("It's an Object");
    }
    else {
        System.out.println("******NOT an Object");
    }
    */
}
