package lab3;

public class CompKruskalEdge<E extends Edge> implements Comparable<E> {
	

	public E edge;	

	public CompKruskalEdge(E e) {
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

	public String toString() {
		return this.edge.toString();
	}

	@Override
	public int compareTo(E otherEdge) {
		if (this.getWeight() < otherEdge.getWeight()) {
			return -1;
		} else if (this.getWeight() == otherEdge.getWeight()) {
			return 0;
		} else {
			return 1;
		}
	}
}
