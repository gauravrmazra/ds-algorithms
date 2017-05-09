/**
 * 
 */
package com.github.foo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class consists static methods that operates on 
 * Tree. 
 * <p>The methods of this class all throw a <tt>NullPointerException</tt>
 * if the collections or class objects provided to them are null.</p>
 * 
 * @author Sachin
 * @author Gaurav Rai Mazra
 */
public class Trees {
	@SuppressWarnings("unchecked")
	public static <T> T[] traverseBinaryTree(BTNode<T> root, Order order) {
		Objects.requireNonNull(order);
		List<T> elements = new ArrayList<>();
		switch (order) {
		case IN:
			inOrder(root, elements);
			break;
		case PRE:
			preOrder(root, elements);
			break;
		case POST:
			postOrder(root, elements);
			break;
		default:
			throw new IllegalArgumentException("Traversal not supported");
		}
		return (T[]) elements.toArray();
	}

	private static <T> void postOrder(BTNode<T> node, List<T> elements) {
		if (node.left() != null)
			postOrder(node.left(), elements);

		if (node.right() != null)
			postOrder(node.right(), elements);

		elements.add(node.getValue());
	}

	private static <T> void preOrder(BTNode<T> node, List<T> elements) {
		elements.add(node.getValue());

		if (node.left() != null)
			preOrder(node.left(), elements);

		if (node.right() != null)
			preOrder(node.right(), elements);
	}

	private static <T> void inOrder(BTNode<T> node, List<T> elements) {
		if (node.left() != null)
			inOrder(node.left(), elements);

		elements.add(node.getValue());

		if (node.right() != null)
			inOrder(node.right(), elements);
	}
}
