import static org.junit.Assert.*;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 * @author Nermeen Mohi
 *
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test
{
		private CourseDBManagerInterface dataMgr = new CourseDBManager();

		/**
		 * Create an instance of CourseDBManager
		 * @throws Exception
		 */
		@Before
		public void setUp() throws Exception 
		{
			dataMgr = new CourseDBManager();
		}

		/**
		 * Set dataMgr reference to null
		 * @throws Exception
		 */
		@After
		public void tearDown() throws Exception 
		{
			dataMgr = null;
		}

		/**
		 * Test for the add method
		 */
		@Test
		public void testAddToDB()
		{
			try 
			{
				dataMgr.add("ENEE207",33333,4,"SC401","Lan Xiang");
			}
			catch(Exception e)
			{
				fail("This should not have caused an Exception");
			}
		}
		
		/**
		 * Test for the showAll method
		 */
		@Test
		public void testShowAll()
		{
			dataMgr.add("ENEE207",33333,4,"SC401","Lan Xiang");
			dataMgr.add("ENEE245",22222,2,"SC402","Lan Xiang");
			dataMgr.add("CMSC204",77777,4,"SC400","Robert Alexander");
			ArrayList<String> list = dataMgr.showAll();
			
			assertEquals(list.get(0),"\nCourse:ENEE245 CRN:22222 Credits:2 Instructor:Lan Xiang Room:SC402");
			assertEquals(list.get(1),"\nCourse:ENEE207 CRN:33333 Credits:4 Instructor:Lan Xiang Room:SC401");
			assertEquals(list.get(2),"\nCourse:CMSC204 CRN:77777 Credits:4 Instructor:Robert Alexander Room:SC400");
		}
		/**
		 * Test for the read from file method
		 */
		@Test
		public void testRead()
		{
			try 
			{
				File inputFile = new File("Test2.txt");
				PrintWriter inFile = new PrintWriter(inputFile);
				inFile.println("ENEE207 33333 4 SC401 Lan Xiang");
				inFile.print("ENEE245 22222 2 SC402 Lan Xiang");
				
				inFile.close();
				dataMgr.readFile(inputFile);
			}
			catch (Exception e) 
			{
				fail("Should not have thrown an exception");
			}
		}
}
