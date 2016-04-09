/*
 * Ha K Hwang
 * 3/26/2016
 */

package Dijkstra;
//import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

// Visibility: package-wide only
// class Dijkstra offers helper class method
// to calculate shortest path from a single source graph
class Dijkstra {
    
    private static int[] hashMap;
    private static int nodeToBeUpdated;
    static LinkedList<Node> priorityQueue;
            
    static int runDijkstra(Node[] passedList)
    {
       
        // I used algorithm overview of Dijkstra algorithm found in
        // http://everythingcomputerscience.com/algorithms/Dijkstras_Algorithm.html
        // 1. Assign to every node a tentative distance value: set it to zero for our initial node and to infinity for all other nodes.        
        // 2. Mark all nodes unvisited. Set the initial node as current. Create a set of the unvisited nodes called the unvisited set consisting of all the nodes.
        // 3. For the current node, consider all of its unvisited neighbors and calculate their tentative distances. For example, if the current node A is marked with a distance of 6, and the edge connecting it with a neighbor B has length 2, then the distance to B (through A) will be 6 + 2 = 8.
        // 4. When we are done considering all of the neighbors of the current node, mark the current node as visited and remove it from the unvisited set. A visited node will never be checked again.
        // 5. If the destination node has been marked visited (when planning a route between two specific nodes) or if the smallest tentative distance among the nodes in the unvisited set is infinity (when planning a complete traversal; occurs when there is no connection between the initial node and remaining unvisited nodes), then stop. The algorithm has finished.
        // 6. Select the unvisited node that is marked with the smallest tentative distance, and set it as the new "current node" then go back to step 3.
        
        // initialize variables for current position (node) and sum (sum of total edge weights so far)
        int sum =0;
        
        // instantiate a Tree object representing a LinkedList of unvisited nodes              
        priorityQueue = new LinkedList<Node>();
        hashMap = new int[passedList.length];


        // Step 1. instantiated Node objects have minDist value of positive infinity-like integer value
        // Step 2. create a set of unvisited nodes called 'queue'
        // add all nodes from input array into priority queue (LinkedList)
        for (int i=0; i< passedList.length; i++)
        {     
            priorityQueue.add(i, passedList[i]);
            hashMap[i] = i;
        }        

        
        // assign cost of 0 to first node, and current node position to 0
        priorityQueue.get(0).nodeWeight = 0;   

        while (priorityQueue.isEmpty() == false)
        {                        
            // Step 5b. if highest priority node has distance value of positive infinity-like value
            // then stop
            if (priorityQueue.peek().nodeWeight < Integer.MAX_VALUE)
            {
                //System.out.println("current MAX weight is " + priorityQueue.peek().nodeWeight);
                // Step 3. calculate current node's distances to immediate neighbors
                // this loop iterates through ArrayList costs for the current node
                // queue.pQ.get(currPos) retrives the current node
                for (int i=0; i<priorityQueue.peek().neighbors.size(); i++)
                {                                
                    nodeToBeUpdated = priorityQueue.peek().neighbors.get(i).neighbor; 

                    // Step 5a. only continue if neighboring node is in the unvisited queue
                    // else, skip
                    //priorityQueue.size() >= hashMap[nodeToBeUpdated] 

                    if (hashMap[nodeToBeUpdated] != -1 && hashMap[nodeToBeUpdated] < priorityQueue.size() )
                    {                        
                                            
                    System.out.println("hashMap index " + priorityQueue.peek().neighbors.get(i).neighbor + " hashMap value " + hashMap[i] + 
                            "; Node number " + priorityQueue.get(hashMap[i]).nodeNum +  " ; Node weight " + priorityQueue.get(hashMap[i]).nodeWeight);
                   
                        
                        
                        Node selectedNode = priorityQueue.get(hashMap[nodeToBeUpdated]);
                        // var neighbor points to its position in LinkedList
                        // to shorten future invocation of this var
                        int currentWeight = priorityQueue.peek().nodeWeight;
                        int updatedWeight = currentWeight + priorityQueue.peek().neighbors.get(i).weight;

                        // add current minDist and dist to neighboring node
                        // to shorten future invocation of this var       
                        
                        //System.out.println("hashMap value is " + hashMap[nodeToBeUpdated] + " Selected node is " + selectedNode.nodeNum + " and weight is " + selectedNode.nodeWeight);                        

                        if (selectedNode.nodeWeight > updatedWeight)
                        {
                            selectedNode.nodeWeight = updatedWeight;      
                            bubbleUp(priorityQueue.indexOf(selectedNode));  
                            //System.out.println("*************" + priorityQueue.indexOf(selectedNode) + " " + selectedNode.nodeNum + " " + selectedNode.nodeWeight);                          
                        }       
                    }
                }                
            } 
            
            // Step 4. after cost to all direct neighbors are calculated, dequeue current node
                       
                Collections.swap(priorityQueue, 0, priorityQueue.size()-1);  
                hashMap[priorityQueue.peek().nodeNum] = 0;  
                hashMap[priorityQueue.getLast().nodeNum] = -1;
                if (priorityQueue.getLast().nodeWeight < Integer.MAX_VALUE && priorityQueue.getLast().neighbors.isEmpty() == false)
                { 
                    //System.out.println("now adding " + priorityQueue.getLast().nodeNum + " " + priorityQueue.getLast().nodeWeight);
                    sum += priorityQueue.getLast().nodeWeight;
                }
                //System.out.println("current sum is " + sum);
                priorityQueue.removeLast();
               
                bubbleDown(0);          
                        
            
               
                System.out.println("--------------------------------------");
                // Step 6. select unvisited node with smallest tentative distance (minDist)
                // class tree methods ensure we will always remove the end of the priority queue
                // which means currPos = 0 until queue is empty
                
        }
        
        return sum;   
        
    }
    

