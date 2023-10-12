package com.cs505.group.main.iterator;

import java.util.*;

/**
 * 
 * Represents a singly linked-list and implements the 
 * iterator method and returns an instance of a concrete MyIterator.
 * 
 * Head Node refers to the first Node in the List.
 * 
 * Tail Node refers to the last Node in the List.
 * 
 * @author josephtanasi10.
 *
 * @param <T> - Generic code.
 */
public class LinkList <T>implements IList<T>{
	private Node<T> head;
	private Node<T> tail;
	private int listSize;
	
	/**
	 * LinkList Constructor we start the list with the head and tail pointing 
	 * to nothing and the listSize equaling zero. 
	 */
	public LinkList() {
		head = null;
		tail = null;
		listSize = 0;
	}
	
	/**
	 * Adds a Node to the List. If the list is empty the object
	 * being added will be the first Node and both the head and tail
	 * will point to it.
	 * 
	 * If the list is not empty, the object will be placed after the tail.
	 * The tail will then point to the last object. 
	 * 
	 * listSize - will keep track of the size of the List.
	 * 
	 * @param newObject - a new object we want to store as a Node.
	 *  
	 */
	@Override
	public void addNode(T newObject) {

		if(isEmpty()) {
			head = new Node<T>(newObject, null);
			tail = head;
		}
		else {
			tail.setNextNode(new Node<T>(newObject, null));
			tail = tail.getNextNode();
		}
		
		this.listSize++;
	}
	
	/**
	 * The client specifies where in the List they want the Node to be added. 
	 * 
	 * @param position - Specify the index in the List that we want to insert
	 * the Node. 
	 * 
	 * @param newObject - the Object we want to create as a Node. 
	 * 
	 * @throws IndexOutOfBoundsException - if the position specified is below 0
	 * or a number that is above the size of the List. 
	 */
	@Override
	public void insert(int position, T newObject) {
		if(position < 0 || position > getSize())
			throw new IndexOutOfBoundsException();
		
		// Adding to the end or beginning of the list 
		if(position == getSize()) {
			
			addNode(newObject);
			return;
		}
		
		// If we are adding to the beginning of a list that is not empty 
		if(position == 0) {
			head = new Node<T>(newObject, head);
		}
		
		// We are inserting into the middle of the list 
		else {
			
			Node<T> current = head;
			for(int i = 0; i < position-1; i++) {
				current = current.getNextNode();
			}
			
			// Current is now the node before the index where we want to add
			current.setNextNode(new Node<T>(newObject, current.getNextNode()));
		}
		listSize++;

	}
	
	/**
	 * Calls the toString() method to display the contents of the List.
	 */
	@Override
	public void print() {
		System.out.println(toString());

		}
	
	/**
	 * Returns the size of the List, the elements in the list is zero-based.
	 * So a size of 4 = elements[0,1,2,3].
	 */
	@Override
	public int getSize() {
		return this.listSize;
	}
	
	/**
	 * Tells the user if the List is empty. A size of 0 =='s an empty List. 
	 */
	@Override
	public boolean isEmpty() {
		return this.getSize() == 0;
	}
	
	/**
	 * Clears the List by reseting the Head and Tail pointers. 
	 * 
	 * Thus the listSize is reset as well. 
	 */
	@Override
	public void clear() {
		head = null;
		tail = null;
		listSize = 0;
	}
	
	/**
	 * Allows the user to retrieve a specific Node in the List. 
	 * 
	 * @param pos the index in the List the user wants to retrieve. 
	 */
	@Override
	public T get(int pos) {
		
		if(pos < 0 || pos >= getSize()) 
			throw new IndexOutOfBoundsException();
		
		if(pos < getSize()-1) {
			
			Node<T> current = head;
			for(int i = 0; i < pos; i++) {
				current = current.getNextNode();
			}
			
			return current.getNode();
		}

	 return tail.getNode();
	
	}

	/**
	 * We create an Iterator to iterate through the List.
	 * When we reach the index specified we call the Remove() method.
	 * 
	 * Shift subsequent elements to the left.
	 * 
	 * @param pos - specifies the index we want to remove. 
	 * @return the element that we are removing 
	 */

	 @Override
	 public T remove(int pos) {
		 if( pos < 0 || pos >= getSize())
			 throw new IndexOutOfBoundsException();
		 
		 
		 MyIterator<T> iterate = this.iterator();
		 
		for(int j = 0; j < pos; j++) {
			iterate.next();
		}
		
		T element = iterate.next();
		
		iterate.remove();
		
		return element;
		 
	 }

	 /**
	  * Compares to List Objects to determine if they are the "equal".
	  * Two objects are equal if they contain the same elements and are the same size. 
	  * Two objects are equal if they point to the same memory address. 
	  * 
	  * @param Object o - represents an Object. We want to determine if the Object
	  * being passed is an instance of the LinkList class. Return false if it not.
	  */
	@Override
	public boolean equals (Object o) {
		if(o instanceof LinkList) {
			
			LinkList<T> otherList = (LinkList<T>)o;
			
			if(this.getSize() == otherList.getSize()) {
				MyIterator<T> list1 = this.iterator();
				MyIterator<T> list2 = otherList.iterator();
				
				while(list1.hasNext()) {
					Object e1 = list1.next();
					Object e2 = list2.next();
					
					if(!(e1==null ? e2==null : e1.equals(e2)))
						return false;
				}
				return true;
			}
				
		}
		
		return false;
	}

