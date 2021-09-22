package io.jyotirmay.ds.stack;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArrayStack<T> implements Stack<T> {

	private static final long serialVersionUID = 4659152475759562988L;
	
	private int size;
	
	private final T[] stack;
	
	public ArrayStack(int length) {
		stack =  (T[]) new Object[length];
	}
	
	public ArrayStack() {
		stack =  (T[]) new Object[10];
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
	public void push(T data) throws FullStackException {
		if(size >= stack.length) {
			throw new FullStackException();
		}
		
		stack[size] = data;
		size++;
		
	}

	@Override
	public T peek() {
		if(isEmpty())
			return null;
		return stack[size - 1];
	}

	@Override
	public T pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		
		T data = stack[size - 1];
		size--;
		return data;
	}

}
