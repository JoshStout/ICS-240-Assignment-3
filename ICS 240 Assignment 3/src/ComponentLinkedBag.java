/**
 * The <CODE>ComponentLinkedBag</CODE> Java class is used to manage a collection of
 * Component objects where the things are stored in a linked list.
 */

import java.util.Iterator;

public class ComponentLinkedBag implements Iterable<Component> {
	//	Invariant of the ComponentLinkedBag class:
	// 	1. The elements in the bag are stored on a linked list.
	//	2. The head reference of the list is in the instance variable head.
	//	3. The total number of elements in the list is in the instance variable manyNodes.
	private ComponentNode head;
	private int manyNodes;
	
	
	/**
	 * Initialized an empty bag.
	 * @postcondition - this bag is empty.
	 */
	public ComponentLinkedBag() {
		head = null;
		manyNodes = 0;
	}
	
	/**
	 * Determine the number of elements in this bag.
	 * @return - the number of elements in this bag.
	 */
	public int size() {
		return manyNodes;
	}
	
	/**
	 * Displays the contents of the collections such that each element
	 * is displayed on one line. The method displays the list on screen and 
	 * does not return a String representation of the list.
	 */
	public void display() {
		ComponentNode cursor = head;
		if(manyNodes == 0) {
			throw new IllegalStateException("Bag size is zero");
		}
		while(cursor != null) {
			System.out.println(cursor.getData());
			cursor = cursor.getLink();
		}
	}
	
	/**
	 * Add a new element to this bag.
	 * @param element - the new element that is being added
	 * @postcondition - a new copy of the element has been added to this bag.
	 * @exception OutOfMemoryError - indicates insufficient memory for a new ComponentNode.
	 */
	public void add(Component element) {
		head = new ComponentNode(element, head);
		manyNodes++;
	}
	
	/**
	 * A method to add an element at a specific position in the collection.
	 * If the position is greater than the collection length, then the 
	 * element is added as the last element in the collection. The method
	 * does not do anything if position is negative.
	 * @param position - the position to add the element.
	 * @param element - the Component to be added to the collection. 
	 * @postcondition - add an element at the specific position. The
	 * 	method does not do anything if position is negative.
	 *
	 */
	public void add(int position, Component element) {
		ComponentNode cursor;
		cursor = head;
		int count = 1;
		if(position < 0 || position > manyNodes) {
			return;
		}
		while(cursor != null) {	
			if(count == position - 1) {
				cursor.addNodeAfter(element);
				manyNodes++;
				return;
			}else {
				cursor = cursor.getLink();
				count++;
			}
		}
	}
	
	/**
	 * Add an element in the last position of the linked list.
	 * @param element - the Component to be added to the last position.
	 */
	public void addLast(Component element) {
		ComponentNode cursor;
		cursor = head;
		while(cursor.getLink() != null) {
			cursor = cursor.getLink();
		}
		cursor.addNodeAfter(element);
		manyNodes++;
	}
	
	/**
	 * Remove one copy of a specified element from this bag.
	 * @param target - the element to remove from the bag.
	 * @return - if target was found in the bag, then one copy of target
	 * 	has been removed and the method returns true, otherwise the bag
	 * 	remains unchanged and the method returns false.
	 */
	boolean remove(Component target) {
		ComponentNode targetNode; // the node that contains the target
		targetNode = ComponentNode.listSearch(head, target);
		if(targetNode == null) {
			//the target was not found, so nothing is removed.
			return false;
		}else {
			//the target was found at targetNode, so copy the head data to targetNode 
			//and then remove the extra copy of the head data.
			targetNode.setData(head.getData());
			head = head.getLink();
			manyNodes--;
			return true;
		}
	}
	
