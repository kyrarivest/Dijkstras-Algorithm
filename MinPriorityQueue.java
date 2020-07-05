/**
 * 
 * @author kyrarivest, kyrarivest@brandeis.edu
 * 
 * This is the class that implements the priority queue from Dijstra's algorithm
 * it allow syou to extract the GRaphnode with the minimum priority number(highest priority)
 * so that you can prioritize the shortest distances in the algorithm
 *
 */
public class MinPriorityQueue {
	minHeap PQ;
	
	
	//Main constuctor
	public MinPriorityQueue(){
		this.PQ = new minHeap();
	}
	
	
	/**
	 * Second constructor. Mostly for my own testing with pre-generated data
	 * builds the priority queue with the given unordered array
	 * @param array: an array of Graphnodes built for testing
	 */
	public MinPriorityQueue(GraphNode[] array){
		this.PQ = new minHeap(array);
	}
	
	
	/**
	 * Inserts a graphnode into the priority queue and fixes the heap property
	 * @param g: node to be inserted into the queue
	 */
	public void insert(GraphNode g) {
		PQ.minHeapInsert(g);
	}
	
	
	
	/**
	 * pulls out the node with the highest priority and removes it from the queue
	 * @return: the node with the highest priority in the queue
	 */
	public GraphNode pullHighestPriorityElement() {
		return this.PQ.extractMin();
	}
	
	
	
	/**
	 * allows you to see the minimum in the priority queue without actually deleting anything
	 * @return: the minimum priority node
	 */
	public GraphNode getMinimum() {
		return this.PQ.getHeapMin();
	}
	
	
	
	/**
	 * performs the nessecary heap operations when a node's priority has been changed
	 * Error if the new priority is negative because Dijstra's alg doesn't work with negative numbers
	 * @param g: the node whose priority has been changes
	 */
	public void rebalance(GraphNode g){
		if(g.priority < 0) {
			System.out.println("Error: priority cannot be less than zero");
			return;
		}else {
			PQ.heapify(g);
		}
	}
	
	
	/**
	 * determines if the queue is empty
	 * @return true if the queue is empty, false if not
	 */
	public boolean isEmpty() {
		return this.PQ.getHeapSize() < 1;
	}
	
	
	/**
	 * gets the hashmap out of the minHeap(used in main method)
	 * @return: the hashmap inside the minHeap
	 */
	public HashMap getHashMap() {
		return this.PQ.getHashMap();
	}
	
	
	/**
	 * Prints something like:
	 * PQ: 
	 *Heap= [(30)ID: d23343d2-bc99-4145-a833-dd8e9b0dd356 - south: fedf90fe-7e00-4155-93d6-b3d2e612f737 weight 100 - west: 0fd76b04-1df7-4838-b854-e270f42a5dd6 weight 10, null, null, null, null, null, null, null, null, null]
	 *Hashmap= [(j= 0) (val=0)ID: d23343d2-bc99-4145-a833-dd8e9b0dd356 - west: 0fd76b04-1df7-4838-b854-e270f42a5dd6 weight 10, (j= 1) (val=-1)ID: d76ed44b-6c4f-40db-a605-a19210f64f7d - north: 0fd76b04-1df7-4838-b854-e270f42a5dd6 weight 10, null, null
	 */
	public String toString() {
		String s = "PQ: \n";
		s += "Heap= " + PQ;
		s += "\n";
		s += "Hashmap= " + PQ.getHashMap();
		return s;
				
	}
	
}
