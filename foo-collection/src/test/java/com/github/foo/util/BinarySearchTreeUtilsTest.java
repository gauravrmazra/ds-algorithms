/**
 * 
 */
package com.github.foo.util;

import org.junit.Assert;
import org.junit.Test;

import com.github.foo.BinarySearchTree;
import com.github.foo.BinaryTree;
/**
 * @author Sachin
 *
 */
public class BinarySearchTreeUtilsTest {

private BinarySearchTree<Integer> getBinarySearchTree(){
		
		BinarySearchTree<Integer> btree = new BinarySearchTree<>(50);
		btree.insert(10);
		btree.insert(60);
		btree.insert(20);
		btree.insert(70);
		btree.insert(65);
		btree.insert(15);
		return btree;
	}

	private BinaryTree<Integer> binaryTree() {
		BinaryTree<Integer> btree = new BinaryTree<>(0);
		for (int i = 1; i < 7; i++) {
			btree.insert(i);
		}
		return btree;
	}

	@Test
	public void minValueOfBinarySearchTree() {
		Assert.assertEquals("Minimum value is not correct", 10, BinarySearchTreeUtils.minValueOf(getBinarySearchTree()));
	}
	
	@Test
	public void maxValueOfBinarySearchTree() {
		Assert.assertEquals("Maximum value is not correct", 70, BinarySearchTreeUtils.maxValueOf(getBinarySearchTree()));
	}

	@Test
	public void isCompleteBinarySearchTree() {
		Assert.assertEquals("TIs not complete binary tree", false, BinarySearchTreeUtils.isCompleteBinarySearchTree(binaryTree()));
	}
}
