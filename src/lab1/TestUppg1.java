package lab1;

public class TestUppg1 {
	
		
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
		System.out.println("[ B�r vara Anna, Berit, null, , Carin: "+ listan.toString() + " ]");
		
		//Testar getFirst()
		System.out.println("\nTestar getFirst()");
		System.out.println("[ B�r vara Anna: "+ listan.getFirst() + " ]");
		
		//Testar removeFirst()
		System.out.println("\nTestar removeFirst()");
		listan.removeFirst();
		System.out.println("[ B�r vara \"\",null, Berit, Carin: "+ listan.toString() + " ]");
		
		//Testar existP()
		System.out.println("\nTestar existP()");
		if (listan.existP("Berit")){
			System.out.println("[ S�ker efter \"Berit\": Finns! ]");
		} else 	System.out.println("[ S�ker efter \"Berit\": Finns inte! ]");
		if (listan.existP("Pelle")){
			System.out.println("[ S�ker efter \"Pelle\": Finns! ]");
		} else 	System.out.println("[ S�ker efter \"Pelle\": Finns inte! ]");
		if (listan.existP(null)){
			System.out.println("[ S�ker efter \"null\": Finns! ]");
		} else 	System.out.println("[ S�ker efter \"null\": Finns inte! ]");
		
		//Testar empty()
		System.out.println("\nTestar empty()");
		if (listan.empty()){
			System.out.println("[ B�r inte vara tom: Listan �r tom ]");
		} else 	System.out.println("[ B�r inte vara tom: Listan �r inte tom ]");




	}
}
