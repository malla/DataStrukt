//Grupp 26
//Madeleine Appert 891110-4845
//Isabelle Frölich 900831-2846

package lab2;

import datastructures.*;
import testSortCol.CollectionWithGet;

public class SortedLinkedCollection<E extends Comparable<E>> extends
		LinkedCollection<E> implements CollectionWithGet<E> {
	private Entry lastEntry;
	private Entry previousEntry;

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
	public boolean add(E newElement) throws NullPointerException {
		
		// If the new element is null throw NullPointerException
		if (newElement == null) {
			throw new NullPointerException("Element can't be added");
		}
		// If the collection is empty, add the new element and set it to be head
		if (head == null) {
			previousEntry = head = lastEntry = new Entry(newElement, null);
		} 
		// If the new element is bigger than the last element,
		// set the new element to the lastElement and place it last in the
		// collection.
		else if (newElement.compareTo(lastEntry.element) > 0) {
			lastEntry.next = lastEntry = previousEntry = new Entry(newElement, null);
		} 
		
		// If the new element is smaller than the head,
		// set the new element to head and place it first in the collection.
		else if (newElement.compareTo(head.element) < 0) {
			previousEntry = head = new Entry(newElement, head);
		} 
		else {
		// Loop through the other elements to see where the element fits.	
			Entry tempEntry = head;
			if(previousEntry.element.compareTo(newElement) < 0){
				tempEntry = previousEntry;
			}
			while (tempEntry.next != null
					&& newElement.compareTo(tempEntry.next.element) > 0) {
				tempEntry = tempEntry.next;
			}
			previousEntry = tempEntry.next = new Entry(newElement, tempEntry.next);
		}

		return true;
	}//add

	/**
	 * Gets an element from the collection if it exists in the collection.
	 * 
	 * @param element
	 *            The element that is to be searched for
	 * @return element Returns the element if exists in the collection and null
	 *         if it doesn't
	 */
	
	public E get(E element) {
		Entry tempEntry = head;
		int compResult;
		
		// If element is found return element, otherwise end search and return null
		while(tempEntry != null){
			compResult = tempEntry.element.compareTo(element);
			if (compResult == 0) {
				return tempEntry.element;
			} 
			else if (compResult > 0) {
				return null;
			}
			tempEntry = tempEntry.next;
		}
		return null;
		}// get

}
