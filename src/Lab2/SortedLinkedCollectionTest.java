package lab2;

import org.junit.Test;

import junit.framework.TestCase;

public class SortedLinkedCollectionTest extends TestCase {
	
	private SortedLinkedCollection<String> SLC1 = new SortedLinkedCollection<String>();
	private SortedLinkedCollection<Integer> SLC2 = new SortedLinkedCollection<Integer>();
	
	@Test
	public void testAdd() {
		assertTrue(SLC1.add("Hoho"));
		assertTrue(SLC1.add("Extremt"));
		assertTrue(SLC1.add("w"));
		assertTrue(SLC1.add("w"));
		assertTrue(SLC2.add(1));
		assertTrue(SLC2.add(5));
		assertTrue(SLC2.add(3));
		try
		{
			SLC1.add(null); 
		} catch (NullPointerException e)
		{
			assertNotNull(e);
		}
	}
	
	@Test
	public void testGet(){
		SLC2.add(3);
		SLC2.add(4);
		SLC2.add(4);
		assertTrue(SLC2.get(3)==3);
		assertTrue(SLC2.get(4)==4);
		
	}
}
