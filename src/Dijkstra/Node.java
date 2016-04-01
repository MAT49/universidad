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
    int nodeIndex;  // id for current node
    int minDist = Integer.MAX_VALUE;   // minimum tentative distance to selected node, initially set at positive infinity-like huge value
    
    // creates arraylist holding next node and cost
    ArrayList<Integer> nexts = new ArrayList<Integer>();
    ArrayList<Integer> costs = new ArrayList<Integer>();
       
    // default constructor
    Node() {    }
    
    // constructor takes integer and assigns it to nodeIndex
    Node(int x) { nodeIndex = x; }

    // method takes two integers and adds them to two arraylists
    // and returns nothing
    void addNode(int vertex, int weight)
    {        
        nexts.add(vertex);
        costs.add(weight);
    }

}
