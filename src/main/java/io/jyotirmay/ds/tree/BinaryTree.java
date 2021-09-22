package io.jyotirmay.ds.tree;

import java.io.Serializable;

public class BinaryTree<T> implements Serializable {

	private static final long serialVersionUID = 1077620956000198456L;

	private static class Node<E> {

		private E data;

		private Node<E> parent;

		private Node<E> leftChild;

		private Node<E> rightChild;

		private Node(E data, Node<E> parent) {
			this.data = data;
			this.parent = parent;
		}

	}

	private int size;

	private Node<T> root;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void addRoot(T data) {
		if (!isEmpty())
			throw new IllegalStateException("Tree is not empty");

		Node<T> node = new Node<>(data, null);
		root = node;
		size++;
	}
	
	

}
