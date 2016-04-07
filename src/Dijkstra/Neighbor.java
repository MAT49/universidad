/*
 * Ha K Hwang
 * 3/26/2016
 */
package Dijkstra;

// Visibility: package-wide only
// Holds next node information containing next nodes and their costs

class Neighbor {
    int neighbor;
    int weight;
    
    // default constructor
    Neighbor() {   }
    
    // constructor takes two integers
    Neighbor (int nextNode, int nextNodeCost)
    {
        neighbor = nextNode;
        weight = nextNodeCost;
    }
    
}
