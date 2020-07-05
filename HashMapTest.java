import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashMapTest {
	HashMap hashmap;
	
	@BeforeEach
	void initialize() {
		this.hashmap = new HashMap();
	}

	
	//@Test
	void testsetAndDelete() {
		//System.out.println(hashmap);
		GraphNode g1 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry1 = new Entry(g1, 1);
		hashmap.set(g1, 1);
		//System.out.println(hashmap);
		GraphNode g2 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry2 = new Entry(g2, 2);
		hashmap.set(g2, 2);
		GraphNode g3 = new GraphNode("62513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry3 = new Entry(g3, 3);
		hashmap.set(g3, 3);
		//System.out.println(hashmap);
		hashmap.delete(entry3);
	}
	
	//@Test
	void testsetanddelete2() {
		GraphNode g1 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry1 = new Entry(g1, 1);
		hashmap.set(g1, 1);
		GraphNode g2 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry2 = new Entry(g2, 2);
		hashmap.set(g2, 2);
		GraphNode g3 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry3 = new Entry(g3, 3);
		hashmap.set(g3, 3);
		
		GraphNode g4 = new GraphNode("6f2d1978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry4 = new Entry(g4, 4);
		hashmap.delete(entry2);
		hashmap.delete(entry3);
		hashmap.set(g2, 2);
	}
	
	
	//@Test
	void testset2() {
		//System.out.println(hashmap);
		GraphNode g1 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry1 = new Entry(g1, 1);
		hashmap.set(g1, 1);
		//System.out.println(hashmap);
		GraphNode g2 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry2 = new Entry(g2, 2);
		hashmap.set(g2, 2);
		GraphNode g3 = new GraphNode("62513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry3 = new Entry(g3, 3);
		hashmap.set(g3, 3);
		//System.out.println(hashmap);
		hashmap.delete(entry3);
		GraphNode g4 = new GraphNode("62513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry4 = new Entry(g3, 4);
		hashmap.set(g4, 4);
	}
	
	
	//@Test
	void testsetChangeValue() {
		//System.out.println(hashmap);
		GraphNode g1 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry1 = new Entry(g1, 1);
		hashmap.set(g1, 1);
		//System.out.println(hashmap);
		GraphNode g2 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry2 = new Entry(g2, 2);
		hashmap.set(g2, 2);
		GraphNode g3 = new GraphNode("62513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry3 = new Entry(g3, 3);
		hashmap.set(g3, 3);
		//System.out.println(hashmap);
		hashmap.delete(entry3);
		GraphNode g4 = new GraphNode("62513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry4 = new Entry(g3, 4);
		hashmap.set(g4, 4);
		
		//GraphNode g5 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
		//Entry entry5 = new Entry(g1, 6);
		hashmap.set(g1, 6);
	}
	
	//@Test
	void testdeleteWhenDoesntExist() {
		//System.out.println(hashmap);
		GraphNode g1 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry1 = new Entry(g1, 1);
		hashmap.set(g1, 1);
		//System.out.println(hashmap);
		GraphNode g2 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry2 = new Entry(g2, 2);
		hashmap.set(g2, 2);
		GraphNode g3 = new GraphNode("62513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry3 = new Entry(g3, 3);
		hashmap.set(g3, 3);
		//System.out.println(hashmap);
		hashmap.delete(entry3);
		GraphNode g4 = new GraphNode("62513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry4 = new Entry(g3, 4);
		hashmap.set(g4, 4);
		GraphNode g5 = new GraphNode("bs81397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry5 = new Entry(g1, 4);
		hashmap.delete(entry5);
	}
	
	//@Test
	void testhasKey() {
		GraphNode g1 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry1 = new Entry(g1, 1);
		hashmap.set(g1, 1);
		GraphNode g2 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry2 = new Entry(g2, 2);
		hashmap.set(g2, 2);
		GraphNode g3 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry3 = new Entry(g3, 3);
		hashmap.set(g3, 3);
		
		System.out.println(hashmap.hasKey(g1));
	}
	
	
	//@Test
	void testSameCodewithRehash() {
		//System.out.println(hashmap);
		GraphNode g1 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry1 = new Entry(g1, 1);
		hashmap.set(g1, 1);
		//System.out.println(hashmap);
		GraphNode g2 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry2 = new Entry(g2, 2);
		hashmap.set(g2, 2);
		GraphNode g3 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry3 = new Entry(g3, 3);
		hashmap.set(g3, 3);
		GraphNode g4 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry4 = new Entry(g4, 4);
		hashmap.set(g4, 4);
		GraphNode g5 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry5 = new Entry(g5, 5);
		hashmap.set(g5, 5);
		GraphNode g6 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
		Entry entry6 = new Entry(g6, 6);
		hashmap.set(g6, 6);
		hashmap.delete(entry6);
	}
	
	//@Test
		void testhasKeyNotThere() {
			GraphNode g1 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry1 = new Entry(g1, 1);
			hashmap.set(g1, 1);
			GraphNode g2 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry2 = new Entry(g2, 2);
			hashmap.set(g2, 2);
			GraphNode g3 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry3 = new Entry(g3, 3);
			hashmap.set(g3, 3);
			
			//hashmap.delete(entry2);
			GraphNode g4 = new GraphNode("6f2d1978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			
			System.out.println(hashmap.hasKey(g4));
		}
		
		@Test
		void testgetValue() {
			GraphNode g1 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry1 = new Entry(g1, 1);
			hashmap.set(g1, 1);
			GraphNode g2 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry2 = new Entry(g2, 2);
			hashmap.set(g2, 2);
			GraphNode g3 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry3 = new Entry(g3, 3);
			hashmap.set(g3, 3);
			
			
			GraphNode g4 = new GraphNode("6f2d1978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry4 = new Entry(g4, 4);
			//hashmap.set(g4, 4);
			//hashmap.delete(entry4);
			System.out.println("HAshmap= " + hashmap);
			
			System.out.println(hashmap.getValue(g4));
		}
		
		
		//@Test
		void testSmall() {
			GraphNode g1 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry1 = new Entry(g1, 1);
			hashmap.set(g1, 1);
			GraphNode g2 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry2 = new Entry(g2, 2);
			hashmap.set(g2, 2);
			GraphNode g3 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry3 = new Entry(g3, 3);
			hashmap.set(g3, 3);
		
		}
		
		
		//@Test
		void testWhenInCycle() {
			//System.out.println(hashmap);
			GraphNode g1 = new GraphNode("5451397c-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry1 = new Entry(g1, 1);
			hashmap.set(g1, 1);
			//System.out.println(hashmap);
			GraphNode g2 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry2 = new Entry(g2, 2);
			hashmap.set(g2, 2);
			GraphNode g3 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry3 = new Entry(g3, 3);
			hashmap.set(g3, 3);
			
			//hashmap.delete(entry2);
			//hashmap.delete(entry3);
			
			GraphNode g4 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry4 = new Entry(g4, 4);
			hashmap.set(g4, 4);
			GraphNode g5 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry5 = new Entry(g5, 5);
			hashmap.set(g5, 5);
			GraphNode g6 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry6 = new Entry(g6, 6);
			hashmap.set(g6, 6);
			GraphNode g7 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry7 = new Entry(g7, 7);
			hashmap.set(g7, 7);
			GraphNode g8 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry8 = new Entry(g8, 8);
			hashmap.set(g8, 8);
			GraphNode g9 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry9 = new Entry(g9, 9);
			hashmap.set(g9, 9);
			GraphNode g10 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			Entry entry10 = new Entry(g10, 10);
			hashmap.set(g10, 10);
		//	GraphNode g11 = new GraphNode("54513978-0d6e-4d7d-985f-bd627dcd2fcc", false);
			//Entry entry11 = new Entry(g11, 11);
		//	hashmap.set(g11, 11);
		}
		
		
		
		
		

}

