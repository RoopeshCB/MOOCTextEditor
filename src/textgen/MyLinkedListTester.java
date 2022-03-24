/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

/*import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiConsumer;*/

import org.junit.Before;
import org.junit.Test;
//import org.junit.function.ThrowingRunnable;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		//add test to check prev of first node(should point to head)
		
		// TODO: Add more tests here
		
		String b = shortList.remove(1);
		assertEquals("Remove: check b is correct ", "B", b);
		assertEquals("Remove: check element 0 is not removed ", "A",shortList.get(0));
		assertEquals("Remove: check size is correct ",1,shortList.size());
		//add test to check next of node(should point to tail)
		
		try {
			emptyList.remove(0);
			fail("Check Out of Bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		int c = longerList.remove(4);
		assertEquals("Remove: check c is correct. ", 4, c);
		assertEquals("Remove: check element 4 is correct ",(Integer)5, longerList.get(4));
		assertEquals("Remove: check size is correct ", 9, longerList.size());
		
		try {
			shortList.remove(-1);
			fail("Check  Index Out of Bounds(for lower bounds)");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		//int sizeEmptyList = emptyList.size();
		emptyList.add(5);
		assertEquals("Add: check if the element is added in empty list. ",(Integer)5, emptyList.get(0));
		
		//int sizelist1 = list1.size();
		list1.add(82);
		assertEquals("Add: check if the element is added in list1. ",(Integer)82,list1.get(3));
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: check the size of emptyList. ",0,emptyList.size);
		assertEquals("Size: check the size of shortList. ",2,shortList.size());
		list1.add(111);
		assertEquals("Size: check the size of the list1. ",4,list1.size());
		longerList.remove(0);
		assertEquals("Size: check the size of the longerList. ",9,longerList.size());
		//assertTrue(longerList.size() ==9);
		
		
		//assertEquals("Size: check the size of the longerList. ",10,longerList.size());
		//assertEquals("Size: check the size of the list1. ",3,list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		emptyList.add(0, 28);
		assertEquals("Add: check if the element is added in emptyList. ", (Integer)28,emptyList.get(0));
		
		shortList.add(2, "C");
		assertEquals("Add: check if the element is added in shortList. ", "C",shortList.get(2));
		
		list1.add(1,99);
		assertEquals("Add: check if the element is added in list1. ", (Integer)99,list1.get(1));
		
		longerList.add(0, 100);
		assertEquals("Add: check if the element is addded in longerList. ",(Integer)100,longerList.get(0));
		
		try {
			list1.add(1, null);
			fail("Check Null Pointer Exception");
		}
		catch(NullPointerException e) {
			
		}
		
		try {
			list1.add(-1, 55);
			fail("Check Index Out of the Bounds(for lower bound)");
		}
		catch(IndexOutOfBoundsException e){
			
		}
		
		try {
			list1.add(6, 53);
			fail("Check Index Out of Bounds(for upper bounds)");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		/*
		 * try { //list1.set(0, null); ThrowingRunnable runnable = new
		 * ThrowingRunnable() {
		 * 
		 * @Override public void run() throws Throwable { list1.set(0, null); } };
		 * assertThrows(NullPointerException.class,runnable);
		 * assertThrows(NullPointerException.class, ()->{ list1.set(0, null); });
		 * fail("Null Pointer Exception should have been thrown and caught"); }
		 * catch(NullPointerException e) {
		 * 
		 * }
		 */
		
		/*try {
			shortList.set(2, 111);
			fail("INDEX OUT OF BOUNDS");
		}
		catch(IndexOutOfBoundsException e) {
			
		}*/
		String shortData = shortList.set(0, "C");
		assertEquals("Set: check the changed element in shortList.", "A",shortData);
		assertEquals("Set: check the new element in the shortList.","C",shortList.get(0));
		
		try {
			list1.set(4, 11);
			fail("Index Out of bounds Exception not thrown");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.set(0, null);
			fail("Null Pointer Exception not thrown");
		}
		catch(NullPointerException e) {
			
		}
		
		try {
			emptyList.set(0, 11);
			fail("Index out of Bounds Exception not thrown");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		int list1Data = list1.set(2, 22);
		assertEquals("Set: check the changed element in list1.",42,list1Data);
		assertEquals("Set: cehck the new element in the list1",(Integer)22,list1.get(2));
		
		try {
			shortList.set(-1,"D");
			fail("Index Out of Bounds(for lower bounds) not checked ");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
	}
	
	
	// TODO: Optionally add more test methods.
	/*
	 * @Test public void test() { //MyLinkedList<Integer> Lclass = new
	 * MyLinkedList<>(); //System.out.println(Lclass.size());
	 * 
	 * 
	 * Map<Integer,Integer> map = new HashMap<>(); map.put(0, 1); map.put(1, 2);
	 * BiConsumer<Integer, Integer> bic = new BiConsumer<Integer, Integer>() {
	 * 
	 * @Override public void accept(Integer key, Integer value) {
	 * System.out.println("From Method   "+ key+":"+value);
	 * 
	 * } }; map.forEach((key,value)->{
	 * System.out.println("From Lambda   "+key+":"+value); });
	 * 
	 * BiConsumer<Integer, Integer> bic1 = (key,value)->{
	 * System.out.println("From Lambda   "+key+":"+value); };
	 * 
	 * map.forEach(bic1);
	 * 
	 * 
	 * }
	 */
	
}
