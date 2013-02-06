//Group 26
//Madeleine Appert 891110-4845
//Isabelle Frölich 900831-2846

package lab1;




public class Uppg1 {
	String[] listStrings;
	private int position;
	private int elemAmount;
	private int limit;
	
	public static void main(String[] args){
		Uppg1 listan = new Uppg1();
		System.out.println("\n[ Ny tom lista: "+ listan.toString() + " ]");
		
		//Tester addFirst()
		System.out.println("\nTestar addFirst()");
		listan.addFirst("Carin");
		listan.addFirst("Berit");
		listan.addFirst(null);
		listan.addFirst("");
		listan.addFirst("Anna");
		System.out.println("["+ listan.toString() + " # Bör vara Anna, \"\", null, Berit, Carin ]");
		
		//Testar getFirst()
		System.out.println("\nTestar getFirst()");
		System.out.println("["+ listan.getFirst() + " # Bör vara Anna]");

		//Testar removeFirst()
		System.out.println("\nTestar removeFirst()");
		listan.removeFirst();
		System.out.println("["+ listan.toString() + " # Bör vara \"\",null, Berit, Carin ]");

		
		//Testar existP()
		System.out.println("\nTestar existP()");
		if (listan.existP("Berit")){
			System.out.println("[ Söker efter \"Berit\": Finns! ]");
		} else 	System.out.println("[ Söker efter \"Berit\": Finns inte! ]");
		if (listan.existP("Pelle")){
			System.out.println("[ Söker efter \"Pelle\": Finns! ]");
		} else 	System.out.println("[ Söker efter \"Pelle\": Finns inte! ]");
		if (listan.existP(null)){
			System.out.println("[ Söker efter \"null\": Finns! ]");
		} else 	System.out.println("[ Söker efter \"null\": Finns inte! ]");
		
		//Testar empty()
		System.out.println("\nTestar empty()");
		if (listan.empty()){
			System.out.println("[ Bör inte vara tom: Listan är tom ]");
		} else 	System.out.println("[ Bör inte vara tom: Listan är inte tom ]");
		
	}

	/**
	 * Creates a Uppg1.
	 * It will create 10 elements in the Array unless specfied.
	 */
	public Uppg1(){
		listStrings=new String[10];
		elemAmount=0;
		limit=10;
		position=0;
	}

	/**
	 * Creates a Uppg1.
	 * @param i specifies the amount of elements in the Array
	 */
	public Uppg1(int i){
		listStrings=new String[i];
		elemAmount=0;
		limit=i;
		position=0;
	}

	/*We have chosen to increase the size of the array when needed because 
	 *this is a more general solution. There may be times when it is wanted to have
	 *a more limited array size but we consider this to be a more unlikely scenario.
	 */
	public void addFirst(String element){
		elemAmount++;
		if (elemAmount>limit){
			enlargeArray();
			listStrings[elemAmount-1]=element;
		} else {
			listStrings[elemAmount-1]=element;
		}
	}

	/**
	 * Checks if the Array is empty or not.
	 * @return true if Array is empty.
	 */
	public boolean empty(){
		return (elemAmount<1);
	}

	/**
	 * Get the first element in the array
	 */
	public String getFirst(){
		return listStrings[elemAmount-1];
	}

	/**
	 * Removes the first element in the array.
	 * position P will continue pointing on 1st element.
	 */
	/*	As our list is backwards, our 'first' element is actually our last.
	 *	P will continue pointing at THE SAME element as before, after 
	 *	removeFirst(), therefore we have chosen to call hasNext() to check 
	 *	if position is still within our list. If not it is set to the first 
	 *	element.
	 */
	public void removeFirst(){
		listStrings[elemAmount-1]=null;
		elemAmount--;
		if(!hasNext()){
			position=elemAmount-1;
		}
	}

	/**Checks if a String exists in the sequence
	 * Can handle the input of null objects. 
	 * 
	 * @param elem the element that is checked for
	 * @return true if the element exists
	 */
	public boolean existP(String elem){
		if (elem==null){
			for (int i=elemAmount; i>=0;i--){
				if (listStrings[i]==null)
					return true;
			}
		}
		else for (int i=elemAmount; i>=0;i--){
			if (listStrings[i]!=null && listStrings[i].equals(elem))
				return true;
		}
		return false;
	}
	/**
	 * Returns a string of the arrays elements.
	 */
	public String toString(){ 
		StringBuilder s= new StringBuilder();
		for(int i=(elemAmount-1); i>=0;i--){ 
			s.append(listStrings[i]);
			if (i!=0){
				s.append(", ");
			}
		}
		return "["+s+"]";
	}

	/**
	 * Puts the position to a certain location, p,  in the Array.
	 * If the position used as a parameter does not exist 
	 * within the list, the position will remain as before. 
	 * @param p
	 */
	public void setP (int p){
		int tillf= position;
		position=elemAmount-p;
		if(!hasNext()){
			position=tillf;
			throw new IllegalArgumentException("The list is not that big");
		}
	}

	/**
	 * Determines if the position is set to a valid location.
	 * @return
	 */
	private boolean hasNext(){ 
		return (0<=position&& position<=elemAmount);
	}

	/**
	 * Adds element after the position P.
	 * @param element
	 */
	private void addAfterP(String element){
		if(elemAmount+1>limit){
			enlargeArray();
		}
		for(int i=elemAmount; i>=position;i--){
			listStrings[i+1]=listStrings[i];
		}
		listStrings[position]=element;	
		elemAmount++;
	}

	/**Gets the DATA stored in the the Array[position].**/
	public String get(){
		if (hasNext()){
			return listStrings[position];
		}else{
			throw new IllegalArgumentException("The element does not exist");
		}
	}

	/**
	 * Changes position with the value given in the parameter.
	 * We reuse the code in setP().
	 * **/
	public void moveP(int val) {
		setP(position+val);	
	}

	/**
	 * Creats a new Array, twice the size of the one used before,
	 * and relocates the pointers
	 */
	private void enlargeArray(){
		limit=limit*2;
		String[] newArray= new String[limit];
		System.arraycopy(listStrings, 0, newArray, 0, elemAmount);
		listStrings=newArray;
	}
}
