package io.jyotirmay.ds.stack;

import java.io.Serializable;

public interface Stack<T> extends Serializable, Iterable<T> {

	boolean isEmpty();

	int size();

	void push(T data) throws FullStackException;

	T peek();

	T pop() throws EmptyStackException;

}
