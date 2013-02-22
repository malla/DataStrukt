/*
 * Om e.from är 1, är det nod 1 då, eller bör man lägga in på plats( e.from-1 )när man lägger till?
 * 
 * Ska man skapa en tvåriktad väg melan noderna?
 */
package lab3;

import java.util.*;


public class DirectedGraph<E extends Edge> {
	private ArrayList<Integer>[] nodes;


	@SuppressWarnings("only integers will be added")
	public DirectedGraph(int noOfNodes) {
		nodes=new ArrayList[noOfNodes];
		;
	}

	public void addEdge(E e) {
		if (nodes[e.from]==null){
			nodes[e.from]= new ArrayList<Integer>();
		}
		nodes[e.from].add(e.to);
	}

	public Iterator<E> shortestPath(int from, int to) {//Malla
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
  
