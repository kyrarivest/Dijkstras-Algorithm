/**
 * @author kyrarivest, kyrarivest@brandeis.edu
 * 
 * This class is a min priority queue 
 * The queue is implemented with a min heap and a hashmap to keep track of the indexes of the Graphnodes
 *
 *If there are Graphnodes with duplicate priorities, the Graphnode inserted first remains before the other one in the heap
 */
public class minHeap {
	private GraphNode[] heap;
	private int AHeapSize;	//length of heap
	private HashMap hashmap;
	
	//Main Constructor
	public minHeap() {
		this.AHeapSize = 0;
		heap = new GraphNode[10];
		this.hashmap = new HashMap();
	}
	
	
	/**
	 * Mostly for testing. Not really used in the main method
	 * @param array: a pre-generated array to test this class
	 */
	public minHeap(GraphNode[] array) {
		this.heap = buildMinHeap(array);
		this.hashmap = new HashMap();
		for(int i = 0; i <array.length; i++){
			this.hashmap.set(this.heap[i], i);
		}
	}
	
	
	/**
	 * builds a min heap from an unordered array
	 * @param array: an unordered array
	 * @return the array, with correct heap properties
	 */
	private GraphNode[] buildMinHeap(GraphNode[] array) {
		AHeapSize = array.length;	
		this.heap = array;
		for(int i = this.heap.length/2; i >= 0; i--) {
			heapifyDown(i, true);
		}

		return this.heap;
	}
	
	
	
	/**
	 * Inserts a node into the heap and maintains the heap property
	 * @param g: graph node to be inserted into heap
	 */
	public void minHeapInsert(GraphNode g) {
		int gpriority = g.priority;
		if(AHeapSize == this.heap.length) {
			this.heap = resizeHeap();
		}

		g.priority = 1000000000;
		heap[AHeapSize] = g;
		this.hashmap.set(g, AHeapSize);
		heapDecreaseKey(AHeapSize, gpriority);
		AHeapSize++;
		
		}
	
	
	/**
	 * returns the Graphnode with the minimum priority and deletes it from the heap
	 * @return: the Graphnode with the minimum priority
	 */
	public GraphNode extractMin() {
		if (AHeapSize < 1) {
			System.out.println("Cannot delete. Heap empty. No changes made");
			return null;
		}else {
			GraphNode min = this.heap[0];
			this.hashmap.set(this.heap[0], -1);
			this.heap[0] = this.heap[AHeapSize - 1];
			this.heap[AHeapSize - 1] = null;
			AHeapSize--;
			
			if(!(this.heap[0] == null)){
				this.hashmap.set(this.heap[0], 0);
				heapifyDown(0, false);
			}

			return min;
		}
	}
	
	
	/**
	 * heapify up method to maintain heap property
	 * @param i: index at which to begin the operation
	 */
	private void heapifyUp(int i) {
		while(i > 0 && this.heap[i].priority < this.heap[parent(i)].priority) { 
			GraphNode hold = this.heap[i];
			this.heap[i] = this.heap[parent(i)];
			this.heap[parent(i)] = hold;
			this.hashmap.set(this.heap[i], i);
			i = parent(i);
		}
		this.hashmap.set(this.heap[i], i);
	}
	
	
	
	/**
	 * heapify down method used to maintain heap property
	 * @param i: index at which to begin operation
	 * @param isbuildingHeap: if true, then it doesn't update the hashmap. 
	 * This is because when you're initializing everything the hashmap is made seperately
	 */
	private void heapifyDown(int i, boolean isBuildingHeap) {
		int left = left(i);
		int right = right(i);
		int smallest = 0;
		
		if(left < AHeapSize) {
			if( this.heap[left].priority < this.heap[i].priority) {
				smallest = left;
			}else {
				smallest = i;
			}
		}else {
			smallest = i;
		}
	
		if(right < AHeapSize) {
			if(this.heap[right].priority < this.heap[smallest].priority) {
				smallest = right;
			}
		}
		if(smallest != i) {
			GraphNode hold = this.heap[i];	
			this.heap[i] = this.heap[smallest];
			this.heap[smallest] = hold;
			heapifyDown(smallest, isBuildingHeap);
		}

		if(!isBuildingHeap){
			this.hashmap.set(this.heap[i], i);
		}
	}
	
	
	/**
	 * Combines heapifyUp and heapifyDown into one method
	 * @param g: the GraphNode at which to apply the heapify operations
	 */
	public void heapify(GraphNode g) {
		//is root
		if(this.parent(this.hashmap.getValue(g)) < 0) {
			this.heapifyDown(this.hashmap.getValue(g), false);
		//right child doesn't exist
		}else if(this.right(this.hashmap.getValue(g)) > this.AHeapSize - 1) {
			if(this.left(this.hashmap.getValue(g)) > this.AHeapSize - 1) {
				this.heapifyUp(this.hashmap.getValue(g));
			}else {
				if(g.priority > this.getLeftChild(this.hashmap.getValue(g)).priority) {
					this.heapifyDown(this.hashmap.getValue(g), false);
				}else if(g.priority < this.getParentNode(this.hashmap.getValue(g)).priority) {
					this.heapifyUp(this.hashmap.getValue(g));
				}
			}
		//left child doesn't exist
		}else {
			//g needs to be moved down
			if(g.priority > this.getLeftChild(this.hashmap.getValue(g)).priority || g.priority > this.getRightChild(this.hashmap.getValue(g)).priority){
				this.heapifyDown(this.hashmap.getValue(g), false);
			//g needs to be moved up
			}else if(g.priority < this.getParentNode(this.hashmap.getValue(g)).priority) {
				this.heapifyUp(this.hashmap.getValue(g));
			}
		}
		
	}
	
	
	/**
	 * Increases the priority of a GraphNode and corrects the heap property
	 * @param i: the index of the GraphNode that you want increase the priority of
	 * @param key: the new priority value you want to set the old priority value to
	 */
	public void heapIncreaseKey(int i, int key) {
		if (key < this.heap[i].priority) {
			System.out.println("Cannot increase key, New key valeu is smaller than original key. No changes made.");
		}else {
			this.heap[i].priority = key;
			this.heapifyDown(i, false);
		}
	}
	
	
	
