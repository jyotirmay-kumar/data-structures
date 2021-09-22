package io.jyotirmay.ds.tree;

import java.io.Serializable;

public class BinaryTree<E> implements Serializable {

	private static class Node<T> implements Serializable {

		private T data;

		private Node<T> parent;

		private Node<T> left;

		private Node<T> right;

		private Node(T data){
			this.data = data;
		}
	}

	private int size;

	private Node<E> root;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public Node<E> addRoot(E data){
		if(!isEmpty())
			throw new IllegalStateException();
		Node<E> newNode = new Node<>(data);
		root = newNode;
		size++;
	}

	public Node<E> addLeft(Node<E> node, E data){
		if(null != node.left)
			throw new IllegalStateException();
		Node<E> newNode = new Node<>(data);
		node.left = newNode;
		size++;

	}

	public Node<E> addRight(Node<E> node, E data) {
		if(null != node.right)
			throw new IllegalStateException();
		Node<E> newNode = new Node<>(data);
		node.right = newNode;
		size++;
	}

	public Node<E> getRoot(){
		return root;
	}

	public Node<E> getLeft(Node<E> node){
		return node.left;
	}

	public Node<E> getRight(Node<E> node){
		return node.right;
	}

	public boolean isRoot(Node<E> node){
		return node == root;
	}

	public boolean isInternal(Node<E> node){
		return null == node.left ? null == node.right : false;
	}

	public E remove(Node<E> node){

		return null;
	}


}
