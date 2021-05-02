

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManager_STUDENT_Test 
{

	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 3, "R1");
		  graph.addRoad(town[1], town[3], 5, "R2");
		  graph.addRoad(town[1], town[5], 7, "R3");
		  graph.addRoad(town[3], town[7], 2, "R4");
		  graph.addRoad(town[3], town[8], 3, "R5");
		  graph.addRoad(town[4], town[8], 4, "R6");
		  graph.addRoad(town[6], town[9], 4, "R7");
		  graph.addRoad(town[9], town[10], 5, "R8");
		  graph.addRoad(town[8], town[10], 3, "R9");
		  graph.addRoad(town[5], town[10], 6, "R10");
		  graph.addRoad(town[10], town[11], 4, "R11");
		  graph.addRoad(town[2], town[11], 7, "R12");
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("R1", roads.get(0));
		assertEquals("R10", roads.get(1));
		assertEquals("R11", roads.get(2));
		assertEquals("R12", roads.get(3));
		graph.addRoad(town[4], town[11], 1,"R13");
		roads = graph.allRoads();
		assertEquals("R1", roads.get(0));
		assertEquals("R10", roads.get(1));
		assertEquals("R11", roads.get(2));
		assertEquals("R12", roads.get(3));
		assertEquals("R13", roads.get(4));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("R12", graph.getRoad(town[2], town[11]));
		assertEquals("R4", graph.getRoad(town[3], town[7]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_12"));
		graph.addTown("Town_12");
		assertEquals(true, graph.containsTown("Town_12"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, graph.containsTown("Town_12"));
		graph.addTown("Town_12");
		ArrayList<String> path = graph.getPath(town[1],"Town_12");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		assertEquals(false, graph.containsTown("Town_12"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[11]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[11]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("R1", roads.get(0));
		assertEquals("R10", roads.get(1));
		assertEquals("R11", roads.get(2));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[11]));
		graph.deleteRoadConnection(town[2], town[11], "R12");
		assertEquals(false, graph.containsRoadConnection(town[2], town[11]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_3"));
		graph.deleteTown(town[3]);
		assertEquals(false, graph.containsTown("Town_3"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_10", roads.get(1));
		assertEquals("Town_11", roads.get(2));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1],town[11]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via R1 to Town_2 3 mi",path.get(0).trim());
		  assertEquals("Town_2 via R12 to Town_11 7 mi",path.get(1).trim());

	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = graph.getPath(town[1],town[10]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via R2 to Town_3 5 mi",path.get(0).trim());
		  assertEquals("Town_3 via R5 to Town_8 3 mi",path.get(1).trim());
	}
	
	@Test
	public void testGetPathB() {
		ArrayList<String> path = graph.getPath(town[1],town[6]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via R2 to Town_3 5 mi",path.get(0).trim());
		  assertEquals("Town_3 via R5 to Town_8 3 mi",path.get(1).trim());
		  assertEquals("Town_8 via R9 to Town_10 3 mi",path.get(2).trim());

	}

}
