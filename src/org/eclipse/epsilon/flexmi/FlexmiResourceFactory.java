package org.eclipse.epsilon.flexmi;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

import org.eclipse.epsilon.flexmi.FlexmiResource;

public class FlexmiResourceFactory extends ResourceFactoryImpl {
	
	@Override
	public Resource createResource(URI uri) {
		return new FlexmiResource(uri);
	}
	
}