package Lab2;
import datastructures.*;
import testSortCol.*;

public class SortedLinkedCollection<E> extends LinkedCollection<E>{
	
    protected Entry head;
    
    /** 
     * The constructor of the collection.
     * The collection is initialized to be empty.
     */
    public SortedLinkedCollection() {
        head = null;
    }  // constructor LinkedCollection
    
    /**
     * The class of objects used as nodes of the
     *  singly linked list
     */
    protected class Entry { 

        public E      element;
        public Entry  next;

        public Entry( E element, Entry next ) {
            this.element = element;
            this.next = next;
        }

    } // Entry
	
	
    /**
     * Adds an element to the collection.
     * The element added will be sorted into the collection
     * depending on its size. The smallest element in the 
     * collection will always be first, hence, will be the
     * first element given by the iterator, and vice versa. 
     * 
     * @param element the object to add into the list
     * @return true if the object has been added to the list.
     * @throws NullPointerException if parameter <tt>element<tt> is null. 
     */
    @Override
    public boolean add( E element ) {
        if ( element == null )
	    throw new NullPointerException();
	else {
		for(Entry i=head; super.hasNext(); i=head.next){
			
		}
		
	    head = new Entry( element, head );
	    return true;
	}
    } // add
	

}
