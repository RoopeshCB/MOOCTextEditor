package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E> (null);
		tail = new LLNode<E> (null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("NULL POINTER NOT ALLOWED");
		}
		else {
			LLNode<E> n = new LLNode<E>(null);
			n.next = tail;
			n.prev = tail.prev;
			n.next.prev = n;
			n.prev.next = n;
			n.data = element;
		}
		size();
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			LLNode<E> goal = head;
			while(index>=0) {
				goal = goal.next;
				index--;
			}
			return goal.data;
		}
		/*else {
			LLNode<E> goal = head;
			for(int i=0; i<= index; i++) {
				goal = goal.next;
			}
			return goal.data;
		}*/
	}


	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("NULL ELEMENT NOT ALLOWED");
		}
		if(index<0 || index>size()) {
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		}
		LLNode<E> n = new LLNode<E>(element);
		//at starting
		/*if(index == 0) {
			n.next = head.next;
			n.prev = head;
			n.next.prev = n;
			n.prev.next = n;
			//n.data = element;
		}
		//at end
		else if(index == size()) {//if wrong then try goal.next = tail
			n.next = tail;
			n.prev = tail.prev;
			n.next.prev = n;
			n.prev.next = n;
			//n.data = element;
		}*/
		//in middle
		//else {
			LLNode<E> goal; 
			goal = head;
			for(int i = 0; i<index; i++) {
				goal = goal.next;
			}
			n.next = goal.next;
			n.prev = goal;
			n.next.prev = n;
			n.prev.next = n;
	//	}
		size();
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		size = 0;
		LLNode<E> curr = head;
		while(curr.next.data!=null) {
			size++;
			curr = curr.next;
		}
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index<0 || index>=size()) {
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		}
			//E data = get(index);

			/*//remove first node
			if(index == 0) {
				LLNode<E> afterNode = head;
				afterNode = head.next.next;
				afterNode.prev = head;
				head.next = afterNode;
			}
			else if(index == size()-1) {
				LLNode<E> beforeNode = head;
				beforeNode = tail.prev.prev;
				tail.prev = beforeNode;
				beforeNode.next = tail;
			}*/
			//else {
			/*
			 * LLNode<E> beforeNode = head; LLNode<E> afterNode = head; int beforeIndex =
			 * (index - 1); int afterIndex = (index + 1);
			 * 
			 * for(int i=0; i<= beforeIndex; i++) { beforeNode = beforeNode.next; }
			 * 
			 * for(int j=0; j<afterIndex; j++) { afterNode = afterNode.next; }
			 * beforeNode.next = afterNode; afterNode.prev = beforeNode;
			 */
			
			//}
		LLNode<E> goal = head;
		for(int i=0;i<=index;i++) {
			goal = goal.next;
		}
		goal.prev.next = goal.next;
		goal.next.prev = goal.prev;
			return goal.data;
		
		//return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("NULL POINTER EXCEPTION");
		}
		if(index<0 || index>=size()) {
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		}
		else {
			LLNode<E> tmpNode = new LLNode<E>(null);
			LLNode<E> goal = head;
			while(index>=0) {
				goal = goal.next;
				index--;
			}
			tmpNode.data = goal.data;
			goal.data = element;
			return tmpNode.data;
		}
		//return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
