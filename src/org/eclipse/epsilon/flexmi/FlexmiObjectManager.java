package org.eclipse.epsilon.flexmi;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.flexmi.FlexmiObject;

public class FlexmiObjectManager {
	
	protected List<FlexmiObject> objects;
	
	public FlexmiObjectManager() {
		this.objects = new ArrayList<FlexmiObject>();
	}
	
	public void addObject(FlexmiObject object) {
		this.objects.add(object);
	}
}
	