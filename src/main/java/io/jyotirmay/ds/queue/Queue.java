package io.jyotirmay.ds.queue;

import java.io.Serializable;

public interface Queue<T> extends Serializable, Iterable<T> {

	boolean isEmpty();

	int size();

	void enqueue(T data) throws FullQueueException;

	T peek();

	T dequeue() throws EmptyQueueException;

}
