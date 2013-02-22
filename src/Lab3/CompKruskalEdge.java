package lab3;

public class CompKruskalEdge<E> extends BusEdge implements Comparable<E> {

	CompKruskalEdge(int from, int to, double weight, String line) {
		super(from, to, weight, line);
	}

	@Override
	public int compareTo(E e) {
		
		return 0;
	}

}
