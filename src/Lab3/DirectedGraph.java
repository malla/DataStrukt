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
		// ArrayList<Integer> vMinusS= new ArrayList<Integer>(); //Alla noder
		// som ej
		// beräknats ifrån.
		// for (int i=0;i>nodes.length;i++){
		// vMinusS.add(i, i);
		// }
		// ArrayList<Integer> s= new ArrayList<Integer>(); //Alla noder som har
		// beräknats
		PriorityQueue<ComparableDjikstraPath> results = new PriorityQueue<ComparableDjikstraPath>();
		int node = from;
		double cost = 0;
		LinkedList<Integer> path = new LinkedList<Integer>();
		results.add(new ComparableDjikstraPath(node, cost, path));
		ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
		while (!results.isEmpty()) {
			ComparableDjikstraPath djikstra = results.remove();
			node = djikstra.to;
			if (!visitedNodes.contains(node)) {
				if (node == to) {
					/**
					 * return en iterator hur man kom till node.
					 */
				}
			}
			visitedNodes.add(node);
			for (int i = 0; i < nodes[node].size(); i++) {
				int tempToNode = nodes[node].get(i).to;
				double weight = nodes[node].get(i).getWeight();
				LinkedList<Integer> tempPath = djikstra.path;
				tempPath.add(node);
				results.add(new ComparableDjikstraPath(tempToNode, weight,
						tempPath));
			}
		}
		// //Vi börjar kolla...
		// while(fromNode!=to){
		// vMinusS.set(fromNode, null);
		// s.set(fromNode, fromNode);
		// for(int i=0; i<nodes[fromNode].size();i++){
		// double weight=nodes[fromNode].get(i).getWeight();
		// int toNode=nodes[fromNode].get(i).to;
		// d.set(toNode, weight);
		// v.set(toNode, fromNode);
		// if (weight)
		// }
		// }
		return null;
	}

	public class ComparableDjikstraPath implements Comparable {
		private int to;
		private double cost;
		private LinkedList<Integer> path;

		public ComparableDjikstraPath(int to, double cost,
				LinkedList<Integer> path) {
			this.to = to;
			this.cost = cost;
			this.path = path;
		}

		public class CompKruskalEdge<E extends Edge> implements
				Comparable<CompKruskalEdge<E>> {

			private E edge;

			protected CompKruskalEdge(E e) {
				super();
				this.edge = e;
			}

			public double getWeight() {
				return this.edge.getWeight();
			}

			public int getFrom() {
				return this.edge.from;
			}

			public int getTo() {
				return this.edge.to;
			}

			public E getEdge() {
				return this.edge;
			}

			@Override
			public int compareTo(CompKruskalEdge<E> otherEdge) {
				return (int) (getWeight() - otherEdge.getWeight());

			}
		}

		@Override
		public int compareTo(Object comp) throws NullPointerException {
			if (null == comp) {
				throw new NullPointerException();
			} else if (comp.getClass().isInstance(this.getClass())) {
				throw new IllegalArgumentException();
			}
			ComparableDjikstraPath compareTo = (ComparableDjikstraPath) comp;
			if (this.cost == compareTo.cost) {
				return 0;
			} else if (this.cost > compareTo.cost) {
				return 1;
			} else
				return -1;
		}
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

					// Return the iterator if the number of elements it is
					// containing is
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
