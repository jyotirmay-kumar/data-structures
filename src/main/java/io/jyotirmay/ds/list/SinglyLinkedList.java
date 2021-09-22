package io.jyotirmay.ds.list;

import java.util.Iterator;

public class SinglyLinkedList<T> implements LinkedList<T> {

	private static final long serialVersionUID = 8422397475218742554L;

	private static class Node<E> {

		private final E data;

		private Node<E> next;

		private Node(E data) {
			this.data = data;
		}
	}

	private int size;

	private Node<T> head;

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void addFirst(T data) {
		Node<T> node = new Node<>(data);

		if (null != head) {
			node.next = head;
		}
		head = node;
		size++;
	}

	@Override
	public void addLast(T data) {
		Node<T> node = new Node<>(data);

		if (null == head) {
			head = node;
		} else {
			Node<T> tempNode = head;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = node;
		}

		size++;

	}

	@Override
	public T getFirst() {

		if (null == head)
			return null;
		return head.data;
	}

	@Override
	public T getLast() {
		if (null == head)
			return null;
		Node<T> tempNode = head;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
		}
		return tempNode.data;
	}

	@Override
	public T deleteFirst() throws EmptyListException {

		if (null == head)
			throw new EmptyListException();

		Node<T> node = head;

		if (null == head.next) {
			head = null;
		} else {
			head = head.next;
		}
		size--;
		return node.data;
	}

	@Override
	public T deleteLast() throws EmptyListException {

		if (null == head)
			throw new EmptyListException();

		Node<T> node = head;
		Node<T> tempNode = head;

		if (head.next == null) {
			head = null;
		} else {
			while (node.next.next != null) {
				node = node.next;
			}
			tempNode = node.next;
			node.next = null;
		}
		size--;
		return tempNode.data;
	}

}
