package lab3;


public class CompKruskalEdge<E extends Edge> implements Comparable<CompKruskalEdge<E>> {
	

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
