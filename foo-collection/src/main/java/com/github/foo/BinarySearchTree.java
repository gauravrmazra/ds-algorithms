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

	private BinarySearchTree<T> root;
	private BinarySearchTree<T> leftNode;
	private BinarySearchTree<T> rightNode;
	private T data;

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
		leftNode = null;
		rightNode = null;
		data = value;
		comparator = null;

	}

	public BinarySearchTree(T value, Comparator<? super T> comparator) {
		this.leftNode = null;
		this.rightNode = null;
		this.data = value;
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
		
		if(Objects.isNull(root) ||( Objects.isNull(root.leftNode) && Objects.isNull(root.rightNode))){
			root =this;
		}
		BinarySearchTree<T> tempNode = root;
		insertNode(tempNode, t);
		
	}
	
	
	
	
	private BinarySearchTree<T> insertNode(BinarySearchTree<T> root, T t){

		 	if (root == null) {
		        root = new BinarySearchTree<>(t);
		        return root;
		    }

			if(compare(t, root.data) > 0){
				root.rightNode = insertNode(root.rightNode, t);
			}else{
				root.leftNode = insertNode(root.leftNode, t);
			}
			 return root;
	}
	
//	public  void display(BinarySearchTree<T> root){
//		  if (root == null)
//	          return;
//		display(root.leftNode);
//		System.out.print(root.data+", ");
//		display(root.rightNode);
//		
//}

	
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

	/* (non-Javadoc)
	 * @see com.github.foo.Tree#remove(java.lang.Object)
	 */
	@Override
	public void remove(T child) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.github.foo.Tree#traverse(com.github.foo.Order)
	 */
	@Override
	public T[] traverse(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.foo.Tree#height()
	 */
	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}


}
