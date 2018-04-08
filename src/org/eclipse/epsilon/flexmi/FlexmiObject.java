package org.eclipse.epsilon.flexmi;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;


public class FlexmiObject {
	
	protected FlexmiObject parent;
	protected List<FlexmiObject> children;
	protected Element element;
	protected int depth;		// To be used in future to map elements by depth.
	protected List<Object> possible_matches;  //@TODO Change type
	protected boolean matched;  // True if the XML element has been matched to meta-model element. False otherwise.
	protected Object match; 	// The meta-model element that this object has been mapped to.
	
	// Default Constructor
	public FlexmiObject(FlexmiObject parent, Element element, int depth) {
		this.parent = parent;
		this.children = new ArrayList<FlexmiObject>();
		
		this.element = element;
		this.depth = depth;
		
		this.possible_matches = new ArrayList<Object>();
		this.matched = false;
		this.match = null;
	}
	
	// Constructor called when parent no parent exists
	public FlexmiObject(Element element, int depth) { 
		this(null, element, depth);
	}
}
