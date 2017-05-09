package com.github.foo;

import java.util.Objects;

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
	 * @param value
	 */
	public BinaryTree(T value) {
		this.root = new BTNode<>(value);
	}

	@Override
	public void insert(T child) {
		root = insert(root, child);
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
				int leftHeight = node.left().height();
				int rightHeight = node.right().height();
				if (leftHeight == rightHeight) {
					BTNode<T> temp = node.right();
					int tempLeftHeight = Objects.isNull(temp.left()) ? 0 : temp.left().height();
					int tempRightHeight = Objects.isNull(temp.right()) ? 0 : temp.right().height();
					if (tempLeftHeight == tempRightHeight) {
						node.left(insert(node.left(), value));
					} else {
						node.right(insert(node.right(), value));
					}
				} else if (leftHeight > rightHeight) {
					BTNode<T> temp = node.left();
					int tempLeftHeight = Objects.isNull(temp.left()) ? 0 : temp.left().height();
					int tempRightHeight = Objects.isNull(temp.right()) ? 0 : temp.right().height();
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
	public void remove(T child) {
		// TODO Need to implement it
	}

	@Override
	public int height() {
		return root.height();
	}

	@Override
	public String toString() {
		return root.toString();
	}

	@Override
	public boolean search(T data) {
		// TODO Need to implement it
		return false;
	}

	@Override
	public BTNode<T> getRoot() {
		return root;
	}
}
