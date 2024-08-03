/**
 * The <CODE>Component</CODE> Java class for Component data type.
 * It represents a electronic component, include the type e.g., resistor, capacitor, and 
 * its electrical property size.
 */

public class Component implements Comparable<Component> {
	
	//Invariant of the Component class:
	// 1. the electronic component type
	// 2. component electrical property size
	
	private String type; 
	private int size; 
	
	/**
	 * Constructor for [Component] object.
	 * @param type the type of component
	 * @param size the electrical property size
	 */
	public Component(String type, int size) {
		this.type = type;
		this.size = size;
	}
	
	/**
	 * Accessor method to get the type
	 * @return A String representing the type of electronic component 
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Accessor method to get the size 
	 * @return A integer representing the electrical property size
	 * 		
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * toString Override method
	 * @return A String representation of the component class
	 * 		where all the instance variables are in one
	 * 		line and separated by two tabs
	 */
	@Override
	public String toString() {
		String output = "";
		output += type;
		output += "\t";
		output += size;
		return output;
	}
	
	/**
	 * equals method
	 * @param c a Component instance to be compared
	 * @return true if both the type and size are the same
	 */
	public boolean equals(Component c) {
		return (this.type.equalsIgnoreCase(c.getType()) && this.size == c.getSize());
	}
	
	/**
	 * Override method of the compareTo method using type and size
	 * @param a Component instance to be compared
	 * @return an integer either 0, -1, or 1 based on whether the type
	 * 		is before or after alphabetical order and if it's the same type,
	 * 		the size is compared. 
	 * 
	 */
	@Override
	public int compareTo(Component c) {
		Component component = (Component) c;
		int result;
		if(this.equals(component)) {
			return 0;
		}
		result = this.getType().compareToIgnoreCase(component.getType());
		if(result == 0) {
			if(this.getSize() > component.getSize()) {
				return 1;
			}else {
				return -1;
			}
		}else if (result > 0) {
			return 1;
		}else {
			return -1;
		}
	}
}
