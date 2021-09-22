package io.jyotirmay.ds.queue;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements Queue<T> {

	private static final long serialVersionUID = 6437039201130455023L;

	private T[] queue;

	private int size;

	public ArrayQueue(int length) {
		queue = (T[]) new Object[length];
	}

	public ArrayQueue() {
		queue = (T[]) new Object[10];
	}

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
		if (size == queue.length)
			throw new FullQueueException();

		queue[size] = data;
		size++;

	}

	@Override
	public T peek() {
		if (isEmpty())
			return null;
		return queue[0];
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		
		T data = queue[0];
		
		for(int i=1; i<= size; i++) {
			queue[i-1] = queue[i];
		}
		size--;
		return data;
	}

}