	/**
	 * Decreases the priority of a GraphNode and corrects the heap property
	 * @param i: the index of the GraphNode that you want decrease the priority of
	 * @param key: the new priority value you want to set the old priority value to
	 */
	public void heapDecreaseKey(int i, int key) {
		if (key > this.heap[i].priority) {
			System.out.println("Cannot increase key, New key value is larger than original key. No changes made.");
		}else {
			this.heap[i].priority = key;
			this.heapifyUp(i);
		}
	}
	
	
	/**
	 * makes the heap array larger if all the spots are filled
	 * Note: makes it twice as large
	 * @return: the enlarged array
	 */
	private GraphNode[]resizeHeap() {
		GraphNode[] newHeap = new GraphNode[this.heap.length*2];
		for(int i = 0; i < AHeapSize; i++) {
			newHeap[i] = this.heap[i];
		}
		this.heap = newHeap;
		return this.heap;
	}
	
	
	/**
	 * gets the graph node with the lowest priority number, essentially heap[0]
	 * @return: the graph node with the highest priority
	 */
	public GraphNode getHeapMin() {
		return heap[0];
	}
	
	
	/**
	 * gets the heap size
	 * @return: the heap size value
	 */
	public int getHeapSize() {
		return AHeapSize;
	}
	
	/**
	 * gets the GraphNode at the specified index. Doesn't delete anything
	 * @param i: the index of the GraphNode you want
	 * @return: the GraphNode at index i
	 */
	public GraphNode getHeapElement(int i) {
		return this.heap[i - 1];
	}
	
	/**
	 * gets the heap 
	 * @return: the heap 
	 */
	public GraphNode[] getHeap() {
		return this.heap;
	}
	
	
	/**
	 * gets the hashmap
	 * @return: the hashmap
	 */
	public HashMap getHashMap() {
		return this.hashmap;
	}
	
	
	/**
	 * gets the index of the parent of the node at index i
	 * @return: the index of the parent of the node at index i
	 */
	private int parent(int i) {
		return ((i+1)/2) - 1;
	}
	
	/**
	 * public version of parent(int i)
	 * @return: the index of the parent of the node at index i
	 */
	public int getParent(int i) {
		return parent(i);
	}
	
	
	/**
	 * gets the parent node of the node at index i
	 * @return: the parent node of the node at index i
	 */
	public GraphNode getParentNode(int i) {
		return this.heap[parent(i)];
	}
	
	
	/**
	 * gets the index of the left child of the node at index i
	 * @return: the index of the left child of the node at index i
	 */
	private int left(int i) {
		return (2*(i+1) - 1);
	}
	
	
	/**
	 * public version of left(int i )
	 * @return: the index of the left child of the node at index i
	 */
	public int getLeft(int i) {
		return left(i);
	}
	
	/**
	 * gets the left child node of the node at index i
	 * @return: the left child node of the node at index i
	 */
	public GraphNode getLeftChild(int i) {
		return this.heap[left(i)];
	}
	
	
	/**
	 * gets the index of the right child of the node at index i
	 * @return: the index of the right child of the node at index i
	 */
	private int right(int i) {
		return 2*(i+1);
	}
	
	
	/**
	 * public version of right(i)
	 * @return: the index of the right child of the node at index i
	 */
	public int getRight(int i) {
		return right(i);
	}
	
	
	/**
	 * gets the right child of the node at index i
	 * @return: the right child of the node at index i
	 */
	public GraphNode getRightChild(int i) {
		return this.heap[right(i)];
	}
	
	/**
	 * Prints something like this:
	 * [null, null, null, ID: 5451397c-0d6e-4d7d-985f-bd627dcd2fcc, null, null, null, null, null, null]
	 */
	public String toString() {
		String s = "[";
		if(this.heap[0] == null) {
			s += "null";
		}else {
			s+= this.heap[0];    //"("+this.heap[0].priority+")"
		}
		for(int i = 1; i < this.heap.length; i++) {
			if(this.heap[i] == null) {
				s += ", null";
			}else {
				s += ", " +this.heap[i];   //("+this.heap[i].priority+")"
			}
		}
		return s + "]";	
	}
	
	
}
