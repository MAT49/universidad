/*  calc.java     @author: Ha K Hwang     CSC 3410     3/30/2015
       
Purpose:
    The purpose of this program is to gain experience to gain experience with the Stack Data Structure and the library,and to use as many generic algorithms as possible.
    This program evaluates an infix expression entered by the user. The expression may contain the following characters:
    (1)   Integer constants (a series of decimal digits)
    (2)   x (representing a value to be supplied later)
    (3)   Binary operators (+, -, *, / and %)
    (4)   Parentheses
    Program works both with spaces and without spaces. The program converts the expression to postfix (RPN) form and display the converted expression.  
    The program repeatedly prompts the user for the value of x, displaying the value of the expression each time. 
    When the user enters the letter q instead of a number, the program terminates.
     
    The output will look like:

        Enter infix expression: (x + 1) * (x - 2) / 4
        Converted expression: x 1 + x 2 - * 4 /

        Enter value of x: 5
        Answer to expression: 4

        Enter value of x: 7
        Answer to expression: 10

        Enter value of x: q       

Solution:
    - Create char operator Stack to hold x / % + -
    - Create temp String to hold operands
    - Create loop to iterate by each character
    - Create conditions inside loop to convert infix to postfix
    - Create loop to test various user entry errors
    - Create int operand Stack to hold integers in postfix
    - Create loop to iterate by each substring in postfix
    - Create conditions to inside loop to carry out calculations
    - Create switch or if/else if for each operator in conditions
    - Create method to print out results
    - Create while loop to continue running program until 'q' is pressed
    - Create method to terminate program when 'q' is pressed
  
Data structures to be used: 
    - Two Stack : one Int object for operands, one Char object for operators 
           
Description of how to use program and expected input/output:
    - The program requires user input for infix equation
    - The program requires user input for x (or q to quit)
    - The program will display the postfix (RPN) equation
    - The program will display the result of the calculation
    - The program will continue until 'q' is pressed, upon which it terminates
 */
package Calc;
import java.util.*;

