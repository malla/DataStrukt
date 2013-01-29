package lab1;
import java.lang.System;


public class Uppg1 {
	//ArrayList<String> listStrings;
	String[] listStrings;
	private int position;
	private int elemAmount;
	private int limit;

	public Uppg1(){
		listStrings=new String[10];
		elemAmount=0;
		limit=10;
		position=0;
	}

	public Uppg1(int i){
		listStrings=new String[i];
		elemAmount=0;
		limit=i;
		position=0;
	}
	
	// Vi har valt att öka listans storlek vid behov då vi ser detta 
	// som en mer generell lösning. Givetvis kan det finnas tillfällen
	// då det kan vara önskvärt att ha en begränsad liststorlek, men
	// vi uppfattar det som ett mer ovanligt scenario.
	public void addFirst(String element){
		elemAmount++;
		if (elemAmount>limit){
			limit=limit*2;
			String[] newArray= new String[limit];
			System.arraycopy(listStrings, 0, newArray, 0, elemAmount-1);//Do something to move all the elements one step to the right
			listStrings=newArray;
			listStrings[elemAmount-1]=element;
		} else {
			listStrings[elemAmount-1]=element;
		}
	}

	//Check if string array is empty

	public boolean empty(){
		for (int i=0; i<listStrings.length;i++){
			if (listStrings[i]!=null)
				return false;
		}
		return true;
	}

	public String getFirst(){
		return listStrings[elemAmount-1];
	}

	public void removeFirst(){
		listStrings[elemAmount-1]=null;
		elemAmount--;
	}

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

	public String toString(){ 
		StringBuilder s= new StringBuilder();
		for(int i=(elemAmount-1); i>=0;i--){ 
			s.append(listStrings[i]);
			if (i!=0){		//Bättre med en hasNext()? Och hur gör man det isf?
				s.append(", ");
			}
		}
		return "["+s+"]";
	}

	public void setP (int p){
		position=p;
	}

//		private boolean hasNext(){
//			if (0<=position)
//		return true;
//		}
}
