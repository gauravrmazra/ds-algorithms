/**
 * 
 */
package com.github.foo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Class consists static methods that operates on 
 * Tree. 
 * <p>The methods of this class all throw a <tt>NullPointerException</tt>
 * if the collections or class objects provided to them are null.</p>
 * 
 * @author Sachin
 * @author Gaurav Rai Mazra
 */
public class Trees {
	@SuppressWarnings("unchecked")
	public static <T> T[] traverseBinaryTree(BTNode<T> root, Order order) {
		Objects.requireNonNull(order);
		List<T> elements = new ArrayList<>();
		switch (order) {
		case IN:
			inOrder(root, elements);
			break;
		case PRE:
			preOrder(root, elements);
			break;
		case POST:
			postOrder(root, elements);
			break;
		case LEVEL:
			levelOrder(root, elements);
			break;	
		default:
			throw new IllegalArgumentException("Traversal not supported");
		}
		return (T[]) elements.toArray();
	}

	/**
	 * @param <T>
	 * @param root
	 * @param elements
	 */
	private static <T> void levelOrder(BTNode<T> root, List<T> elements) {
		Queue<BTNode<T>> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BTNode<T> node = queue.poll();
			elements.add(node.getValue());
			if(Objects.nonNull(node.left())){
				queue.add(node.left());
			}
			if(Objects.nonNull(node.right())){
				queue.add(node.right());
			}
		}
	}

	private static <T> void postOrder(BTNode<T> node, List<T> elements) {
		if (node.left() != null)
			postOrder(node.left(), elements);

		if (node.right() != null)
			postOrder(node.right(), elements);

		elements.add(node.getValue());
	}

	private static <T> void preOrder(BTNode<T> node, List<T> elements) {
		elements.add(node.getValue());

		if (node.left() != null)
			preOrder(node.left(), elements);

		if (node.right() != null)
			preOrder(node.right(), elements);
	}

	private static <T> void inOrder(BTNode<T> node, List<T> elements) {
		if (node.left() != null)
			inOrder(node.left(), elements);

		elements.add(node.getValue());

		if (node.right() != null)
			inOrder(node.right(), elements);
	}
	
	/**
	 * Creates a BinarySearchTree of Collection
	 * It will throw IllegalArgumentException if elements is null or empty
	 * and NullPointerException if any element from collection is null
	 * @param elements to use for Creating BST
	 * @return BinarySearchTree of type T
	 */
	public static <T> BinarySearchTree<T> binarySearchTreeOf(Collection<T> elements) {
		return (BinarySearchTree<T>) treeOf(elements, BinarySearchTree<T>::new);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> boolean isBinarySearchTree(BTNode<T> node){
		T[] nodes = traverseBinaryTree(node, Order.IN);
		T v1 = nodes[0];
		for(int i=1;i< nodes.length;i++){
			if(((Comparable<? super T>) v1).compareTo((T) nodes[i]) >0){
				return false;
			}else{
				v1 = nodes[i];
			}
		}
		return true;
	}
	
	
	/**
	 * Create a BinaryTree of the Collection
	 * It will throw IllegalArgumentException if elements is null or empty
	 * and NullPointerException if any element from collection is null
	 * @param elements to use for Creating BST
	 * @return BinaryTree of type T
	 */
	public static <T> BinaryTree<T> binaryTreeOf(Collection<T> elements) {
		return (BinaryTree<T>)treeOf(elements, BinaryTree<T>::new);
	}
	
	@FunctionalInterface
	private interface TreeCreator<T> {
		public Tree<T> createTree(T t);
	}

	private static <T> Tree<T>  treeOf(Collection<T> elements, TreeCreator<T> treeCreator) {
		if (Objects.isNull(elements) || elements.isEmpty()) {
			throw new IllegalArgumentException("We need atleast one element in collection to build BST!!!");
		}
		Iterator<T> eItr = elements.iterator();
		Tree<T> tree = treeCreator.createTree(Objects.requireNonNull(eItr.next()));
		while (eItr.hasNext()) {
			tree.insert(Objects.requireNonNull(eItr.next()));
		}
		return tree;
	}
	
}
