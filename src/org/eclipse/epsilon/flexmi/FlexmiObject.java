package org.eclipse.epsilon.flexmi;

import java.util.ArrayList;
import java.util.List;

public class FlexmiObject {
	
	protected FlexmiObject parent;
	protected List<FlexmiObject> children = new ArrayList<FlexmiObject>();
	protected Object type;
	protected int depth;		// To be used in future to map elements by depth.
	protected List<Object> possible_matches = new ArrayList<Object>();  //@TODO Change type
	protected boolean matched;  // True if the XML element has been matched to meta-model element. False otherwise.
	protected Object match; 	// The meta-model element that this object has been mapped to.
	
	

}
