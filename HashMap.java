/**
 * @author kyrarivest, email kyrarivest@brandeis.edu
 *
 *This class stores a list of all the GraphNodes in use in the program with each of their indexes in the minPriorityQueue
 *The GraphNode and the index are stored together in the Entry object.
 *The Entry objects are stored in this HashMap hashmap array
 *
 *The HashMap is used to:
 *	 - add items, and then test if they are elements of the heap
 *	 -  see if a node is in the priority queue
 *
 * Note: when an entry is "deleted", the value is jsut set to -1 so it can't be used. The entry is not actually deleted so n won't change when something is "deleted"
 * 		in the context of Dijstra, if an entry has value= -1, then it's the equivalent of the graphnode being in the S set and considered fully explored
 */

public class HashMap {
	Entry[] hashmap;
	private int m;					//Number slots in hashmap
	private int n;					//Number elements occupying hashmap
	private double loadFactor;		//n/m
	private int hashValueLength;	//Number of digits in the hash value. Changes depending on how large the hashmap is. 
									//For m=10, hash value has one digit. For 10<m<100, hash value has 2 digits. etc
	
	
	//Constructor
	public HashMap() {
		this.m = 10;
		this.hashmap = new Entry[m];
		n = 0;
		loadFactor = n/m;
		hashValueLength = 1;
	}
	
	
	/**
	 * checks the hashmap to see if there is an Entry for the GraphNode “key”, 
	 * if there is, change its value to “value”, otherwise, add it to the hashmap with that value.
	 * @param key: Graphnode to be added or found
	 * @param value: the value to set key to
	 */
	public void set(GraphNode key, int value) {
		Entry newEntry = new Entry(key, value);
		int i = 0;
		int j = h(key, i);
		int cycleIndicator = j;
		int keep = -1;
		while(this.hashmap[j] != null){
			if(j == cycleIndicator && i != 0) {
				break;
			}
			if(this.hashmap[j].getKey().equals(newEntry.getKey())) {
				this.hashmap[j].setValue(value);
				return;
			}else if(this.hashmap[j].getValue() == -1 && keep == -1) {
				keep = j;
			}
			i++;
			j = h(key, i);
		}
		//exit while loop
		if(this.hashmap[j] == null) {
			if(keep == -1) {
				this.hashmap[j] = newEntry;
				loadFactor = updateLoadFactor(j);
			}else{
				this.hashmap[keep] = newEntry;
				loadFactor = updateLoadFactor(keep);
			}
		//key not found, insert at index: keep, or if everything is full, rehash
		}else if(j == cycleIndicator && i != 0) {
			if(keep != -1) {
				this.hashmap[keep] = newEntry;
				loadFactor = updateLoadFactor(keep);
			}else {
				loadFactor = rehash();
				set(key, value);
			}
		}
		
	}
	
	
	
	
	/**
	 * gets the value for the entry with g as the key.
	 * @param g: graphnode to find the value of
	 * @return the value for the entry with g as the key or -1 if no g exists
	 */
	public int getValue(GraphNode g) {
		int i = 0;
		int j = h(g, i);
		int cycleIndicator = j;
		while(this.hashmap[j] != null){
			if(j == cycleIndicator && i != 0) {
				break;
			}else {
				if(this.hashmap[j].getKey().equals(g)) {
					return this.hashmap[j].getValue();
				}
				i++;
				j = h(g, i);
			}
		}
		return -1;
	}
	
	
	
