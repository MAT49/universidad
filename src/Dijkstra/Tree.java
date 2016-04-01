/*
 * Ha K Hwang
 * 3/26/2016
 */

package Dijkstra;
import java.util.ArrayList;
import java.util.Collections;

// Visibility: package-wide only
// class Tree provides binary tree methods for priority queue implementation
// this code is based on ideas of priority queue implementation I saw on Youtube:
// https://www.youtube.com/watch?v=w647KdGJmpI
// https://www.youtube.com/watch?v=Uxo7UiMco58
// https://www.youtube.com/watch?v=yJvkHJXx7sM
// Operations for minimum binary tree are based on readings from
// http://algorithms.tutorialhorizon.com/binary-min-max-heap/
class Tree {
    
    // create a priority queue based on ArrayList
    ArrayList<Node> pQ = new ArrayList<Node>(); 
    
    
    // method returns total number of node objects in priority queue
    // takes nothing
    // and returns an int
    int size()
    {
        return pQ.size();
    }
    
    /*
    // method adds node to the tail of ArrayList
    // takes Node object
    // and returns nothing
    void add(Node node)
    {
        if (pQ. == 0)
        {
            pQ.offer(node);
            
            // calls helper class method upheap to reorganize priority queue
            if (pQ.size() > 1)
                bubbleUp(pQ.size()-1);
        }
    }
    */
    
    // method removes the minimum element (top)
    // takes nothing
    // and returns the popped head node
    void removeMin()
    {        
        Collections.swap(pQ, 1, pQ.size()-1);
        pQ.remove(pQ.size()-1);
        
        // calls helper class method downheap to reorganize priority queue
        downheap(0);
    }
    
    // method removes an internal node
    // takes int
    // and returns nothing
    void removeNode(int pos)
    {
        // if head node, then removeMin() method should be used
        // swaps selected node with last node, removes last node, and reorganizes priority queue using downheap method recursively
        if (pos > 0)
        {
            Collections.swap(pQ, pos, pQ.size()-1);
            pQ.remove(pQ.size()-1);
            downheap(pos);
        }
        
    }
    
    // helper class method organizes binary tree according to priority
    // takes an int (node position)
    // and returns nothing
    void bubbleUp(int pos)
    {
        // if parent has less priority (i.e. higher priority number)
        // then swap, and call recursive upheap method
        if (pQ.get(pos/2).minDist > pQ.get(pos).minDist)
        {
            Collections.swap(pQ, pos, pos/2);
            bubbleUp(pos/2);
        }
    }
    
    // helper class method organizes binary tree according to priority
    // takes an int (node position)
    // and returns nothing
    void downheap(int pos)
    {        
        // 3 possible cases
        // if node is greater than left child, and LC <= RC, node and LC are swapped
        
        if (pQ.get(pos).minDist > pQ.get(pos*2).minDist)
        {
            // if node is greater than left child, and LC > RC, node and RC are swapped
            if (pQ.get(pos).minDist > pQ.get(pos*2+1).minDist && pQ.get(pos*2).minDist < pQ.get(pos*2+1).minDist)
            {
                Collections.swap(pQ, pos, pos*2);
            } else
            {
                Collections.swap(pQ, pos, pos*2+1);
            }

            // calls helper class method downheap to reorganize priority queue
            downheap(pos);

        } else   {   }
            
        //System.out.println("not 0 " + pos);     
        // lastly, nothing happens because the node is already has highest (i.e. smallest number) priority
       
    }
    
}