public class calc {
public static void main(String args[] )
{   
    while(true)     //loop always unless stopped below with 'q'
    {
        String temp = "";        
        String[] parts;
        String intermediate = "";
        Stack<Character> operators = new Stack<Character>();
        Stack<Integer> operands = new Stack<Integer>();
        int leftParenthesis = 0, rightParenthesis = 0;
        boolean parenthesis = false, operatorFlag = false, secondFlag = false;
        boolean charFlag = false, charFlag2 = false, charFlag3 = false;
        int left = 0, right = 0, result = 0;
        String operation = " "; 
        
        //Prompts user for infix
        System.out.print("\nEnter infix expression: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        //if nothing entered, exit
        if ( input.isEmpty())
        {
            System.out.println("ERROR!!!  No input entered!");
            System.exit(1);
        }        
         //Error check: last token must be an operand.
        if ( input.charAt(input.length()-1) == '*' || input.charAt(input.length()-1) == '/' || input.charAt(input.length()-1) == '%' || input.charAt(input.length()-1) == '+' || input.charAt(input.length()-1) == '-' )
        {
            System.out.println("Error in expression!! Last token must be an operand or right parenthesis.");
            System.exit(1);
        }
        //iterates through each character to detect some errors
        for (int i=0; i<input.length(); i++ )
        {           
            if ( (input.charAt(i) >= '0' && input.charAt(i) <= '9') )
            {
                temp += input.charAt(i);                
            }
            else
            {                  
                temp += " " + input.charAt(i) + " ";
                //if floating number is found, then exit
                if (input.charAt(i) == '.')
                {
                    System.out.println("Error in expression!! Cannot accept floating point numbers.");
                    System.exit(1);
                }
                if (input.charAt(i) == '(' )
                {
                    leftParenthesis++;
                }
                if (input.charAt(i) == ')' )
                {
                    rightParenthesis++;
                }
            }
        }
//        System.out.println(temp);
        
        //Error, parenthesis count match, left and right 
        if (leftParenthesis != rightParenthesis)
        {
            System.out.println("Error in expression!! No matching left parentheses for a right parentheses.");
            System.exit(1);
        }
        //always wanted to try iterating String by character...
        //iterates String backwards by character to find errors
        for (int i=temp.trim().length()-1; i>=0; i-- )
        {
            //Ding Dong Dang flag settings to capture "no operator between operands" error
            //always wnated to try this inefficient method, charFlag2 is set for space
            //space which I could have knocked out by using String.split()...
            if (charFlag2)
            {
                if ( (temp.charAt(i) >= '0' && temp.charAt(i) <= '9') || temp.charAt(i) == 'x') 
                {
                    charFlag3 = true;
                    break;
                }
                else if (temp.charAt(i) == ' ')
                {
                    charFlag2 = true;
                    charFlag = false;
                }
                else
                {
                    charFlag3 = false;
                    charFlag2 = false;
                    charFlag = false;
                }
            }            
            if (charFlag)
            {
                if (temp.charAt(i) == ' ')
                {
                    charFlag2 = true;
                    charFlag = false;
                }
                else if ( temp.charAt(i) == '*' || temp.charAt(i) == '/' || temp.charAt(i) == '%' || temp.charAt(i) == '+' || temp.charAt(i) == '-')
                {
                    charFlag2 = false;
                    charFlag = false;
                }
                else
                {                 
                    charFlag2 = false;
                    charFlag = true;
                }
            }
            //
            if (i != 0)            
            {
                if ( (temp.charAt(i) >= '0' && temp.charAt(i) <= '9') || temp.charAt(i) == 'x') 
                {
                    charFlag = true;
                }
            }
            //double boolean flags to find ' * * ' type error 
            if (operatorFlag)
            {
                if ( temp.charAt(i) == '*' || temp.charAt(i) == '/' || temp.charAt(i) == '%' || temp.charAt(i) == '+' || temp.charAt(i) == '-')
                {
                    secondFlag = true;
                    break;
                }
                else if ( temp.charAt(i) == ' ')
                {
                    //nothing
                }
                else
                {                    
                   operatorFlag = false;
                }
            }
            if ( temp.charAt(i) == '*' || temp.charAt(i) == '/' || temp.charAt(i) == '%' || temp.charAt(i) == '+' || temp.charAt(i) == '-')
            {
                operatorFlag = true;
            }
            //simple boolean flag to find  '12 ( ' type error
            if (parenthesis)
            {
                if ( temp.charAt(i) == '*' || temp.charAt(i) == '/' || temp.charAt(i) == '%' || temp.charAt(i) == '+' || temp.charAt(i) == '-')
                {
                    parenthesis = false;
                }
                else if ( temp.charAt(i) == ' ')
                {
                    //nothing
                }
                else
                {                    
                    break;
                }
            }
            if (i != 0)
            {
//                System.out.println("i is " + i);
                if ( temp.charAt(i) == '(' )
                {
                    parenthesis = true;
                }
            }
            else
            {
                parenthesis = false;
            }
            
        }
//        System.out.println(charFlag);
//        System.out.println(charFlag2);
//        System.out.println(charFlag3);
//        System.out.println(parenthesis);
//        System.out.println(operatorFlag);
//        System.out.println(secondFlag);
        if (charFlag3)
        {
            System.out.println("Error in expression!! No operator between operands...");
        }
        if (parenthesis)
        {
            System.out.println("Error in expression!! No operator between operand and left parentheses.");
            System.exit(1);
        }
        if (operatorFlag == true && secondFlag == true)
        {
            System.out.println("Error in expression!! The operator cannot be preceded by another operator.");
            System.exit(1);
        }
        //preliminary error checking finished. Now to convert to postfix...
        //loops through each character in user entered String
        //it's long because it goes by each character including space... 
        for (int i=0; i<input.length(); i++ )
        {
            //still using character loop, find non-single char numbers like 34
            if ( (input.charAt(i) >= '0' && input.charAt(i) <= '9') )
            {
                intermediate += input.charAt(i);
                if (i == input.length()-1)
                {
                    intermediate += " ";
                }
            }
            //if not a number, then it's x, (), or operators
            else
            {   
                intermediate += " ";        //adds space if char is not numeric
                if (input.charAt(i) == 'x')
                {
                    intermediate += input.charAt(i) + " ";
                }
                //parenthesis
                else if (input.charAt(i) == '(' )
                {
                    leftParenthesis++;
                    operators.push(input.charAt(i));
                }
                else if (input.charAt(i) == ')' )
                {
                    rightParenthesis++;
                    while (!operators.empty() )
                    {
                        if (operators.peek() == '(' )
                        {
                            operators.pop();        //pops ')' once 
                            break;                            
                        }
                        else
                        {
                            intermediate += operators.pop() + " ";    //pops operators above (
                        }         
                    }
                }
                //if + or -    
                else if (input.charAt(i) == '+' || input.charAt(i) == '-')
                {     
                    if (!operators.empty() )
                    {
                        if (operators.peek() != '(' )
                        {                                             
                            intermediate += operators.pop() + " ";    //pops all * / %  
                            operators.push(input.charAt(i));    //adds + - once
                        }
                        else
                        {
                             operators.push(input.charAt(i));    //adds + - once
                        }
                    }
                    else
                    {
                        operators.push(input.charAt(i));    //adds + - once
                    }
                }
                //if * / %
                else if (input.charAt(i) == '*' || input.charAt(i) == '/' || input.charAt(i) == '%' )
                {                   
                    if (!operators.empty() )
                    {
                        if (operators.peek() != '(' )
                        {                     
                            if (operators.peek() == '*' || operators.peek() == '/' || operators.peek() == '%' )
                            {
                                intermediate += operators.pop() + " ";    //pops all * / %
                                operators.push(input.charAt(i));    //adds + - once
                            }                    
                            else 
                            {
                                operators.push(input.charAt(i));    //adds + - once
                            }
                        }
                        else
                        {
                             operators.push(input.charAt(i));    //adds + - once
                        }
                    }
                    else{
                        operators.push(input.charAt(i));    //adds + - once
                    }
                }
                else if (input.charAt(i) == ' ')
                {
                    //does nothing if char is blank
                } 
                //if user throws anything except int, x, (), or */%+-
                else
                {
                    System.out.println("ERROR! something unintended like a b c...");
                    System.exit(1);     //something not intended
                }
            } //end of if else
            
 //            System.out.println("String :" + intermediate);
 //            if (!operators.empty())
 //            {
 //                System.out.println("Operator Top:" +operators.peek() );
 //            }                   
        } //end of for loop
        
        //pops out all operators in Stack
        while (!operators.empty())
        {
            intermediate += operators.pop() + " ";
        }        
        //enough iterating by character fun...now switching to easier method
        //prints out postfix, using String.split()
        parts = intermediate.trim().split(" +");
        System.out.print("Converted expression: ");
        for (String j : parts)
        { 
            System.out.print(j + " ");
        }
//        System.out.println("q is numerically " + (int)'q');        
        //quit if 'q' is entered
        System.out.print("\n\nPress 'q' to quit or Enter value of x: ");
        String x = scan.nextLine().trim();      //works with q with spaces
        //quits program if 'q' is entered
        if ( x.length() == 1 && x.equalsIgnoreCase("q") )  //works with Q
        {
            System.out.println("Goodbye.");
            System.exit(0);            
        }        
        int intX = Integer.parseInt(x);     //convert x to integer
        //3 scenarios from the new String array: x, integers, or */*-+
        for (int i=0 ; i < parts.length; i++)
        {
            if (parts[i].matches("x"))
            {
                operands.push(intX);
//                System.out.println("x match, top is " + operands.peek());
            }
            else if (parts[i].matches("\\d+"))
            {
                operands.push(Integer.parseInt(parts[i]));
//                System.out.println("number match, top is " + operands.peek());
            }
            else 
            {
                right = operands.pop();
                left = operands.pop();
                operation = parts[i];
//                System.out.println("i is " + i + " and value is " + parts[i]);
                //cases for each operator
                switch (operation)
                {
                    case "*":
                        result = left * right;
                        operands.push(result);
                        break;
                    case "/":
                        result = left / right;
                        operands.push(result);
                        break;
                    case "%":
                        result = left % right;
                        operands.push(result);
                        break;
                    case "+":
                        result = left + right;
                        operands.push(result);
                        break;
                    case "-":
                        result = left - right;
                        operands.push(result);
                        break;
                    default:
                        throw new IllegalArgumentException("Incorrect symbol used: " + input); 
                }
            }
        }        
//        System.out.println("final top is " + operands.peek());        
        System.out.println("Answer to expression: " + result);
    } //end of while loop
} //end of main method
} //end of class
