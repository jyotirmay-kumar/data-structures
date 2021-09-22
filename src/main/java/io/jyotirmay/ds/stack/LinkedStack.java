package io.jyotirmay.ds.stack;

import java.util.Iterator;

public class LinkedStack<T> implements Stack<T> {

	private static final long serialVersionUID = -5884879326558190571L;

	private static class Node<E> {

		private final E data;

		private Node<E> next;

		private Node(E data) {
			this.data = data;
		}
	}

	private int size;

	private Node<T> top;

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
	public void push(T data) throws FullStackException {
		Node<T> node = new Node<>(data);

		if (null != top) {
			node.next = top;
		}

		top = node;
		size++;

	}

	@Override
	public T peek() {
		if (null == top)
			return null;
		return top.data;
	}

	@Override
	public T pop() throws EmptyStackException {
		if (null == top)
			throw new EmptyStackException();
		Node<T> node = top;
		if (top.next == null) {
			top = null;
		} else {
			top = top.next;
		}
		size--;
		return node.data;
	}

}
