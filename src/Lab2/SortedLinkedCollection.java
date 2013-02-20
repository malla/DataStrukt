package Lab2;

import java.util.Iterator;

import datastructures.*;
import testSortCol.*;

public class SortedLinkedCollection<E extends Comparable<E>> extends
		LinkedCollection<E> {
	private Entry lastElement;

	/**
	 * The constructor of the collection. The collection is initialized to be
	 * empty.
	 */
	public SortedLinkedCollection() {
		super();
	} // constructor SortedLinkedCollection

	/**
	 * Adds an element to the collection. The element added will be sorted into
	 * the collection depending on its size. The smallest element in the
	 * collection will always be first, hence, will be the first element given
	 * by the iterator, and vice versa.
	 * 
	 * @param newElement
	 *            the object to add into the list
	 * @return true if the object has been added to the list.
	 * @throws NullPointerException
	 *             if parameter <tt>element<tt> is null.
	 */
	@Override
	public boolean add(E newElement) {
		Entry tempEntry; 
		//If the new element is null throw NullPointerException
		if (newElement == null)
			throw new NullPointerException();
		//If the collection is empty, add the new element and set it to be head
		if(isEmpty()){
			head = new Entry(newElement, null);
			lastElement = head;
			return true;
		}
		//If the new element is smaller than the head, 
		//set the new element to head and place it first in the collection.
		else if(newElement.compareTo(head.element) <= 0){
			head = new Entry(newElement, head);
			return true;
		}
		//If the new element is bigger than the last element, 
		//set the new element to the lastElement and place it last in the collection.
		else if(newElement.compareTo(lastElement.element) >= 0){
			lastElement = new Entry(newElement, null);
			//lastElement.next = tempEntry;
			//lastElement = tempEntry;
			return true;
		}
			
		else{	
			Entry previousEntry = head.next;
			while(previousEntry != null && newElement.compareTo(previousEntry.element)> 0){
				previousEntry = previousEntry.next;
			}
			if(previousEntry == null){
				lastElement = new Entry(newElement, null);
			}
			else{
				tempEntry = new Entry(newElement, previousEntry);
			}
				
			return true;
		}
			
	}//add
	
	/**
	 * Gets an element from the collection if it exists in the collection.
	 * 
	 * @param element
	 *            	The element that is to be searched for
	 * @return element 
	 * 				Returns the element if exists in the collection and null if it doesn't
	 */
	public E get(E element) {
		Iterator<E> it = super.iterator();
		E tempElement;
		if (lastElement != null) {
			// Checks if the element is bigger than the last,
			// if so no need for further searching.
			if (element.compareTo(lastElement.element) > 0) {
				return null;
			}
		}
		
		while (it.hasNext()) {
			tempElement = it.next();
			if (element.compareTo(tempElement) == 0) {
				return element;
			}
		}
		return null;
	}//get

}