	/**
	 * Removes the element at the location specified by position.
	 * @param position - the position to remove the element.
	 * @return - true if an item is removed or false if no element is removed
	 * 	because position is negative or beyond the list length.
	 */
	boolean remove(int position) {
		if(position < 0 || position > manyNodes) {
			return false;
		}
		ComponentNode cursor;
		cursor = head;
		int count = 1;
		while(count < position - 1) {
			cursor = cursor.getLink();
			count++;
		}
		cursor.removeNodeAfter();
		manyNodes--;
		return true;
	}
	
	/**
	 * Method removes the last node in the linked list.
	 */
	public void removeLast() {
		ComponentNode cursor = head;
		while(cursor.getLink().getLink() != null) {
			cursor = cursor.getLink();
		}
		cursor.removeNodeAfter();
		manyNodes--;
	}
	
	/**
	 * Method counts and returns how many element in the collection falls in the range
	 * between start and end. The element are compared using the compareTo method.
	 * @param start - the first element in the range.
	 * @param end - the last element in the range.
	 * @return - how many elements in the collection between start and end.
	 */
	int countRange(Component start, Component end) {
		ComponentNode cursor = head;
		int count = 0;
		while(cursor != null) {
			if(cursor.getData().compareTo(start) > -1 && cursor.getData().compareTo(end) < 1) {
				count++;
			}
			cursor = cursor.getLink();
		}
		return count;
	}
	
	/**
	 * Replaces the element at position position with the input element.
	 * If position is negative or beyond the length of the list, then 
	 * the method does not do anything.
	 * @param position - position to replace the element.
	 * @param element - the element to replace the current element.
	 * @postcondition - replaces element or does nothing if position
	 * 	is negative or beyond the length of the list.
	 */
	public void set(int position, Component element) {
		if(position < 0 || position > manyNodes) {
			return;
		}
		ComponentNode cursor = head;
		int count = 1;
		while(cursor != null) {
			if(count == position -1) {
				cursor.addNodeAfter(element);
				cursor.getLink().removeNodeAfter();
				return;
			}else {
				cursor = cursor.getLink();
				count++;
			}
		}
		
	}
	
	/**
	 * Method returns the sum of all the integer values of all Components
	 * in the list.
	 * @return - the total of all integer values of all Components in the list.
	 */
	public int total() {
		ComponentNode cursor = head;
		int sum = 0;
		Component c;
		while(cursor != null) {
			c = cursor.getData();
			sum += c.getSize();
			cursor = cursor.getLink();
		}
		return sum;
	}
	
	/**
	 * Method takes one Component as input and returns an output a linked list that 
	 * includes all element that are less than or equal to the input element.
	 * Components are ordered based on the compareTo method.
	 * @param element - the to be compared to.
	 * @return
	 */
	public ComponentNode lessThan(Component element) {
		ComponentNode cursor = head;
		Component c;
		int count = 0;
		ComponentNode list = new ComponentNode(null, null);
		while(cursor != null) {
			c = cursor.getData();
			if(c.compareTo(element) < 1) {
				count++;
				if(count == 1) {
					list.setData(c);
				}else {
					list.addNodeAfter(c);
				}
			}
			cursor = cursor.getLink();
		}
		return list;
		
		
	}
	
	/**
	 * Method returns the maximum Component in the linked list where things are ordered
	 * based on the compareTo method.
	 * @return
	 */
	public Component max() {
		ComponentNode cursor = head;
		Component c, max;
		max = cursor.getData();
		while(cursor != null) {
			c = cursor.getData();
			if(c.compareTo(max) > 0) {
				max = cursor.getData();
			}
			cursor = cursor.getLink();
		}
		return max;
	}
	
	@Override
	public Iterator<Component> iterator() {
		return new ComponentLinkedBagIterator();
	}
	
	
	public class ComponentLinkedBagIterator implements Iterator<Component>{
		ComponentNode current = head;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public Component next() {
			if(hasNext()) {
				Component data = current.getData();
				current = current.getLink();
				return data;
			}
			return null;
		}
		
	}
}
