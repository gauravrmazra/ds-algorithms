package com.github.foo;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 * @param <T>
 */
public interface Node<T> {

	/**
	 * Value of the node
	 * @return
	 */
	T getValue();
	
	/**
	 * Height of the node
	 * @return
	 */
	int height();

}