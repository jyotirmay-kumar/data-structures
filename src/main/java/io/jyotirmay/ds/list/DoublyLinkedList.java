package io.jyotirmay.ds.list;

import java.util.Iterator;

public class DoublyLinkedList<T> implements LinkedList<T> {

	private static final long serialVersionUID = -1481687519921515717L;

	private static class Node<E> {

		private E data;

		private Node<E> previous;

		private Node<E> next;

		private Node(E data) {
			this.data = data;
		}
	}

	private int size;

	private Node<T> head;

	private Node<T> tail;

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

		if (null == head) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.previous = node;
			head = node;
		}
		size++;
	}

	@Override
	public void addLast(T data) {
		Node<T> node = new Node<>(data);

		if (null == tail) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.previous = tail;
			tail = node;
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
		if (null == tail)
			return null;
		return tail.data;
	}

	@Override
	public T deleteFirst() throws EmptyListException {
		if (null == head)
			throw new EmptyListException();

		Node<T> node = head;
		if (null == head.next) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			head.previous = null;
		}
		size--;
		return node.data;
	}

	@Override
	public T deleteLast() throws EmptyListException {
		if (null == tail)
			throw new EmptyListException();

		Node<T> node = tail;

		if (null == tail.previous) {
			tail = null;
			head = null;
		} else {
			tail = tail.previous;
			tail.next = null;
		}

		size--;
		return node.data;
	}

}
