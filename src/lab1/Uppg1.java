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
		for(int i=0; i<listStrings.size();i++){ //Kan det vara bättre att skapa o jämf med en int = listStrings.get(0) för att det blir 'mindre'?
			s.append(listStrings.get(i));
			if (i!=listStrings.size()-1){		//Bättre med en hasNext()? Och hur gör man det isf?
				s.append(", ");
			}
		}
		return "["+s.toString()+"]";
	}
	
}
