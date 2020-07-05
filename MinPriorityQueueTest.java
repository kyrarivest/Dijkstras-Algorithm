import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinPriorityQueueTest {
	MinPriorityQueue PQ;
	
	//@Test
	void initialize() {
		GraphNode g5 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g5.priority = 5;
		GraphNode g10 = new GraphNode("30513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g10.priority = 10;
		GraphNode g15 = new GraphNode("92513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g15.priority = 15;
		GraphNode g20 = new GraphNode("ah513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g20.priority = 20;
		GraphNode g25 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g25.priority = 25;
		
		GraphNode[] array = {g5, g10, g15, g20, g25};
		
		PQ = new MinPriorityQueue(array);
		System.out.println(PQ);
		
	}
	
	//@Test
	void initializeEmpty() {
		PQ = new MinPriorityQueue();
		System.out.println(PQ);
		System.out.println(PQ.isEmpty());
	}
	
	//@Test
	void initializeEmptyThenOInsert() {
		GraphNode g1 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g1.priority = 1;
		PQ = new MinPriorityQueue();
		System.out.println(PQ);
		System.out.println(PQ.isEmpty());
		PQ.insert(g1);
		System.out.println(PQ);
		System.out.println(PQ.isEmpty());
	}
	
	@Test
	void initializeEmptyThenOInsert1() {
		PQ = new MinPriorityQueue();
		System.out.println(PQ);
		System.out.println(PQ.isEmpty());
		
		GraphNode g1 = new GraphNode("34513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g1.priority = 0;
		PQ.insert(g1);
		GraphNode g2 = new GraphNode("94513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g2.priority = 0;
		PQ.insert(g2);
		System.out.println(PQ);
		System.out.println(PQ.isEmpty());
	}
	
	//@Test
	void chnagePriority() {
		GraphNode g5 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g5.priority = 5;
		GraphNode g10 = new GraphNode("30513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g10.priority = 10;
		GraphNode g15 = new GraphNode("92513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g15.priority = 15;
		GraphNode g20 = new GraphNode("ah513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g20.priority = 20;
		GraphNode g25 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g25.priority = 25;
		
		GraphNode[] array = {g5, g10, g15, g20};
		
		PQ = new MinPriorityQueue(array);
		System.out.println("Initial " + PQ);
		g10.priority = 30;
		System.out.println("changed prioty " + PQ);
		PQ.rebalance(g10);
		System.out.println("final " + PQ);
		
	}

}
