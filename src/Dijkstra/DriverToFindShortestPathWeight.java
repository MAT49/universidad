/*
 * Ha K Hwang
 * 3/26/2016
 */

package Dijkstra;
import java.io.*;
import java.util.Scanner;

// Visibility: package-wide only
// Driver program takes in a txt file
// and returns the shortest path cost
class DriverToFindShortestPathWeight {
    
    // class variables for total number of vertices and edges
    // I don't like using class variables, but this is the easiest way I found
    // to pass values from helper method to main method
    static int totalV, totalE;
    
    
    // main method
    public static void main (String[] args) throws IOException {
                
        // variables
        long beginTimer, endTimer;  // timer
        Node[] list;    // adjacency matrix array
        String fileName;    // input file name       
        int total;
                
        // calls class method helper              
        fileName = askUserInput();
                
        // starts timer
        beginTimer = System.currentTimeMillis();                
       
        // calls class helper method and saves input file as Node array object
        // forming a 2 dimensional array (adjacency matrix)
        list = readFileByLine(fileName);
               
        /*
        // @Quick Test Unit for 2d array population
        System.out.println(totalV + " " + totalE); 
        for (int i=0; i<list.length; i++)
        {
            System.out.println(list[i].nodeIndex + " " + list[i].priority);
            for (int j=0; j<list[i].nexts.size(); j++)
            {                                
                System.out.println(list[i].nexts.get(j) + " " + list[i].costs.get(j));
            }
        }
        */        
        
        // run Dijkstra algorithm and calculate sum of shortest paths and time
        total = Dijkstra.runDijkstra(list);        
        
        // ends timer
        endTimer = System.currentTimeMillis();
            
        System.out.println("Sum of shortest paths is " + total);
        System.out.println("Start time: " + beginTimer + "\tEnd time: " + endTimer);
        System.out.println("Elapsed time: " + (endTimer - beginTimer) + " milliseconds");       
        
    }  
    
    
    // this method prints message asking for user input
    // and returns a String
    private static String askUserInput()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter input file name: ");
        String fileName = input.nextLine();
        return fileName;
    }       
    
    
    // This Scanner method is modified from code available from
    // http://stackoverflow.com/questions/20311266/read-line-with-scanner by Dhanushka Gayashan
    // this method takes a fileName in String
    // and returns nothing        
    // Very tempting to make it a class method in a separate class
    // but the chance of seeing similar situation for such class is deemed low
    // also I hate passing many class variables, as I believe it makes data less encapsulated
    // so I'll use more memory space by holding this ArrayList in memory than using another class
    // that can be collected by Garbage Collector
    private static Node[] readFileByLine(String fileName) {               
        
        // declares array of Node objects
        Node[] list = null;
        
        // variable holds master origin node index
        // that stays same while adding its next nodes and cost info
        int originNode=0;
        
        // read file
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            
            // read first line for number of vertices and edges
            // two different approaches to trim alphabet and '=' from first line of input
            Scanner firstLine = new Scanner(scanner.nextLine().replaceAll("[a-zA-Z]=",""));
            String numVertices = firstLine.next().trim();
            String numEdges = firstLine.useDelimiter("[a-zA-Z]=").next().trim();
            
            // parse String into integers
            totalV = Integer.parseInt(numVertices);
            totalE = Integer.parseInt(numEdges);
            
            list = new Node[totalV];            
            //System.out.println(vertices + " " + edges);
            
            // instantiate array of Node objects
            // it is faster than using arraylist or linkedlist
            for (int i=0; i< list.length; i++)
            {
                list[i] = new Node(i);
            }
            
            // scans next line
            while (scanner.hasNextLine()) 
            {
                //System.out.println(scanner.nextLine());
                
                // splits next line into String arrays separated by spaces
                // where alphabet letters are removed
                String[] split = scanner.nextLine().replaceAll("[a-zA-Z]","").trim().split("\\s+");
                
                // if empty line, continue to next line         
                if (split[0].equals(""))
                    continue;
                else
                {                    
                    // if line contains only 1 element, it must be a originating node
                    // if 2 elements, they are (next node, cost) pair
                    switch(split.length)
                    {                    
                        case 1:               
                            String origin = split[0].trim();                            
                            originNode = Integer.parseInt(origin); 
                            //System.out.println(originNode);
                            break;
                        case 2:
                            String dest = split[0].trim();
                            int destinationNode = Integer.parseInt(dest);
                            String weight = split[1].trim();
                            int cost = Integer.parseInt(weight);
                            //System.out.println(dest + " " + weight);
                            
                            // add next node and cost to Node object using array method                             
                            list[originNode].addNeighbor(destinationNode, cost);
                            
                            // add the same information to the destination node
                            // because it is an undirected graph 
                            list[destinationNode].addNeighbor(originNode, cost);

                            break;
                        default:
                            continue;
                    }
                }                
            }
            scanner.close();
        
        // catch if there is no such file
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
    return list;
    }  
    
}
