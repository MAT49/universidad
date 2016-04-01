/*
 * Ha K Hwang
 * 3/26/2016
 */

package Dijkstra;
//import java.util.ArrayList;
//import java.util.LinkedList;

// Visibility: package-wide only
// class Dijkstra offers helper class method
// to calculate shortest path from a single source graph
class Dijkstra {
            
    static int runDijkstra(Node[] passedList)
    {
        
        /*
        // @Quick Sanity Check for 2d array passing
        System.out.println(DriverToFindShortestPathWeight.totalV + " " + DriverToFindShortestPathWeight.totalE); 
        for (int i=0; i<passedList.length; i++)
        {
            System.out.println(passedList[i].nodeIndex + " " + passedList[i].priority);
            for (int j=0; j<passedList[i].nexts.size(); j++)
            {                                
                System.out.println(passedList[i].nexts.get(j) + " " + passedList[i].costs.get(j));
            }
        }
        */              
        
        // I used algorithm overview of Dijkstra algorithm found in
        // http://everythingcomputerscience.com/algorithms/Dijkstras_Algorithm.html
        /*
        // 1. Assign to every node a tentative distance value: set it to zero for our initial node and to infinity for all other nodes.        
        // 2. Mark all nodes unvisited. Set the initial node as current. Create a set of the unvisited nodes called the unvisited set consisting of all the nodes.
        // 3. For the current node, consider all of its unvisited neighbors and calculate their tentative distances. For example, if the current node A is marked with a distance of 6, and the edge connecting it with a neighbor B has length 2, then the distance to B (through A) will be 6 + 2 = 8.
        // 4. When we are done considering all of the neighbors of the current node, mark the current node as visited and remove it from the unvisited set. A visited node will never be checked again.
        // 5. If the destination node has been marked visited (when planning a route between two specific nodes) or if the smallest tentative distance among the nodes in the unvisited set is infinity (when planning a complete traversal; occurs when there is no connection between the initial node and remaining unvisited nodes), then stop. The algorithm has finished.
        // 6. Select the unvisited node that is marked with the smallest tentative distance, and set it as the new "current node" then go back to step 3.
        */
        
        // initialize variables for current position (node) and sum (sum of total edge weights so far)
        int currPos=0;
        int sum =0;
        
        // instantiate a Tree object representing a LinkedList of unvisited nodes              
        Tree queue = new Tree();
        
        int[] newIndex = new int[passedList.length];
        System.out.println(newIndex.length);
        
        // Step 1. instantiated Node objects have minDist value of positive infinity-like integer value
        // Step 2. create a set of unvisited nodes called 'queue'
        // add all nodes from input array into priority queue (LinkedList)
        for (int i=0; i< passedList.length; i++)
        {
     
            queue.pQ.add(i, passedList[i]);
            newIndex[i] = passedList[i].nodeIndex;
            
            //System.out.println(queue.pQ.get(i).nodeIndex + " " + queue.newIndex[i] + " " + queue.pQ.get(i).minDist);            
        }        

        
        // assign cost of 0 to first node, and current node position to 0
        queue.pQ.get(0).minDist = 0;   
        //System.out.println(queue.pQ.get(0).nodeIndex + " " + queue.pQ.get(0).minDist); 
        
        
        
        // while priority queue has nodes, loop
        //while (queue.pQ.isEmpty() == false)
        //{
        
            // Step 3. calculate current node's distances to immediate neighbors
            // this loop iterates through ArrayList costs for the current node
            // queue.pQ.get(currPos) retrives the current node
            for (int i=0; i<queue.pQ.get(currPos).costs.size(); i++)
            {   
                
                // var neighbor points to its position in LinkedList
                // to shorten future invocation of this var
                int neighbor = queue.pQ.get(currPos).nexts.get(i);
                
                // var neighborPos tracks current index of neighbor as queue shrinks and original index changes
                // it relies on a referencing array like a hashmap
                
                newIndex[neighbor] = neighbor;
                //System.out.println(newIndex[neighbor]);                
                
                // @boundary test
                //System.out.println(neighbor + " " + queue.pQ.get(neighbor).minDist);
                
                
                // Step 5a. only continue if neighboring node is in the unvisited queue
                // else, skip
                if (queue.pQ.contains(passedList[neighbor] ))
                {
                
                    // add current minDist and dist to neighboring node
                    // to shorten future invocation of this var
                    int hop = queue.pQ.get(currPos).minDist + queue.pQ.get(currPos).costs.get(i);


                    // 
                    if (hop < queue.pQ.get(neighborPos).minDist)
                    {
                        queue.pQ.get(neighborPos).minDist = hop;
                        queue.bubbleUp(neighborPos);                      
                        
                        
                    }                     
                    
                }
            
            // @bondary test
            //System.out.println(neighbor + " " + queue.pQ.get(neighbor).minDist);

            }

            // Step 4. after cost to all direct neighbors are calculated, dequeue current node
            queue.removeMin();
            // @boundary test           
            int n = queue.size();
            for (int j=0; j<n; j++)
            {
                System.out.println(queue.pQ.get(j).nodeIndex + " " + queue.pQ.get(j).minDist);
            }
            
            // Step 5b. if highest priority node has distance value of positive infinity-like value
            // then stop
            if (queue.pQ.remove(1).minDist == Integer.MAX_VALUE )
                queue.removeMin();
            
            // Step 6. select unvisited node with smallest tentative distance (minDist)
            // class tree methods ensure we will always remove the end of the priority queue
            // which means currPos = 0 until queue is empty
                
        //}
                        
                
    return sum;    
    }           
    
    
}