	/**
	 * Removes the first occurrence of the element from the list if it exist or 
	 * the element with the lowest index. 
	 * 
	 * 
	 * 
	 * @param - Object o - passes an object that we want to remove. 
	 */
	@Override
	public boolean remove(Object o) {
		MyIterator<T> iterator = this.iterator();
		
		while(iterator.hasNext())
		{
			T element = iterator.next();
			
			if(o==null ? element == null : o.equals(element)) {
				iterator.remove();
				return true;
			}
		}

		return false;
	}
	
	/**
	 *  Returns an iterator that we create by calling the LinkedListIterator. 
	 *  
	 */
	public MyIterator<T> iterator(){
		return new LinkedListIterator();
	}
	
	/**
	 * Returns the hash code value for the list. 
	 */
	@Override
	public int hashCode() {
		int hashCode = 1;
		
		Node<T> currentNode = head;
		
		for(int i = 0; i < getSize(); i++) {
			
		T element = currentNode.getNode();
		
		hashCode = 31 * hashCode + (element==null ? 0 : element.hashCode());
		
		currentNode = currentNode.nextNode;
		
		}
		
		return hashCode;
	}
	
	/**
	 * Appends strings onto the internal method variable "result" 
	 * that we retrieve from the toString() method on an iterator 
	 * that we create. The logic of this method will display a comma 
	 * after every object except the last one.
	 */
	@Override
	public String toString() {
		
		String result = "";
		
		MyIterator<T> iterate = this.iterator();
		
		
			
		while(iterate.hasNext()) {
			
			result += iterate.toString() + "\n";
			iterate.next();
		}
		
	
		return result;
	}
	
	/**
	 * This is an inner nested class that is implemented so that 
	 * it can iterate through a IList class. 
	 * 
	 * @author josephtanasi10
	 *
	 */
	private class LinkedListIterator implements MyIterator<T>{
		private Node<T> current;
		private Node<T> previous; 
		private Node<T> previous2;
		
		private boolean removeCalled;
		
		/**
		 * LinkedListIterator Constructor sets a reference to the Current Node to the List's head pointer.
		 * 
		 */
		public LinkedListIterator() {
			current = head;
			previous = null;
			previous2 = null;
			removeCalled = false;
		}
		
		/**
		 * Traverse one element to the right in the List and return the previous element. 
		 * 
		 * Current will point to the next iteration.
		 * Previous will point to the Node before(to the left) of Current.
		 * Previous2 will point to the Node before previous. 
		 * 
		 * @throws NoSuchElementException if the list is empty. 
		 */
		 @Override
		public T next() {
			if(current == null)
				throw new NoSuchElementException();
			
			// SAVE DATA BEFORE WE TRAVERSE
			T temp = current.getNode(); 
			previous2 = previous;
			previous = current; 
			current = current.getNextNode();
		 
			//After next() is called we set removeCalled to false so that we can
			//call the remove method. 
			removeCalled = false;
			return temp;
		}
		
		/**
		 * Return true if the iterator has more elements. 
		 */
		 @Override
		public boolean hasNext() {
			return current!= null;
		}
		
		/**
		 * Removes the last element returned by the Next() Method. 
		 * 
		 * This method can only be called once per call to next().
		 * 
		 * @throws IllegalStateException if the next() method has not been called. 
		 */
		 @Override
		public void remove() {
			if(previous == null || removeCalled)
				throw new IllegalStateException();
			
			// We called hasNext() Once so we are the first node in the list
			if(previous2 == null)
				head = current;
			else {
				previous2.setNextNode(current);
				previous = previous2;
			}
			
			listSize--;
			removeCalled = true;
		}
		
		/**
		 * Returns a string that calls the current Nodes toString() method.
		 */
		public String toString() {
			
			String result = current.toString();
			
			return result;
		}
		
	}

	/**
	 * A static nested class that represents a single Node that will be implemented 
	 * inside the LinkedList and Iterator. 
	 * 
	 * @author josephtanasi10
	 *
	 * @param <T> - Generic Code. 
	 */
		private static class Node<T>{
			
			private Node<T> nextNode; 
			private T newObject;
			
			/**
			 * Node constructor. 
			 * 
			 * @param newObject passes an object to store inside of the Node. 
			 * 
			 * @param nextNode passes a pointer to the next node in the List chain. 
			 */
			private Node(T newObject, Node<T> nextNode) {
				
				this.newObject = newObject;
				this.nextNode = nextNode;
				
			}
			
			/**
			 * 
			 * @return this.newObject returns the object the Node is holding onto.
			 */
			
			private T getNode() {
				
				return this.newObject;
			}
			
			/**
			 * 
			 * @param newNode pass the nextNode this current node will point too.
			 * 
			 * EX: OriginalNode --> newNode.
			 */
			private void setNextNode(Node<T> newNode) {
				this.nextNode = newNode;
			}
			
			
			/**
			 * 
			 * @return this.NextNode - returns the Node this current Node is pointing to.
			 */
			private Node<T> getNextNode() {
				return this.nextNode;
			}
			
		 
			/**
			 * Stores the objects toString() method that is stored inside of the Node.
			 */
			public String toString() {
				String result = this.newObject.toString();
				
				return result;
			}
		}
}