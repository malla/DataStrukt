package lab3;

import java.util.LinkedList;

import lab3.ComparableDijkstraPath;

public class ComparableDijkstraPath {
	public class ComparableDjikstraPath implements Comparable {
		private int to;
		private double cost;
		private LinkedList<Integer> path;

		public void ComparableDijkstraPath(int to, double cost,
				LinkedList<Integer> path) {
			this.to = to;
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
			ComparableDjikstraPath compareTo = (ComparableDjikstraPath) comp;
			if (this.cost == compareTo.cost) {
				return 0;
			} else if (this.cost > compareTo.cost) {
				return 1;
			} else
				return -1;
		}
	}

}
