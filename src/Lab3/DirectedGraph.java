/*
 * Om e.from är 1, är det nod 1 då, eller bör man lägga in på plats( e.from-1 )när man lägger till?
 * 
 * Ska man skapa en tvåriktad väg melan noderna?
 */
package lab3;

import java.util.*;


public class DirectedGraph<E extends Edge> {
	private ArrayList<BusEdge>[] nodes;



	@SuppressWarnings("unchecked")
	public DirectedGraph(int noOfNodes) {
		nodes=new ArrayList[noOfNodes];
		;
	}

	public void addEdge(E e) {
		if (nodes[e.from]==null){
			nodes[e.from]= new ArrayList<BusEdge>();
		}
		nodes[e.from].add((BusEdge) e);
	}

	public Iterator<E> shortestPath(int from, int to) {//Malla
		ArrayList<Integer> vMinusS= new ArrayList<Integer>(); 	//Alla noder som ej beräknats ifrån.
		int lowest=0;
		for (int i=0;i>nodes.length;i++){
			vMinusS.add(i, i);
		}
		ArrayList<Integer> s= new ArrayList<Integer>();			//Alla noder som har beräknats
		ArrayList<Integer> d= new ArrayList<Integer>();			//kortaste vägen till noden än så länge (vikten)
		ArrayList<Integer> v= new ArrayList<Integer>();			//Noden som man kortast kommer dit ifrån.

		//Vi börjar kolla...
		int fromNode=from;
		while(fromNode!=to){
			
		}
		
		
		return null;
	}

	public Iterator<E> minimumSpanningTree() {//Bella
		int nbrOfCc = nodes.length;
		ArrayList[] cc = new ArrayList[nodes.length];
		PriorityQueue pq = new PriorityQueue();
		//pq.add(arg0);
		while(nbrOfCc > 0){
			nbrOfCc --;
		}
		
		return null;
	}

}