    // helper class method organizes binary tree according to priority
    // takes an int (node position)
    // and returns nothing
    private static void bubbleUp(int pos)
    {
        if ((pos-1)/2 > 0)
        {
            // if parent has less priority (i.e. higher priority number)
            // then swap, and call recursive upheap method
            if (priorityQueue.get((pos-1)/2).nodeWeight > priorityQueue.get(pos).nodeWeight)
            {
                int arrayLoc = priorityQueue.get((pos-1)/2).nodeNum;
                Collections.swap(priorityQueue, pos, (pos-1)/2);
                hashMap[nodeToBeUpdated] = (pos-1)/2;
                hashMap[arrayLoc] = pos;
                bubbleUp((pos-1)/2);
            }
        }
    }

    
    
    // helper class method organizes binary tree according to priority
    // takes an int (node position)
    // and returns nothing
    private static void bubbleDown(int pos)
    {   
        if (pos*2+2 >= priorityQueue.size() && pos*2+1 < priorityQueue.size()) {
      
            // 6 possible cases
            // if node is greater than left child, and LC <= RC, node and LC are swapped

            if (priorityQueue.get(pos).nodeWeight > priorityQueue.get(pos*2+1).nodeWeight)
            {
                int arrayLoc = priorityQueue.get(pos*2+1).nodeNum;
                Collections.swap(priorityQueue, pos, pos*2+1);
                hashMap[nodeToBeUpdated] = pos*2+1;
                hashMap[arrayLoc] = pos;
                // calls helper class method downheap to reorganize priority queue
                bubbleDown(pos*2+1);           
            }
        }
        
        
        else if (pos*2+2 < priorityQueue.size() ) {
      
            // if node is greater than left child, and LC <= RC, node and LC are swapped

            if (priorityQueue.get(pos).nodeWeight > priorityQueue.get(pos*2+1).nodeWeight)
            {
                if (priorityQueue.get(pos).nodeWeight < priorityQueue.get(pos*2+2).nodeWeight )
                {
                    int arrayLoc = priorityQueue.get(pos*2+1).nodeNum;
                    Collections.swap(priorityQueue, pos, pos*2+1);
                    hashMap[nodeToBeUpdated] = pos*2+1;
                    hashMap[arrayLoc] = pos;
                    // calls helper class method downheap to reorganize priority queue
                    bubbleDown(pos*2+1);
                } else if (priorityQueue.get(pos).nodeWeight > priorityQueue.get(pos*2+2).nodeWeight)
                {
                    if (priorityQueue.get(pos*2+1).nodeWeight <= priorityQueue.get(pos*2+2).nodeWeight)
                    {
                        int arrayLoc = priorityQueue.get(pos*2+1).nodeNum;
                        Collections.swap(priorityQueue, pos, pos*2+1);
                        hashMap[nodeToBeUpdated] = pos*2+1;
                        hashMap[arrayLoc] = pos;
                        // calls helper class method downheap to reorganize priority queue
                        bubbleDown(pos*2+1);
                    } else 
                    {                   
                        int arrayLoc = priorityQueue.get(pos*2+2).nodeNum;
                        Collections.swap(priorityQueue, pos, pos*2+2);
                        hashMap[nodeToBeUpdated] = pos*2+2;
                        hashMap[arrayLoc] = pos;
                        // calls helper class method downheap to reorganize priority queue
                        bubbleDown(pos*2+2);
                    } 
                }
            } else if (priorityQueue.get(pos).nodeWeight < priorityQueue.get(pos*2+1).nodeWeight && priorityQueue.get(pos).nodeWeight > priorityQueue.get(pos*2+2).nodeWeight)
            {         
                int arrayLoc = priorityQueue.get(pos*2+2).nodeNum;
                Collections.swap(priorityQueue, pos, pos*2+2);
                hashMap[nodeToBeUpdated] = pos*2+2;
                hashMap[arrayLoc] = pos;
                // calls helper class method downheap to reorganize priority queue
                bubbleDown(pos*2+2);    

            } else {      }

            // do nothing

        } else {    }

         }
 
    
    
}
