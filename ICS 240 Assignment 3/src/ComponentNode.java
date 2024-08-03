/**
 * The <CODE>ComponentNode</CODE> Java class represents a node class in the linked list.
 */

public class ComponentNode {
	//	Invariant of the ComponentNode class:
	//	1. the node's component reference variable
	//	2. for the final node of a list, the link part is null.
	//	otherwise, the link part is a reference to the next node of the list.
	private Component data;
	private ComponentNode link;
	
	
	/**
	 * Initialize a node with a specified initial Component and link to the next
	 * node. The initialLink may be a null reference.
	 * @param initialData - the initial data of this new node.
	 * @param initialLink - a reference to the node after this new node.
	 * 
	 */
	public ComponentNode(Component initialData, ComponentNode initialLink) {
		data = initialData;
		link = initialLink;
	}
	
	/**
	 * Accessor method to get the Component from this node.
	 * @return - the Component from this node.
	 */
	public Component getData() {
		return data;
	}
	
	/**
	 * Accessor method t o get a reference to the next node after this node.
	 * @return - a reference to the node after this node or a null reference if there is
	 * 	nothing after this node.
	 */
	public ComponentNode getLink() {
		return link;
	}
	
	/**
	 * Modification method to set the data in this node.
	 * @param newComponent - the new Component to place in this node.
	 * @postcondition - the Component of this node has been set to newComponent.
	 */
	public void setData(Component newComponent) {
		data = newComponent;
	}
	
	/**
	 * Modification method to set the link to the next node after this node.
	 * @param newLink - a reference to the node that should appear after this node in the linked
	 * list or a null reference if there is no node after this node.
	 * @postcondition - The link to the node after this node has been set to newLink and
	 * any other node is no longer connected to this node.
	 */
	public void setLink(ComponentNode newLink) {
		link = newLink;
	}
	
	/**
	 * Modification method to add a new node after this node.
	 * @param item - the Component to place in the new node.
	 * @postcondition - A new node has been created and placed after this node.
	 * The component for the new node is item. Any other modes that used to be after this 
	 * node is are new  after this new node.
	 * @exception OutOfMemoryError - Indicates that there is insufficient memory for a new 
	 * ComponenentNode. 
	 */
	public void addNodeAfter(Component item) {
		link = new ComponentNode(item, link);
	}
	
	/**
	 * Modification method to remove the node after this node.
	 * @precondition - this node must not be the tail node of the list.
	 * @postcondition - the node after this node has been removed from the linked list.
	 * @exception NullPointerException - indicates that this was the tail node of the list.
	 * 
	 */
	public void removeNodeAfter() {
		link = link.link;
	}
	
	/**
	 * Accessor method to display the contents of the linked list.
	 * @param list - the linked list to display.
	 */
	public static void display(ComponentNode list) {
		ComponentNode cursor = list;
		while(cursor != null) {
			System.out.println(cursor.data);
			cursor = cursor.getLink();
		}
		
		System.out.println();
	}
	
	/**
	 * Find a node at a specific position in a linked list.
	 * @param head - the head reference for a linked list
	 * @param position - a node number
	 * @return - The return value is a reference to the node at the specified position in 
	 * 	the list. The head node is position 1, the next node is position 2...
	 * @exception IllegalArgumentExcpetion - indicates that position is not positive.
	 */
	public static ComponentNode listPosition(ComponentNode head, int position) {
		ComponentNode cursor;
		int i;
		if(position <= 0) {
			throw new IllegalArgumentException("position is not positive");
		}
		cursor = head;
		for(i = 1; (i < position) && (cursor != null); i++) {
			cursor = cursor.link;
		}
		return cursor;
	}
	
	/**
	 * Compute the number of nodes in a linked list.
	 * @param head - the head reference for a linked list
	 * @return - the number of nodes in the list with the given head.
	 */
	public static int listLength(ComponentNode head) {
		ComponentNode cursor;
		int answer = 0;
		for(cursor = head; cursor != null; cursor = cursor.link) {
			answer++;
		}
		return answer;
	}
	
	/**
	 * Search for a particular Component in a linked list.
	 * @param head - the head reference for a linked list.
	 * @param target - a Component to search for in the linked list.
	 * @return - the return value is a reference to the first node that contains the 
	 * 	specified target. If there is no such node, the null reference is returned.
	 */
	public static ComponentNode listSearch(ComponentNode head, Component target) {
		ComponentNode cursor;
		for(cursor = head; cursor != null; cursor = cursor.link) {
			if(target == cursor.data) {
				return cursor;
			}
		}
		return null;
	}
	
}
