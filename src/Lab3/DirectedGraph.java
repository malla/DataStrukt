/*
 * Om e.from �r 1, �r det nod 1 d�, eller b�r man l�gga in p� plats( e.from-1 )n�r man l�gger till?
 * 
 * Ska man skapa en tv�riktad v�g melan noderna?
 */
package lab3;

import java.util.*;


public class DirectedGraph<E extends Edge> {
	private ArrayList<BusEdge>[] nodes;
	private int numberOfNodes;
	private List<E>[] edges;


	@SuppressWarnings("unchecked")
	public DirectedGraph(int noOfNodes) {
		nodes=new ArrayList[noOfNodes];
		numberOfNodes = noOfNodes;
		for (int i = noOfNodes; i > 0; i--) {
			edges[i] = new LinkedList<E>();
		}
		
	}

	public void addEdge(E e) {
		if (nodes[e.from]==null){
			nodes[e.from]= new ArrayList<BusEdge>();
		}
		nodes[e.from].add((BusEdge) e);
	}

	public Iterator<E> shortestPath(int from, int to) {//Malla
		ArrayList<Integer> vMinusS= new ArrayList<Integer>(); 	//Alla noder som ej ber�knats ifr�n.
		int lowest=0;
		for (int i=0;i>nodes.length;i++){
			vMinusS.add(i, i);
		}
		ArrayList<Integer> s= new ArrayList<Integer>();			//Alla noder som har ber�knats
		ArrayList<Integer> d= new ArrayList<Integer>();			//kortaste v�gen till noden �n s� l�nge (vikten)
		ArrayList<Integer> v= new ArrayList<Integer>();			//Noden som man kortast kommer dit ifr�n.

		//Vi b�rjar kolla...
		int fromNode=from;
		while(fromNode!=to){
			
		}
		
		
		return null;
	}

	public Iterator<E> minimumSpanningTree() {//Bella
		List cc[] = new List[numberOfNodes];
		edges = new List[numberOfNodes];
		PriorityQueue<CompKruskalEdge> pq = new PriorityQueue<CompKruskalEdge>();
		for(int i = 0; i < numberOfNodes; i ++){
			for (E Edge : this.edges[i]) {
				pq.add(new CompKruskalEdge<E>(Edge));
			}
		}
		for (int i = 0; i < numberOfNodes; i++) {
			cc[i] = new LinkedList<E>();
		}
		
		while(!pq.isEmpty()){
			CompKruskalEdge<E> tempEdge = pq.poll();
			
		}
		
		return null;
	}

}

