import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 
 * @author kyrarivest, kyrarivest@brandeis.edu
 * 
 * Main class that implements Dijstra's Algorithm
 * Shortest path is printed to console and written to a file: answer.txt
 * 
 *
 */

public class FindMinPath{
	public static void main(String[] args) {
		GraphWrapper gw = new GraphWrapper();
		MinPriorityQueue PQ = new MinPriorityQueue();
		GraphNode home = gw.getHome();
		PQ.insert(home);
		boolean foundGoalNode = false;
		GraphNode goalNode = null;
		
		while(!PQ.isEmpty() && !foundGoalNode) {
			GraphNode u = PQ.pullHighestPriorityElement();
			if(u.isGoalNode()) {
				goalNode = u;
				foundGoalNode = true;
			}
			
			if(u.hasNorth()) {
				Relax(PQ, u, u.getNorth(), u.getNorthWeight(), "North");
			}
			if(u.hasEast()) {
				Relax(PQ, u, u.getEast(), u.getEastWeight(), "East");
			}
			if(u.hasSouth()) {
				Relax(PQ, u, u.getSouth(), u.getSouthWeight(), "South");
			}
			if(u.hasWest()) {
				Relax(PQ, u, u.getWest(), u.getWestWeight(), "West");
			}
			
		}
	
		//Algorithm done. Print results
		try {
			File answerFile = new File("answer.txt");
			if(!(answerFile.exists())) {
				answerFile.createNewFile();
			}
				
			PrintWriter pen = new PrintWriter(answerFile);
			String s = "";
			if(foundGoalNode) {
				GraphNode n = goalNode;	
				while(!(n.previousNode == null)) {
					s = n.previousDirection + "\n" + s;
					n = n.previousNode;
				}
				System.out.println(s);
				pen.println(s);
			}else {
				System.out.println("No possible path form home to destination");
				pen.println("No possible path form home to destination");
			}
			pen.close();
				
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * Implements the Relax method from class
	 * @param PQ: the priority queue used in the algorithm
	 * @param u: the current node (u in alg)
	 * @param v: current's neighbor (V in alg)
	 * @param distance: the distance from u to v
	 * @param prevDirec: the direction you went to get form u to v
	 */
	public static void Relax(MinPriorityQueue PQ, GraphNode u, GraphNode v, int distance, String prevDirec) {
		int x = u.priority + distance;

		if(!PQ.getHashMap().hasKey(v)) {
			v.priority = x;
			v.previousNode = u;
			v.previousDirection = prevDirec;
			PQ.insert(v);
			
		}else if(x < v.priority) {
			v.priority = x;
			PQ.rebalance(v);
			v.previousNode = u;
			v.previousDirection = prevDirec;
		}
	}
}