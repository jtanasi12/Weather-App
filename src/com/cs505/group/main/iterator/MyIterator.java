package com.cs505.group.main.iterator;
/**
 * An interface that is used in conjunction with the List implementation.
 * Defines interface for accessing and traversing elements. 
 * 
 * @author josephtanasi10.
 *
 * @param <T> - Generic code.
 */
public interface MyIterator <T>{

	public boolean hasNext();
	public T next();
	
	public void remove();
}