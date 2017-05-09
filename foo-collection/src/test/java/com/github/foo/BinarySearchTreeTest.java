package com.github.foo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for BinarySearchTree
 * @author Sachin
 *
 */
public class BinarySearchTreeTest {
	
	
	private BinarySearchTree getBinaryTree(){
		
		BinarySearchTree<Integer> btree = new BinarySearchTree<>(50);
		btree.insert(10);
		btree.insert(60);
		btree.insert(20);
		btree.insert(70);
		btree.insert(65);
		btree.insert(15);
		return btree;
	}
	
	@Test
	public void rootNodeWithNoChildHasOneHeight() {
		Tree<Integer> btree = new BinarySearchTree<Integer>(10);
		Assert.assertEquals("Height is not null", 1, btree.height());
	}
	
	@Test
	public void rootNodeWithTwoChildHasThreeHeight() {
		Tree<Integer> btree = new BinarySearchTree<Integer>(10);
		btree.insert(20);
		btree.insert(30);
		Assert.assertEquals("Height is not null", 3, btree.height());
	}
	
	@Test
	public void BinarySearchTreeInorderTraverse() {
		
		Assert.assertArrayEquals(new Integer[] {10, 15, 20, 50, 60, 65, 70}, Trees.traverseBinaryTree(getBinaryTree().getRoot(), Order.IN));
	}
	
	@Test
	public void BinarySearchTreeLevelOrderTraverse() {
		
		Assert.assertArrayEquals(new Integer[] {50,10,60,20,70,15,65}, Trees.traverseBinaryTree(getBinaryTree().getRoot(), Order.LEVEL));
	}
}
