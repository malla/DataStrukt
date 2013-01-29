package lab1;

import java.util.ArrayList;

public class Uppg1 {

	ArrayList<String> listStrings;
	
	public Uppg1(){
		listStrings=new ArrayList<String>(10);
	}
	
	public Uppg1(int i){
		listStrings=new ArrayList<String>(i);
	}
	
	public void addFirst(String element){
		listStrings.add(0, element);
	}
	
	//Check if string array is empty
	public boolean empty(){
		return listStrings.isEmpty();
	}
	
	public String getFirst(){
		return listStrings.get(0);
	}
	
	public void removeFirst(){
		listStrings.remove(0);
	}
	
	public boolean existP(String elem){
		return listStrings.contains(elem);
	}
	
	public String toString(){ //Om man inte vill ha med sista kommatecknet??
		StringBuilder s=new StringBuilder();
		for(int i=0; i<listStrings.size();i++){ //Kan det vara b�ttre att skapa o j�mf med en int = listStrings.get(0) f�r att det blir 'mindre'?
			s.append(listStrings.get(i));
			if (i!=listStrings.size()-1){		//B�ttre med en hasNext()? Och hur g�r man det isf?
				s.append(", ");
			}
		}
		return "["+s.toString()+"]";
	}
	
}
