/*
 * Ha K Hwang
 * 3/26/2016
 */
package Dijkstra;
import java.util.ArrayList;

// Visibility: package-wide only
// Holds Node information containing next nodes and their costs
// in 2 arraylists with matching index
class Node {
    // I'm not declaring these as private because I envision use within the package
    // also, adding getters/setters won't make it more secure at all
    int nodeNum;  // id for current node
    int nodeWeight = Integer.MAX_VALUE;   // minimum tentative distance to selected node, initially set at positive infinity-like huge value
    
    // creates arraylist holding next node and cost
    ArrayList<Neighbor> neighbors = new ArrayList<Neighbor>();
    

    // default constructor
    Node() {    }
    
    // constructor takes integer and assigns it to nodeNum
    Node(int x) { nodeNum = x; }

    
    // method takes two integers and adds them to two arraylists
    // and returns nothing
    void addNeighbor (int nextNode, int nextNodeCost)
    {
        Neighbor next = new Neighbor(nextNode, nextNodeCost);
        neighbors.add(next);
    }
  
}
