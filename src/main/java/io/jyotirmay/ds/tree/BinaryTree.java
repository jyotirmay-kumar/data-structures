package io.jyotirmay.ds.tree;

import java.io.Serializable;

public class BinaryTree<T> implements Serializable {

	private static class Node<E> implements Serializable {

		private E data;

		private Node<E> parent, left, right;

		private Node(E data){
			this.data = data;
		}
	}

	private int size;

	private Node<T> root;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}



}
