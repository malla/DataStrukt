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
	private int numberOfNodes;
	private List<E>[] edges;

	public DirectedGraph(int noOfNodes) {
		edges = (List<E>[]) new LinkedList[noOfNodes];
		numberOfNodes = noOfNodes;
		for (int i = 0; i < noOfNodes; i++) {
			edges[i] = new LinkedList<E>();
		}
	}

	public void addEdge(E e) {
		edges[e.from].add(e);
	}

	public Iterator<E> shortestPath(int from, int to) { // Malla
		PriorityQueue<ComparableDijkstraPath> results = new PriorityQueue<ComparableDijkstraPath>();
		ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
		int node = from;
		results.add(new ComparableDijkstraPath(node, 0, new LinkedList<E>()));
		ComparableDijkstraPath djikstra;
		while (!results.isEmpty()) {
			djikstra = results.poll();
			node = djikstra.node;
			if (!visitedNodes.contains(node)) {
				if (node == to) {
					return djikstra.path.iterator();
				} else {
					visitedNodes.add(node);
					for (int i = 0; i < edges[node].size(); i++) {
						E connection = edges[node].get(i);
						int connectionNode = connection.to;
						double totalCost = connection.getWeight()
								+ djikstra.cost;
						LinkedList<E> newPath = new LinkedList<E>(djikstra.path);
						newPath.add(connection);
						results.add(new ComparableDijkstraPath(connectionNode,
								totalCost, newPath));
					}
				}
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public class ComparableDijkstraPath implements Comparable {
		private int node;
		private double cost;
		private LinkedList<E> path;

		public ComparableDijkstraPath(int to, double cost, LinkedList<E> path) {
			this.node = to;
			this.cost = cost;
			this.path = path;
		}

		@Override
		public int compareTo(Object comp) throws NullPointerException {
			if (null == comp) {
				throw new NullPointerException();
			} else if (comp.getClass().isInstance(this.getClass())) {
				throw new IllegalArgumentException();
			}
			@SuppressWarnings("unchecked")
			ComparableDijkstraPath compareTo = (ComparableDijkstraPath) comp;
			if (this.cost == compareTo.cost) {
				return 0;
			} else if (this.cost > compareTo.cost) {
				return 1;
			} else
				return -1;
		}
	}

	/**
	 * CompKruskalEdge can compare different edges, get their To, From and
	 * weight.
	 * 
	 * @param <E>
	 */

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
		public int compareTo(CompKruskalEdge<E> edge) {
			return (int) (getWeight() - edge.getWeight());
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
		for (int i = 0; i < edges.length; i++) {
			for (E edge : edges[i]) {
				pq.add(new CompKruskalEdge<E>(edge));
			}
		}
		int longest;
		int shortest;
		// As long as there are elements left in the priorityqueue, continue.
		while (!pq.isEmpty()) {
			@SuppressWarnings("unchecked")
			CompKruskalEdge<E> tempEdge = pq.poll();
			// Checks so that it doesn't point to the same element
			if (cc[tempEdge.getTo()] != cc[tempEdge.getFrom()]) {
				// Checks so that the list doesn't already contain the element
				if (!(cc[tempEdge.getFrom()].contains(tempEdge) && cc[tempEdge
						.getTo()].contains(tempEdge))) {
					// Sets the shortest and the longest edge
					if (cc[tempEdge.getFrom()].size() <= cc[tempEdge.getTo()]
							.size()) {
						longest = tempEdge.getTo();
						shortest = tempEdge.getFrom();
						
					} else {
						longest = tempEdge.getFrom();
						shortest = tempEdge.getTo();
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
		// Otherwise return null
		return null;
	}
}

