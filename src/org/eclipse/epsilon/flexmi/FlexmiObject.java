package org.eclipse.epsilon.flexmi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.eclipse.emf.ecore.ENamedElement;

public class FlexmiObject {
	
	protected FlexmiObject parent;
	protected List<FlexmiObject> children;
	protected Element element;
	protected int depth;		// To be used in future to map elements by depth.
	protected Map<ENamedElement, Integer> possible_matches;  
	protected boolean matched;  // True if the XML element has been matched to meta-model element. False otherwise.
	protected ENamedElement match; 	// The meta-model element that this object has been mapped to.
	protected int highest_similarity; 	// Stores an int of the highest similarity to an ENamedElement. 
	
	// Default Constructor
	public FlexmiObject(FlexmiObject parent, Element element, int depth) {
		this.parent = parent;
		this.children = new ArrayList<FlexmiObject>();
		
		this.element = element;
		this.depth = depth;
		
		this.possible_matches = new HashMap<ENamedElement, Integer>();
		this.matched = false;
		this.match = null;
	}
	
	// Constructor called when parent no parent exists
	public FlexmiObject(Element element, int depth) { 
		this(null, element, depth);
	}
	
	public void removeMatch(ENamedElement match) {
		this.possible_matches.remove(match);
		if(this.possible_matches.size() == 1) {
			this.matched = true;
			this.match = possible_matches.keySet().iterator().next();
			//this.possible_matches = null;
		} else {
			this.setHighestSimilarity();
		}
	}
	
	// To be run once possible matches are initiated and each time one is removed.
	public void setHighestSimilarity() {
		int highest = 0;
		for (Integer value : this.possible_matches.values()) {
			if(value > highest) {
				highest = value;
			}
		}
		this.highest_similarity = highest;
	}
	
	public String name(boolean removePrefix) {
		String name = this.element.getNodeName();
		
		if(removePrefix) {
			if (name.indexOf(":") > -1) {
				name = name.substring(name.indexOf(":")+1);
			}
		}
		return name;
	}
	
	public void addChild(FlexmiObject child) {
		this.children.add(child);
	}
}
