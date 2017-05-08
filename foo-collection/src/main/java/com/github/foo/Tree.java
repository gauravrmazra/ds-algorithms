package com.github.foo;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 * @param <T> of object
 */
public interface Tree<T> {
	public void addChild(T  child);
	
	public void removeChild(T child);
	
	public OrderedCollection<T> traverse(Order order);
	
	public int height();
}
