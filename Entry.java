/**
 * @author kyrarivest, email kyrarivest@brandeis.edu
 * 
 * This class is for the Entry objects stored in the HashMap. 
 * The key is the GraphNode in the Entry 
 * The value is the key's index in the minPriorityQueue 
 * 
 *
 */

public class Entry {
	private GraphNode key;
	private int value;
	
	//constructor
	public Entry(GraphNode key, int value) {
		this.key = key;
		this.value = value;
	}
	
	
	/**
	 * Gets the key
	 * @return the key
	 */
	public GraphNode getKey() {
		return this.key;
	}
	
	
	/**
	 * sets the key to a new key
	 * @param newKey: the new key to set the old key to
	 */
	public void setKey(GraphNode newKey) {
		this.key = newKey;
	}
	
	
	/**
	 * gets the value
	 * @return: the value
	 */
	public int getValue() {
		return this.value;
	}
	
	
	/**
	 * sets the value to a new value
	 * @param newValue: new value to set the old value to
	 */
	public void setValue(int newValue) {
		this.value = newValue;
	}
	
	
	/**
	 * prints something like:
	 * ID: 30513978-0d6e-4d7d-985f-bd627dcd2fcc
	 */
	public String toString() {
		return "" + this.key;  //"(val=" + this.value + ")"
	}
}



