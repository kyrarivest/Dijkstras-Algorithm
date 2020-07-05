import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class minHeapTest {
	minHeap minheap;
	
	//@BeforeEach
		void initialize() {
			minheap = new minHeap();
			System.out.println(minheap);
		}
	
	//@Test
	void testconstructEmpty() {
		minHeap minheap2 = new minHeap();
		System.out.println(minheap2);
	}
	
	//@Test
	void testconstruct2() {
		GraphNode g1 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g1.priority = 3;
		GraphNode g2 = new GraphNode("30513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g2.priority = 4;
		GraphNode g3 = new GraphNode("92513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g3.priority = 6;
		GraphNode g4 = new GraphNode("ah513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g4.priority = 1;
		GraphNode g5 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g5.priority = 5;
		
		GraphNode[] array = {g1, g2, g3, g4, g5};
		
		minHeap minheap2 = new minHeap(array);
		//System.out.println("heap= minheap2);
	}
	
	//@Test
	void testInsert() {
		
		GraphNode g2 = new GraphNode("30513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g2.priority = 2;
		GraphNode g3 = new GraphNode("92513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g3.priority = 3;
		GraphNode g4 = new GraphNode("ah513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g4.priority = 4;
		GraphNode g5 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g5.priority = 5;
		GraphNode g6 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g6.priority = 6;
		
		GraphNode[] array = {g2, g3, g4, g5, g6};
		
		minheap = new minHeap(array);
		//System.out.println("initialized= " + minheap);
		
		GraphNode g1 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g1.priority = 7;
		minheap.minHeapInsert(g1);
	}
	
	//@Test
	void testInsertNormalOrder() {
		GraphNode g1 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g1.priority = 1;
		GraphNode g2 = new GraphNode("30513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g2.priority = 2;
		GraphNode g3 = new GraphNode("92513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g3.priority = 3;
		GraphNode g4 = new GraphNode("ah513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g4.priority = 4;
		GraphNode g5 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g5.priority = 5;
		
		GraphNode[] array = {g1, g2, g3, g4, g5};
		
		minheap = new minHeap(array);
		//System.out.println("initialized= " + minheap);
		
		GraphNode g6 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g6.priority = 6;
		minheap.minHeapInsert(g6);
	}
	
	//@Test
	void testInsertEmpty() {
		minheap = new minHeap();
		//System.out.println("initialized= " + minheap);
		
		GraphNode g6 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g6.priority = 6;
		minheap.minHeapInsert(g6);
		GraphNode g7 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g7.priority = 7;
		minheap.minHeapInsert(g7);
		GraphNode g1 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g1.priority = 1;
		minheap.minHeapInsert(g1);
	}
	
	//@Test
	void testDecreaseKey() {
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
		
		minheap = new minHeap(array);
		minheap.heapDecreaseKey(4, 4);
	}
	
	//@Test
	void testIncreaseKey() {
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
		
		minheap = new minHeap(array);
		minheap.heapIncreaseKey(0, 30);
	}
	
	
	//@Test
	void testExtractMin() {
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
		
		minheap = new minHeap(array);
		//System.out.println("initialized= " + minheap);
		
		GraphNode g6 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		//g6.priority = 6;
		System.out.println(minheap.extractMin());
	}
	
	@Test
		void testExtractMinWithOnlyOneEntry() {
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
			
			minheap = new minHeap();
			minheap.minHeapInsert(g5);
			System.out.println("initialized= " + minheap);

			System.out.println(minheap.extractMin());
		}
	
	//@Test
	void testExtractWHAshmap() {
		
		GraphNode g2 = new GraphNode("30513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g2.priority = 2;
		GraphNode g3 = new GraphNode("92513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g3.priority = 3;
		GraphNode g4 = new GraphNode("ah513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g4.priority = 4;
		GraphNode g5 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g5.priority = 5;
		GraphNode g6 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g6.priority = 6;
		
		GraphNode[] array = {g2, g3, g4, g5, g6};
		
		minheap = new minHeap(array);
		System.out.println(minheap.extractMin());
	}
	
	
	//@Test
	void testExtractWHAshmap2() {
		GraphNode g5 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g5.priority = 5;
		GraphNode g10 = new GraphNode("30513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g10.priority = 10;
		GraphNode g15 = new GraphNode("92513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g15.priority = 15;
		GraphNode g20 = new GraphNode("ah513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g20.priority = 20;
		GraphNode g17 = new GraphNode("24513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		g17.priority = 17;
		
		GraphNode[] array = {g5, g10, g15, g20, g17};
		
		minheap = new minHeap(array);
		System.out.println("Return= " +minheap.extractMin());
	}
	

}
