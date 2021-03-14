
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedListTest_Student
{
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Car> sortedLinkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	public Car a=new Car("Ferrari", "fffff", 2005);
	public Car b=new Car("Jeta", "jjjjj", 2005);
	public Car c=new Car("Hummar", "hhhhh", 2005);
	public Car d=new Car("Sidan", "sssss", 2005);
	public Car e=new Car("Chevrolet", "cccccc", 2005);
	public Car f=new Car("Chrysler", "ccccc", 2005);
	//alphabetic order: e f a c b d
	
	@Before
	public void setUp() throws Exception
	{
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorCar = new CarComparator();
		sortedLinkedCar = new SortedDoubleLinkedList<Car>(comparatorCar);
		
	}
	@After
	public void tearDown() throws Exception
	{
		comparator = null;
		comparatorD = null;
		comparatorCar = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedCar = null;
	}
	@Test
	public void testAddToEnd() 
	{
		try
		{
			sortedLinkedString.addToEnd("Nermeen");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
	}

	@Test
	public void testAddToFront() {
		try 
		{
			sortedLinkedString.addToFront("Nermeen");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() 
	{
		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(d);
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious()
	{
		sortedLinkedString.add("Ask");
		sortedLinkedString.add("Nermeen");
		sortedLinkedString.add("Zoo");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Ask", iterator.next());
		assertEquals("Nermeen", iterator.next());
		assertEquals("Zoo", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zoo", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulCarPrevious()
	{
		sortedLinkedCar.add(a);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(d);
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(d, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() 
	{
		sortedLinkedDouble.add(new Double(9));
		sortedLinkedDouble.add(new Double(7));
		sortedLinkedDouble.add(new Double(3));
		sortedLinkedDouble.add(new Double(5));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(3), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(7), iterator.next());
		assertEquals(true, iterator.hasNext());	
	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious()
	{
		sortedLinkedDouble.add(new Double(10));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(new Double(8), iterator.previous());
	}
	@Test
	public void testIteratorNoSuchElementException()
	{
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(d);
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		try
		{
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
	}
	
	@Test
	public void testIteratorUnsupportedOperationExceptionString()
	{
		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		try
		{
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
	}

	@Test
	public void testAddCar() 
	{
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		assertEquals(c, sortedLinkedCar.getFirst());
		assertEquals(b, sortedLinkedCar.getLast());
		sortedLinkedCar.add(d);
		sortedLinkedCar.add(e);
		assertEquals(e, sortedLinkedCar.getFirst());
		assertEquals(d, sortedLinkedCar.getLast());
		assertEquals(d,sortedLinkedCar.retrieveLastElement());
		assertEquals(b,sortedLinkedCar.retrieveLastElement());
		assertEquals(c, sortedLinkedCar.getLast());
	}

	@Test
	public void testRemoveFirstCar() 
	{
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		assertEquals(c, sortedLinkedCar.getFirst());
		assertEquals(b, sortedLinkedCar.getLast());
		sortedLinkedCar.add(a);
		assertEquals(a, sortedLinkedCar.getFirst());
		sortedLinkedCar.remove(a, comparatorCar);
		assertEquals(c, sortedLinkedCar.getFirst());
	}
	
	@Test
	public void testRemoveEndCar()
	{
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(f);
		assertEquals(f, sortedLinkedCar.getFirst());
		assertEquals(b, sortedLinkedCar.getLast());
		sortedLinkedCar.add(d);
		assertEquals(d, sortedLinkedCar.getLast());
		sortedLinkedCar.remove(d, comparatorCar);
		assertEquals(b, sortedLinkedCar.getLast());
	}

	@Test
	public void testRemoveMiddleCar()
	{
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		assertEquals(a, sortedLinkedCar.getFirst());
		assertEquals(b, sortedLinkedCar.getLast());
		sortedLinkedCar.add(f);
		sortedLinkedCar.remove(a, comparatorCar);
		assertEquals(f, sortedLinkedCar.getFirst());
		assertEquals(b, sortedLinkedCar.getLast());
		assertEquals(2,sortedLinkedCar.getSize());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by name
			return arg0.getMake().compareTo(arg1.getMake());
		}		
	}
	
	private class Car{
		String make;
		String model;
		int year;
		
		public Car(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}
