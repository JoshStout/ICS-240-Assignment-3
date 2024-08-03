/**
 * The <CODE>ComponentLinkedBagDriver</CODE> Java class is used to test all
 * the methods in the ComponentNode class and the ComponentLinkedBag class.
 */

import java.util.Iterator;

public class ComponentLinkedBagDriver {

	public static void main(String[] args) {
		
		System.out.println("Creating objects of the Component class");
		Component c1 = new Component("resistor", 1000);
		Component c2 = new Component("capacitor", 100);
		Component c3 = new Component("inductor", 30);
		Component c4 = new Component("resistor", 2000);
		Component c5 = new Component("capacitor", 200);
		Component c6 = new Component("inductor", 50);
		Component c7 = new Component("resistor", 3000);
		Component c8 = new Component("resistor", 4000);
		Component c9 = new Component("resistor", 5000);
		
		System.out.println("Testing ComponentNode class");
		System.out.println();
		
		System.out.println("Creating ComponentNode Linked List");
		ComponentNode node = new ComponentNode(null, null);
		node.setData(c1);
		node.addNodeAfter(c2);
		node.addNodeAfter(c3);
		node.addNodeAfter(c4);
		node.addNodeAfter(c5);
		node.addNodeAfter(c6);
		node.addNodeAfter(c7);
		node.addNodeAfter(c8);
		System.out.println("display() ");
		ComponentNode.display(node);
		
		System.out.println("removeNodeAfter()");
		node.removeNodeAfter();
		ComponentNode.display(node);
		
		int pos = 3;
		System.out.println("Testing listPosition(Component Linked List, " + pos + ")");
		ComponentNode n = ComponentNode.listPosition(node, pos);
		System.out.println(n.getData());
		System.out.println();
		
		System.out.println("Testing listLength");
		int length = ComponentNode.listLength(node);
		System.out.println("Component Linked List listLength = " + length);
		System.out.println();
		
		System.out.println("Testing listSearch");
		Component target;
		target = c5;
		System.out.println("c5.toString(): " + c5.toString());
		System.out.println("listSearch(node, c5)");
		ComponentNode nodeCursor;
		nodeCursor = ComponentNode.listSearch(node, target);
		ComponentNode.display(nodeCursor);
		System.out.println();
		
		
		System.out.println("Testing ComponentLinkedBag class");
		System.out.println();
		
		System.out.println("Adding Components to Linked List Bag");
		ComponentLinkedBag bag = new ComponentLinkedBag();
		
		bag.add(c1);
		bag.add(c2);
		bag.add(c3);
		bag.add(c4);
		bag.add(c5);
		bag.add(c6);
		bag.add(c7);
		
		bag.display();
		System.out.println("bag.size() = " + bag.size());
		System.out.println();
		
		System.out.println("Testing ComponentLinkedBag add by position method");
		int bagPosition = 3;
		
		System.out.print("adding to position " + bagPosition);
		System.out.println(": " + c8);
		bag.add(3, c8);
		bag.display();
		System.out.println("bag.size() = " + bag.size());
		System.out.println();
		
		System.out.println("Testing ComponentLinkedBag addLast method");
		bag.addLast(c9);
		bag.display();
		System.out.println("bag.size() = " + bag.size());
		System.out.println();
		
		System.out.println("Testing ComponentLinkedBag remove specific element method");
		Component removeElement = c7;
		System.out.println("remove element c3 = " + removeElement.toString());
		bag.remove(removeElement);
		bag.display();
		System.out.println("bag.size() = " + bag.size());
		System.out.println();
		
		System.out.println("Testing ComponentLinkedBag remove by position method");
		int removePosition = 3;
		System.out.println("remove element at position " + removePosition);
		bag.remove(3);
		bag.display();
		System.out.println("bag.size() = " + bag.size());
		System.out.println();
		
		System.out.println("Testing ComponentLinkedBag removeLast method");
		bag.removeLast();
		bag.display();
		System.out.println("bag.size() = " + bag.size());
		System.out.println();
		
		System.out.println("Testing ComponentLinkedBag countRange method");
		Component start = new Component("capacitor" , 200);
		Component end = new Component("resistor", 2000);
		System.out.println("start range = " + start);
		System.out.println("end range = " + end);
		int range = bag.countRange(start, end);
		System.out.println("range = " + range);
		bag.display();
		System.out.println("bag.size() = " + bag.size());
		System.out.println();
		
		System.out.println("Testing ComponentLinkedBag set method");
		Component element = new Component("inductor" , 10);
		System.out.println("New Component = " + element.toString());
		int position = 3;
		System.out.println("Replace element at position "+ position);
		bag.set(position, element);
		bag.display();
		System.out.println("bag.size() = " + bag.size());
		System.out.println();
		
		System.out.println("Testing total method");
		System.out.println("total() = " + bag.total());
		System.out.println();
		
		System.out.println("Testing lessThan method");
		Component element2 = new Component("inductor", 30);
		System.out.println("input element: " + element2.toString());
		ComponentNode list = bag.lessThan(element2);
		Component c;
		int count = 0;
		System.out.println("Components that are less than or equal to input element: ");
		while(list != null) {
			c = list.getData();
			System.out.println(c.toString());
			list = list.getLink();
			count++;
		}
		System.out.println("lessThan = " + count);
		System.out.println();
		
		System.out.println("Testing max method");
		Component max = bag.max();
		System.out.println("max() = " + max.toString());
		System.out.println();
		
		System.out.println("Testing Iterator()");
		Iterator<Component> itr = bag.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		System.out.println("Testing enhanced for loop");
		for(Component i : bag) {
			System.out.println(i);
		}
	}
}
