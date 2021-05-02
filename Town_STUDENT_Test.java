
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test 
{

	private Town t1;
	private Town t2;
	
	@Before
	public void setUp() throws Exception 
	{
		t1 = new Town("Town1");
		t2 = new Town("Town2");
	}
	
	@After
	public void tearDown() throws Exception {
		t1 = null;
		t2 = null;
	}

	@Test
	public void testGetName() 
	{
		assertEquals("Town1", t1.getName());
		assertEquals("Town2", t2.getName());
	}
	
	@Test
	public void testSetName() 
	{
		t1.setName("New town1");
		assertEquals("New town1", t1.getName());
		
		t2.setName("New town2");
		assertEquals("New town2", t2.getName());
	}
	
	@Test
	public void testcompareTo() 
	{
		t2.setName("Town1");
		assertEquals(0, t1.compareTo(t2));
	}
	
	@Test
	public void testToString() 
	{
		assertEquals("Town's name is : Town1", t1.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
