package lab2;

import testSortCol.CollectionWithGet;
import datastructures.BinarySearchTree;

//*** N�r en Nod splayas, ska man s�tta dess parent till null? Eller l�ter man dess gamla parent ligga kvar?
//*** Kan en nod som �r mormor (allts� har ett v�nsterbarn som har barn) vara utan ett h�gerbarn?
//Allts�:
//*
public class SplayTree<E extends Comparable<? super E>> extends BinarySearchTree<E> implements CollectionWithGet<E>{
	public SplayTree() {
		super();
	}

	/*
	 * Zig - Rotera 1 steg i h�gervarv, dvs x' y' / \ / \ y' C --> A x' / \ / \
	 * A B B C
	 */
	private void zig(Entry x) {
		Entry y = x.left;
		E temp = x.element;
		x.element = y.element;
		y.element = temp;
		x.left = y.left;
		if (x.left != null)
			x.left.parent = x;
		y.left = y.right;
		y.right = x.right;
		if (y.right != null)
			y.right.parent = y;
		x.right = y;
	} // rotateRight
	/*
	 * Zag - Rotera 1 steg i v�nstervarv, dvs x' y' / \ / \ A y' --> x' C / \ /
	 * \ B C A B
	 */

	private void zag(Entry x) {
		Entry y = x.right;
		E temp = x.element;
		x.element = y.element;
		y.element = temp;
		x.right = y.right;
		if (x.right != null)
			x.right.parent = x;
		y.right = y.left;
		y.left = x.left;
		if (y.left != null)
			y.left.parent = y;
		x.left = y;
	} // rotateLeft
	/*
	 * ZigZag - Rotera 1 steg i h�gervarv, 1 steg i v�nstervarv, dvs x' z' / \ /
	 * \ A y' --> x' y' / \ / \ / \ z D A B C D / \ B C
	 */

	private void zigzag(Entry x) {
		Entry y = x.right, z = x.right.left;
		E e = x.element;
		x.element = z.element;
		z.element = e;
		y.left = z.right;
		if (y.left != null)
			y.left.parent = y;
		z.right = z.left;
		z.left = x.left;
		if (z.left != null)
			z.left.parent = z;
		x.left = z;
		z.parent = x;
	} // zigzag
	/*
	 * ZagZig - Rotera 2 steg i h�gervarv, dvs x' z' / \ / \ y' D --> y' x' / \
	 * / \ / \ A z' A B C D / \ B C
	 */

	private void zagzig(Entry x) {
		Entry y = x.left, z = x.left.right;
		E e = x.element;
		x.element = z.element;
		z.element = e;
		y.right = z.left;
		if (y.right != null)
			y.right.parent = y;
		z.left = z.right;
		z.right = x.right;
		if (z.right != null)
			z.right.parent = z;
		x.right = z;
		z.parent = x;
	} // zagzig
	/*
	 * ZigZig - Rotera 2 steg i h�gervarv, dvs f�rst genom mormor, sedan mamma
	 * x' z' / \ / \ y' D --> A y' / \ / \ z C B x / \ / \A B C D
	 */

	private void zigzig(Entry x) {
		Entry y = x.left, z = x.left.left;
		E e = x.element;
		x.element = z.element;
		z.element = e;
		x.left = z.left;
		if (x.left != null)
			x.left.parent = x;
		y.left = z.right;
		if (y.left != null)
			y.left.parent = y;
		z.left = y.right;
		if (z.left != null)
			z.left.parent = z;
		z.right = x.right;
		if (z.right != null)
			z.right.parent = z;
		x.right = y;
		y.right = z;
	}

	/*
	 * ZagZag - Rotera 2 steg i v�nstervarv, dvs f�rst genom mormor, sedan mamma
	 * x' z' / \ / \ A y' --> y' D' / \ / \ B z x C / \ / \ C D A B
	 */
	private void zagzag(Entry x) {
		Entry y = x.right, z = x.right.right;
		E e = x.element;
		x.element = z.element;
		z.element = e;
		x.right = z.right;
		if (x.right != null)
			x.right.parent = x;
		y.right = z.left;
		if (y.right != null)
			y.right.parent = y;
		z.right = y.left;
		if (z.right != null)
			z.right.parent = z;
		z.left = x.left;
		if (z.left != null)
			z.left.parent = z;
		x.left = y;
		y.left = z;
	}

	private void splayToRoot(Entry node) { // Be�ver man faktiskt tilldela root?
											// Eller om
		if (null != node) {
			while (node != root) {
				if (isLeftChild(node)) {
					if (node.parent == root) {
						zig(node.parent);
					}
					if (isLeftChild(node.parent)) {
						zigzig(node.parent.parent);
					} else
						zigzag(node.parent.parent);
				} else {// hence is a right Child
					if (node.parent == root) {
						zag(node.parent);
					}
					if (isRightChild(node.parent)) {
						zagzag(node.parent.parent);
					} else
						zagzig(node.parent.parent);
				}
			}
		}
	}

	private boolean isLeftChild(Entry node) {
		return (node.parent.left == node);
	}

	private boolean isRightChild(Entry node) {
		return (node.parent.right == node);
	}

	public E get(E elem) {
		if (null == elem) {
			return null;
		} else {
			Entry node = find(elem);
			if (null == node) {
				return null;
			}
			return node.element;
		}
	}

	private Entry find(E elem) {
		if (null == root)
			return null;
		Entry node = root, prev;
		int check = node.element.compareTo(elem);
		while (check != 0) {
			prev = node;
			if (check < 0) {
				prev = node;
				node = node.left;
			} else {
				prev = node;
				node = node.right;
			}
			if (null == node) {
				splayToRoot(prev);
				return null;
			}
			check = node.element.compareTo(elem);
		}
		splayToRoot(node);
		return node;
	}
}