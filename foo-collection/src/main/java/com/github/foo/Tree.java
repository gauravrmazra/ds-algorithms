package com.github.foo;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 * @param <T> of object
 */
public interface Tree<T> {
	/**
	 * Adding a child to tree
	 * @param data
	 */
	public void insert(T  data);
	
	/**
	 * removing a child from tree
	 * It depends on the {@link Object#equals(Object)} implementation
	 * @param data
	 */
	public void remove(T data);
	
	/**
	 * Searches if the data exists in tree or not
	 * It depends on the {@link Object#equals(Object)} method for checking equality
	 * @param data
	 * @return true if data exists otherwise false
	 */
	public boolean search(T data);
	
	/**
	 * returns the height of the tree
	 * @return height of tree
	 */
	public int height();
	
	/**
	 * returns the root node of the tree
	 * @return Node of type T
	 */
	public Node<T> getRoot();
}
