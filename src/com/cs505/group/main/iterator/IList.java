package com.cs505.group.main.iterator;
 
/**
 * IList is an interface that models the List collections.
 * Defines an interface for creating a concrete iterator.
 *
 * @author josephtanasi10.
 *
 * @param <T> - generic code so that any list structure can use this interface
 */
public interface IList <T>{

public void addNode(T newObject);
public void insert(int position, T newObject);
public void print();
public int  getSize();
public boolean isEmpty();
public void clear();
public T get(int pos);
public boolean equals (Object o);
public boolean remove(Object o);
public T remove(int pos);

public MyIterator<T> iterator();
/**
 * We create an Iterator to iterate through the List.
 * When we reach the index specified we call the Remove() method.
 * 
 * Shift subsequent elements to the left.
 * 
 * @param pos - specifies the index we want to remove. 
 * @return the element that we are removing 
 */

}    