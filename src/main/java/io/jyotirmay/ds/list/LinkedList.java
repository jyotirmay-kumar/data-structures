package io.jyotirmay.ds.list;

import java.io.Serializable;

public interface LinkedList<T> extends Serializable, Iterable<T> {
	
	boolean isEmpty();
	
	int size();
	
	void addFirst(T data);
	
	void addLast(T data);
	
	T getFirst();
	
	T getLast();
	
	T deleteFirst() throws EmptyListException;
	
	T deleteLast() throws EmptyListException;	

}
