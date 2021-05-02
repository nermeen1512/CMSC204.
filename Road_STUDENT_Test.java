
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test
{
	private Road r1;
	Town T1 ;
	Town T2 ;
	Town other = new Town("different");

	@Before
	public void setUp() throws Exception 
	{
		T1 = new Town("Town1");
		T2 = new Town("Town2");
		r1 = new Road(T1, T2, 5, "R1");
	}
	
	@After
	public void tearDown() throws Exception {
		r1 = null;
	}

	@Test
	public void testGetT1() 
	{
		assertEquals(T1, r1.getT1());
	}
	
	@Test
	public void testGetT2() 
	{
		assertEquals(T2, r1.getT2());
	}
	
	@Test
	public void testGetName() 
	{
		assertEquals("R1", r1.getName());
	}
	
	@Test
	public void testGetD() 
	{
		assertEquals(5, r1.getD());
	}
	
	@Test
	public void testSetT1() 
	{
		r1.setT1(other);
		assertEquals(other, r1.getT1());
	}
	
	@Test
	public void testSetT2() 
	{
		r1.setT2(other);
		assertEquals(other, r1.getT2());
	}
	
	@Test
	public void testSetName() 
	{
		r1.setName("newName");
		assertEquals("newName", r1.getName());
	}
	
	@Test
	public void testSetD() 
	{
		r1.setD(3);
		assertEquals(3, r1.getD());
	}
	
	@Test
	public void testContains() 
	{
		assertEquals(true, r1.contains(T1));
		assertEquals(true, r1.contains(T2));
		assertEquals(false, r1.contains(other));
	}
	
	@Test
	public void testCompareTo() 
	{
		assertEquals(0, r1.compareTo(new Road(T1, T2, 5, "R1")));
	}
	
	
	@Test
	public void testToString() 
	{
		assertEquals("The Road name is: R1 of distance = 5", r1.toString());
	}
	
	
}
