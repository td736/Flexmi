package org.eclipse.epsilon.flexmi;

import java.util.ArrayList;
import java.util.List;

public class FlexmiObject {
	
	protected FlexmiObject parent;
	protected List<FlexmiObject> children;
	protected Object type;
	protected int depth;		// To be used in future to map elements by depth.
	protected List<Object> possible_matches;  //@TODO Change type
	protected boolean matched;  // True if the XML element has been matched to meta-model element. False otherwise.
	protected Object match; 	// The meta-model element that this object has been mapped to.
	
	// Default Constructor
	public FlexmiObject(FlexmiObject parent, int depth) {
		this.parent = parent;
		this.children = new ArrayList<FlexmiObject>();
		
		this.type = null;
		this.depth = depth;
		
		this.possible_matches = new ArrayList<Object>();
		this.matched = false;
		this.match = null;
	}
	
	// Constructor called when parent no parent exists
	public FlexmiObject(int depth) { 
		this(null, depth);
	}

}
