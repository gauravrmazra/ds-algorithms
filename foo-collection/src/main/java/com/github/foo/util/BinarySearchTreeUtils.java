/**
 * 
 */
package com.github.foo.util;

import java.util.Objects;

import com.github.foo.BTNode;
import com.github.foo.BinarySearchTree;
import com.github.foo.BinaryTree;

/**
 * @author Sachin
 *
 */
public class BinarySearchTreeUtils {
	
	

	public static <T> T minValueOf(BinarySearchTree<T> bst){
		if(Objects.isNull(bst)){
			throw new IllegalArgumentException("Binary search tree instance can not be null.");
		}
		BTNode<T> root = bst.getRoot();
		
		while(Objects.nonNull(root.left())){
			root= root.left();
		}
		return root.getValue();
	}

	/**
	 * @param binarySearchTree
	 * @return
	 */
	public static <T> T maxValueOf(BinarySearchTree<T> bst) {
		if(Objects.isNull(bst)){
			throw new IllegalArgumentException("Binary search tree instance can not be null.");
		}
		BTNode<T> root = bst.getRoot();
		
		while(Objects.nonNull(root.right())){
			root= root.right();
		}
		return root.getValue();
	}

	/**
	 * @param binarySearchTree
	 * @return
	 */
	public static <T> boolean isCompleteBinarySearchTree(BinaryTree<T> bTree) {
		if(Objects.isNull(bTree)){
			throw new IllegalArgumentException("Binary tree instance can not be null.");
		}
		BTNode<T> root = bTree.getRoot();
		return isCompleteBinarySearchTree(root);
	}
	
	@SuppressWarnings("unchecked")
	private static <T> boolean isCompleteBinarySearchTree(BTNode<T> root){
		if(Objects.isNull(root)){
			return true;
		}
		if(Objects.nonNull(root.left()) && ((Comparable<? super T>) root.left().getValue()).compareTo((T) root.getValue()) >0) {
			return false;
		}
		if(Objects.nonNull(root.right()) && ((Comparable<? super T>) root.right().getValue()).compareTo((T) root.getValue()) <0) {
			return false;
		}
		if(!isCompleteBinarySearchTree(root.left()) || !isCompleteBinarySearchTree(root.right())){
			return false;
		}
		return true;
	}
	
}
