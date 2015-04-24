/* @author: Ha K Hwang 

Purpose
    The purpose of this program is to test the arraylist data structure created in arraylist.java. 
    It tests all ten of the mentioned constructors/methods. 
*/
package ArrayList;
public class testarray {

    public static void main(String args[] )
    {
        //1
        arraylist test1 = new arraylist();
        System.out.println(test1 + " has been created");
        //2
        arraylist test2 = new arraylist(5);
        System.out.println(test2 + " has been created");
        System.out.println("--------------------------------------");
        //3
        test2.add(4);
        for (int i = 0; i <= test2.size()-1; i++)
        {
            System.out.println(test2.get(i));
        }
        System.out.println("--------------------------------------");
        test2.add("very long string");
        for (int i = 0; i <= test2.size()-1; i++)
        {
            System.out.println(test2.get(i));
        }        
        System.out.println("--------------------------------------");
        //4
        test2.add(2, 'Z');
        test2.add(9, 'W');
        test2.add(9, "another long string to see");
        test2.add(14, "string size should increase");
        test2.add(14, "oh nice!");     
        for (int i = 0; i <= test2.size()-1; i++)
        {
            System.out.println(test2.get(i) );
        }
        System.out.println("--------------------------------------");
        //5
        System.out.println(test2 + " has value of " + test2.get(2) + " at index 2");
        //6
        System.out.println(test2 + " has a size of " + test2.size());
        //7
        System.out.println("is " + test2 + " empty? : " + test2.isEmpty());
        System.out.println("is " + test1 + " empty? : " + test1.isEmpty());
        //8
        System.out.println("is Z in the arraylist? " + test2.isIn('Z') );
        System.out.println("is Z in the arraylist? " + test2.isIn('a') );
        //9
        System.out.println("the location of 'test' is " + test2.find('W'));
        System.out.println("the location of 5 is " + test2.find(5));
        System.out.println("--------------------------------------");
        //10
        test2.remove(3);
        for (int i = 0; i <= test2.size()-1; i++)
        {
            System.out.println(test2.get(i));
        }
        System.out.println("--------------------------------------");
        test2.remove('Z');
        for (int i = 0; i <= test2.size()-1; i++)
        {
            System.out.println(test2.get(i));
        }
    }           
}
