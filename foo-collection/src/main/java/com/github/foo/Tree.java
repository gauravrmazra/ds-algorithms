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
	 * @param child
	 */
	public void insert(T  child);
	
	/**
	 * removing a child from tree
	 * It depends on the {@link Object#equals(Object)} implementation
	 * @param child
	 */
	public void remove(T child);
	
	/**
	 * Traverse the collection and returned the ordered array
	 * @param order to traverse
	 * @return
	 */
	public T[] traverse(Order order);
	
	/**
	 * returns the height of the tree
	 * @return height of tree
	 */
	public int height();
}