	/**
	 * returns whether or not there is the key g in the hashmap
	 * @param g: the key to search for
	 * @return true if the hashmap has that key g, false if not.
	 */
	public boolean hasKey(GraphNode g) {
		int i = 0;
		int j = h(g, i);
		int cycleIndicator = j;
		while(this.hashmap[j] != null){
			if(j == cycleIndicator && i != 0) {
				break;
			}else {
				if(this.hashmap[j].getKey().equals(g)) { //&& this.hashmap[j].getValue() != -1) {
					return true;
				}
				i++;
				j = h(g, i);
			}
		}
		return false;
	}
	
	
	/**
	 * Auxillary hash function: adds the first two characters from the UUID, converted to ints
	 * then, makes it
	 * @param g: the graphnode to get the UUID from
	 * @return the hashValue to be fed into h(g,i) (below)
	 */
	private int hash(GraphNode g) {
		String UUID = g.getId();
		int hashValue = 0;
		for(int i = 0; i < hashValueLength; i++) {
			int num = UUID.charAt(i) % 10;
			hashValue += (int)num*Math.pow(10, i);
		}
		return hashValue;
	}
	
	
	/**
	 * Hash Function: determines the index at which to enter the graphnode g
	 * @param g: grpahnode to be entered in to the hashmap
	 * @param i: index used in the function (will be changed in the client methods)
	 * @return the index at which to enter the graphnode entry
	 */
	private int h(GraphNode g, int i) {
		return (int) ((hash(g) + Math.pow(i, 2)) % m);
	}
	
	
	/**
	 * Deletes an entry from the hashmap
	 * Note: it's not actually deleted, the vlaue is set to -1
	 * @param entry: entry to be deleted
	 */
	public void delete(Entry entry) {
		GraphNode g = entry.getKey();
		int i = 0;
		int j = h(g, i);
		while(this.hashmap[j] != null && i != m){
			if(this.hashmap[j].getKey().equals(g)) {
				if(this.hashmap[j].getValue() == -1) {
					System.out.println("This entry was already deleted. No changes made");
					return;
				}else {
					this.hashmap[j].setValue(-1);
					loadFactor = updateLoadFactor(j);
					return;
				}
			}
			i++;
			j = h(g, i);
		}
		System.out.println("This entry is not in the queue. Cannot delete.");
	}
	
	
	
	/**
	 * Adjusts the load Factor
	 * Performs rehashing if load factor is grater than 0.5
	 * @param j: the index of the entry that has just been inserted
	 * @return: the updated loadfactor after method is done
	 */
	private double updateLoadFactor(int j) {
		if(this.hashmap[j].getValue() == -1) {
			this.n--;
		}//else {
			//this.n++;
		//}
		loadFactor = (double)this.n/this.m;
		if(loadFactor > 0.5) {
			loadFactor = rehash();
		}
		
		return loadFactor;
	}
	
	
	
	/**
	 * Performs rehashing operation:
	 * makes a new array twice the size
	 * adjusts the hash functions to work for the new size
	 * rehashes all the old entries into the new array
	 * sets new array to this.hashmap
	 * @return: the new loadFactor
	 */
	private double rehash() {
		Entry[] oldHashMap = this.hashmap;
		int origm = m;
		this.m = m*2;
		this.n = 0;
		if(m > 10 && m < 100) {
			hashValueLength = 2;
		}else if(m > 100) {
			hashValueLength = 3;
		}
		Entry[] newHashMap = new Entry[m];
		this.hashmap = newHashMap;
		int i = 0;
		while( i != origm) {
			if(oldHashMap[i] == null || oldHashMap[i].getValue() == -1) {
				i++;
			}else {
				this.set(oldHashMap[i].getKey(), oldHashMap[i].getValue());
				i++;
			}
		}

		return loadFactor;
	}
	
	
	/**
	 * Prints something like this:
	 * [null, null, null, ID: 5451397c-0d6e-4d7d-985f-bd627dcd2fcc, null, null, null, null, null, null]
	 */
	public String toString() {
		String s = "[";
		if(this.hashmap[0] == null) {
			s += "null";
		}else {
			s+= this.hashmap[0];    //"(j= "+ 0 + ") "
		}
		for(int i = 1; i < m; i++) {
			if(this.hashmap[i] == null) {
				s += ", null";
			}else {
				s += ", " + this.hashmap[i];   //(j= "+ i + ")
			}
		}
		return s + "]";	
	}
}
