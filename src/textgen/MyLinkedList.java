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
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null)
			throw new NullPointerException();
		else {
			LLNode<E> addThis = new LLNode<E>(element);
			if (size == 0) {
				head.next = addThis;
				addThis.prev = head;
				addThis.next = tail;
				tail.prev = addThis;
			}
			else {
				LLNode<E> current = head;
				for (int i = 0; i < size; i++) {
					current = current.next;
				}
				current.next = addThis;
				addThis.prev = current;
				addThis.next = tail;
				tail.prev = addThis;
			}
			size++;
		}
//		if (size == 0) {
//			add(0, element);
//			return false;
//		}
//		else {
//			add(size - 1, element);
//		}
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		LLNode<E> current = head; // head and tail r useless ones need change xia code!!!!	
		if (index >= 0 && index < size) {
			for (int i = 0; i <= index; i++) {
				current = current.next;
			}
		}
		else {
			throw new IndexOutOfBoundsException();
		}
		return current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	//this method got problem a!!!!!!!!!!!!!!!!!!
	public void add(int index, E element )
	{
		// TODO: Implement this method
		if (element == null)
			throw new NullPointerException();
		else {
			LLNode<E> addThis = new LLNode<E>(element);
			if (index >= 0 && index < size) {
				if (size == 0) {
					head.next = addThis;
					addThis.prev = head;
					addThis.next = tail;
					tail.prev = addThis;
				}
				else {
					LLNode<E> oneLess = head;
					for (int i = 0; i < index; i++)
						oneLess = oneLess.next;
					oneLess.next.prev = addThis;
					addThis.next = oneLess.next;
					oneLess.next = addThis;		
					addThis.prev = oneLess;
				}
				size++;
			}
			else if (index == size) {
				LLNode<E> current = head;
				for (int i = 0; i < size; i++) {
					current = current.next;
				}
				current.next = addThis;
				addThis.prev = current;
				addThis.next = tail;
				tail.prev = addThis;
				size++;
			}
			else {
				throw new IndexOutOfBoundsException();
			}

		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
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
		LLNode<E> current = head;
		if (index >= 0 && index < size) {
			int i = 0;
			do {
				current = current.next;
			} while (i++ < index);
			(current.prev).next = current.next;
			(current.next).prev = current.prev;
			size--;
		}
		else
			throw new IndexOutOfBoundsException();
		return current.data;
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
		LLNode<E> changeThis = head;
		E temp = null;
		if (element == null) {
			throw new NullPointerException();
		}
		if (index >= 0 && index < size) {
			for (int i = 0; i <= index; i++) {
				changeThis = changeThis.next;
			}
			temp = changeThis.data;
			changeThis.data = element;
		}
		else
			throw new IndexOutOfBoundsException();
		return temp;
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
