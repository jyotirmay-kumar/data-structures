package io.jyotirmay.ds.queue;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {

	private static final long serialVersionUID = -2640035525967126939L;

	private static class Node<E> {

		private E data;

		private Node<E> next;

		private Node(E data) {
			this.data = data;
		}
	}

	private int size;

	private Node<T> front;

	private Node<T> rear;

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
	public void enqueue(T data) throws FullQueueException {
		Node<T> node = new Node<>(data);

		if (isEmpty()) {
			front = node;
			rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
		size++;
	}

	@Override
	public T peek() {
		if (isEmpty())
			return null;
		return front.data;
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		T data = front.data;

		if (size == 1) {
			front = null;
			rear = null;
		} else {
			front = front.next;
		}
		size--;
		return data;
	}

}
