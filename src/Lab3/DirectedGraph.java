/*
 * Om e.from �r 1, �r det nod 1 d�, eller b�r man l�gga in p� plats( e.from-1 )n�r man l�gger till?
 * 
 * Ska man skapa en tv�riktad v�g melan noderna?
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
  
