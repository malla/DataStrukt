package lab1;

import java.util.ArrayList;

public class Uppg1 {

	ArrayList<String> listStrings;
	
	public void  Uppg(){
		listStrings=new ArrayList<String>(10);
	}
	
	public void  Uppg(int i){
		listStrings=new ArrayList<String>(i);
	}
	
	public void addFirst(String element){
		listStrings.add(0, element);
	}
	
	public boolean empty(){
		
		return true;
	}
	
	public String getFirst(){
		return "";
	}
	
	public void removeFirst(){
		
	}
	
	public boolean existP(String elem){
		return true;
	}
	
	public String toString(){
		return "";
	}
}
