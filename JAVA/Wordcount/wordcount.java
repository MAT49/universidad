/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wordcount;
import java.util.*;
import java.io.*;

public class wordcount {
    
            
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        //Requests user input for the file they want to scan.  They must include the full path name
        System.out.print("Please enter the name of the file: ");
        //Creates a new scanner and reads the whole next line entered by the user, assigning it to "fileName"
        //then closes the scanner
        String fileName = scanner.nextLine();
        
        //Constructs a new PrintWriter that is empty and 
        //Tries to create the output file and exits the program if it fails
        PrintWriter output = null;
        try
        {
            //Creates the output file in the running directory
            output = new PrintWriter(new FileWriter("output.txt"));

            //Constructs a new input file to read as null and opens the requested file.
            Scanner fileinput = null;
            File inFile = new File(fileName);
           
            //Tries to open the file, exits the program if it fails
            try
            {    
                int wordCount = 0; 
                int lineCount = 0;
                int alphanumCount = 0;
                int sentCount = 0;
                int vowelCount = 0;
                int punctCount = 0;
                StringTokenizer st;
                char[] charArray;
                
                //Scans the file, line by line until the end                
                fileinput = new Scanner(inFile);
                while(fileinput.hasNext())
                {         
                    //Converts the line to a string 
                    String input = fileinput.nextLine();                    
                    //Do all of your analysis of the line......
                    lineCount++;
                    st = new StringTokenizer(input, " ");
                    while( st.hasMoreTokens()) 
                    {
                        wordCount++;
                        input = st.nextToken();
                        
                        if (input.matches(".*[.!?].*{1,3}"))
                                sentCount++;

                        for (int i = 0; i < input.length(); i++)
                        {
                            //System.out.println(input.charAt(i));
                            if (Character.toString(input.charAt(i)).matches("[a-zA-Z0-9]"))
                                alphanumCount++;

                            if (Character.toString(input.charAt(i)).matches("[aeiouAEIOU]"))
                                vowelCount++;

                            if (Character.toString(input.charAt(i)).matches("[^a-zA-Z0-9]"))
                                punctCount++;
                        }  
                    }
                }
                //checks for empty input file and terminates program if so
                if (inFile.length() <= 0)
                {
                    System.out.println("The input file is empty");
                    System.exit(1);
                }
                
                System.out.println("Total words: " + wordCount);
                output.println("Total words: " + wordCount);
                System.out.println("Total lines: " + lineCount);
                output.println("Total lines: " + lineCount);
                System.out.println("Total alphanumeric characters: " + alphanumCount);
                output.println("Total alphanumeric characters: " + alphanumCount);
                System.out.println("Total sentences: " + sentCount);
                output.println("Total sentences: " + sentCount);
                System.out.println("Total vowels: " + vowelCount);
                output.println("Total vowels: " + vowelCount);
                System.out.println("Total punctuations: " + punctCount);
                output.println("Total punctuations: " + punctCount);
            }
                
            //If the input file isn't found, print an error and exit
            catch(FileNotFoundException e)
            {
                System.out.println("The input file does not exist");
                System.exit(1);
            }
            finally
            {
                fileinput.close();
            }
        }
        
        //If the output file isn't able to be written, print an error and exit
        catch(IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
        finally 
        {
             output.close(); 
        } 
    }
}