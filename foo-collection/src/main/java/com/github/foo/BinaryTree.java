package com.github.foo;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 * @param <T>
 */
public class BinaryTree<T> implements Tree<T> {
	private BTNode<T> root;

	/**
	 * Create a Binary tree and self as root node
	 * 
	 * @param data
	 */
	public BinaryTree(T data) {
		this.root = new BTNode<>(data);
	}

	@Override
	public void insert(T data) {
		root = insert(root, data);
	}

	private BTNode<T> insert(BTNode<T> node, T value) {
		if (node == null)
			node = new BTNode<>(value);
		else {
			if (Objects.isNull(node.left())) {
				node.left(insert(node.left(), value));
			} else if (Objects.isNull(node.right())) {
				node.right(insert(node.right(), value));
			} else {
				int leftHeight = heightOf(node.left(), 1);
				int rightHeight = heightOf(node.right(), 1);
				if (leftHeight == rightHeight) {
					BTNode<T> temp = node.right();
					int tempLeftHeight = Objects.isNull(temp.left()) ? 0 : heightOf(temp.left(), 1);
					int tempRightHeight = Objects.isNull(temp.right()) ? 0 : heightOf(temp.right(), 1);
					if (tempLeftHeight == tempRightHeight) {
						node.left(insert(node.left(), value));
					} else {
						node.right(insert(node.right(), value));
					}
				} else if (leftHeight > rightHeight) {
					BTNode<T> temp = node.left();
					int tempLeftHeight = Objects.isNull(temp.left()) ? 0 : heightOf(temp.left(), 1);
					int tempRightHeight = Objects.isNull(temp.right()) ? 0 : heightOf(temp.right(), 1);
					if (tempLeftHeight == tempRightHeight) {
						node.right(insert(node.right(), value));
					} else {
						node.left(insert(node.left(), value));
					}
				} else {
					node.right(insert(node.right(), value));
				}
			}
		}
		return node;
	}

	@Override
	public void remove(T data) {
		Objects.requireNonNull(data);
		remove(root, data);
	}

	private void remove(BTNode<T> node, T data) {
		if (node.getValue().equals(data)) {
			BTNode<T> leftNode = node.left();
			if (Objects.isNull(leftNode)) {
				// TODO need to implement
			}
		}
	}

	@Override
	public int height() {
		return heightOf(root, 1);
	}

	private static <T> int heightOf(BTNode<T> node, int acc) {
		if (Objects.nonNull(node) && Objects.nonNull(node.left())) {
			return heightOf(node.left(), acc + 1);
		}
		return acc;
	}

	@Override
	public String toString() {
		return root.toString();
	}

	@Override
	public boolean search(T data) {
		if (Objects.isNull(data))
			return false;

		Queue<BTNode<T>> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			BTNode<T> node = queue.poll();
			if (node.getValue().equals(data)) {
				return true;
			}

			if (Objects.nonNull(node.left())) {
				queue.offer(node.left());
			}

			if (Objects.nonNull(node.right())) {
				queue.offer(node.right());
			}
		}
		return false;
	}

	@Override
	public BTNode<T> getRoot() {
		return root;
	}
}
