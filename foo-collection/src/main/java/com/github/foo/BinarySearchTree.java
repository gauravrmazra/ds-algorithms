/**
 * 
 */
package com.github.foo;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Sachin
 * @param <T>
 *
 */
public class BinarySearchTree<T> implements Tree<T> {

	private BTNode<T> root;

	private final Comparator<? super T> comparator;

	/**
	 * Constructs a new, empty BinarySearchTree, using the natural ordering of
	 * its node values. Inserted node values must implement the
	 * {@link Comparable} interface. Furthermore, all such values must be
	 * <em>mutually comparable</em>: {@code value1.compareTo(value1)} must not
	 * throw a {@code ClassCastException} for any value {@code value1} and
	 * {@code value2} in the BinarySearchTree. If the user attempts to add value
	 * that violates this constraint (for example, the user attempts to put a
	 * string value into a BianrySearchTree that is intended to contain
	 * integers), the {@code insert(Object value)} call will throw a
	 * {@code ClassCastException}.
	 */
	public BinarySearchTree(T value) {
		this(value, null);
	}

	public BinarySearchTree(T value, Comparator<? super T> comparator) {
		root = new BTNode<>(value);
		this.comparator = comparator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.foo.Tree#insert(java.lang.Object)
	 */
	@Override
	public void insert(T t) {
		Objects.requireNonNull(t);
		insertNode(root, t);
	}

	private BTNode<T> insertNode(BTNode<T> root, T t) {
		if (root == null) {
			root = new BTNode<>(t);
			return root;
		}
		if (compare(t, root.getValue()) > 0) {
			root.right(insertNode(root.right(), t));
		} else {
			root.left(insertNode(root.left(), t));
		}
		return root;
	}

	/**
	 * Compares two values based on comparator
	 * 
	 * @param value1
	 * @param value2
	 * @return
	 */
	@SuppressWarnings("unchecked")
	final int compare(Object value1, Object value2) {
		return comparator == null ? ((Comparable<? super T>) value1).compareTo((T) value2)
				: comparator.compare((T) value1, (T) value2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.foo.Tree#remove(java.lang.Object)
	 */
	@Override
	public void remove(T child) {
		// TODO Auto-generated method stub

	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.foo.Tree#height()
	 */
	@Override
	public int height() {
		return height(root);
	}

	private int height(BTNode<T> node){
		if(Objects.isNull(node)){
			return 0;
		}else{
			int leftDepth = height(node.left());
			int rightDepth = height(node.right());
			return Math.max(leftDepth, rightDepth)+1;
		}
	}
	/* (non-Javadoc)
	 * @see com.github.foo.Tree#search(java.lang.Object)
	 */
	@Override
	public boolean search(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.github.foo.Tree#getRoot()
	 */
	@Override
	public BTNode<T> getRoot() {
		return root;
	}

}
