package com.github.foo;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 * @param <T> of object
 */
public interface Tree<T> {
	public void insert(T t);
	
	public void delete(T t);
	
	public OrderedCollection<T> traverse(Order order);
	
	public int height();
}
