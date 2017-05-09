package com.github.foo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for BinaryTree
 * @author Gaurav Rai Mazra
 *
 */
public class BinaryTreeTests {
	@Test
	public void rootNodeWithNoChildHasZeroHeight() {
		Tree<Integer> btree = new BinaryTree<Integer>(10);
		Assert.assertEquals("Height is not null", 1, btree.height());
	}
	
	@Test
	public void rootNodeWithSingleChildHasOneHeight() {
		Tree<Integer> btree = new BinaryTree<Integer>(10);
		btree.insert(20);
		Assert.assertEquals("Height is not null", 2, btree.height());
	}
	
	@Test
	public void binaryTreeInorderTraverse() {
		BinaryTree<Integer> btree = new BinaryTree<>(0);
		for (int i = 1; i < 7; i++) {
			btree.insert(i);
		}
		
		Assert.assertArrayEquals(new Integer[] {3, 1, 4, 0, 5, 2, 6}, Trees.traverseBinaryTree(btree.getRoot(), Order.IN));
	}
}
