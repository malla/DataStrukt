/*
 * Om e.from är 1, är det nod 1 då, eller bör man lägga in på plats( e.from-1 )när man lägger till?
 * 
 * Ska man skapa en tvåriktad väg melan noderna?
 */

//Grupp 26
//Madeleine Appert 891110-4845
//Isabelle Frölich 900831-2846

package lab3;

import java.util.*;

public class DirectedGraph<E extends Edge> {
	private ArrayList<BusEdge>[] nodes;
	private int numberOfNodes;
	private List<E>[] edges;

	public DirectedGraph(int noOfNodes) {
		nodes = new ArrayList[noOfNodes];
		edges = (List<E>[]) new LinkedList[noOfNodes];
		numberOfNodes = noOfNodes;
		for (int i = 0; i < noOfNodes; i++) {
			edges[i] = new LinkedList<E>();
		}

	}

	public void addEdge(E e) {
		// if (nodes[e.from]==null){
		// nodes[e.from]= new ArrayList<BusEdge>();
		// }
		// nodes[e.from].add((BusEdge) e);
		edges[e.from].add(e);
	}

	public Iterator<E> shortestPath(int from, int to) {// Malla
		ArrayList<Integer> vMinusS = new ArrayList<Integer>(); // Alla noder som
																// ej beräknats
																// ifrån.
		int lowest = 0;
		for (int i = 0; i > nodes.length; i++) {
			vMinusS.add(i, i);
		}
		ArrayList<Integer> s = new ArrayList<Integer>(); // Alla noder som har
															// beräknats
		ArrayList<Integer> d = new ArrayList<Integer>(); // kortaste vägen till
															// noden än så länge
															// (vikten)
		ArrayList<Integer> v = new ArrayList<Integer>(); // Noden som man
															// kortast kommer
															// dit ifrån.

		// Vi börjar kolla...
		int fromNode = from;
		while (fromNode != to) {

		}

		return null;
	}

	/**
	 * Uses Kruskals algorithm to find the minimum spanning tree given a number
	 * of nodes, this without creating any loops.
	 * 
	 * @Return Returns an iterator over the minimum spanning tree
	 */

	public Iterator<E> minimumSpanningTree() {// Bella
		List<E>[] cc = (List<E>[]) new LinkedList[this.numberOfNodes];
		PriorityQueue<CompKruskalEdge> pq = new PriorityQueue<CompKruskalEdge>();

		// Add a list to each node in the array
		for (int i = 0; i < numberOfNodes; i++) {
			cc[i] = new LinkedList<E>();
		}

		// All edges are added into a priorityqueue
		for (List<E> edgeList : this.edges) {
			for (E edge : edgeList) {
				pq.add(new CompKruskalEdge<E>(edge));
			}
		}
		
		int longest;
		int shortest;

		// As long as there are elements left in the priorityqueue, continue.
		while (!pq.isEmpty()) {
			CompKruskalEdge<E> tempEdge = pq.poll();

			// Checks so that it doesn't point to the same element
			if (cc[tempEdge.getTo()] != cc[tempEdge.getFrom()]) {
				// Checks so that the list doesn't already contain the element
				if (!(cc[tempEdge.getFrom()].contains(tempEdge) && cc[tempEdge
						.getTo()].contains(tempEdge))) {
					// Sets the shortest and the longest edge
					if (cc[tempEdge.getFrom()].size() >= cc[tempEdge.getTo()]
							.size()) {
						longest = tempEdge.getFrom();
						shortest = tempEdge.getTo();
					} else {
						longest = tempEdge.getTo();
						shortest = tempEdge.getFrom();
					}

					// Transfer the elements and refer the nodes in cc to the
					// refreshed list.
					for (E edge : cc[shortest]) {
						cc[longest].add(edge);
						cc[edge.to] = cc[longest];
						cc[edge.from] = cc[longest];
					}

					cc[longest].add(tempEdge.getEdge());

					cc[shortest] = cc[longest];

					// Return the iterator if the number of elements it is containing is
					// the number of nodes minus one.
					if (cc[longest].size() == (numberOfNodes - 1)) {
						return cc[longest].iterator();
					}
				}
			}
		}
		return null;
	}

}
