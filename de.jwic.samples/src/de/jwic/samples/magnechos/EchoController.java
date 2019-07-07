package de.jwic.samples.magnechos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

import de.jwic.controls.ScrollableContainer;

public class EchoController extends ControlContainer {
//public class EchoController implements IEchoController extends ControlContainer {
	
	public EchoController( IControlContainer container ) {
		super(container);
		this.setTemplateName("MagnEchos");
		
		ScrollableContainer echoContainer =
		                    new ScrollableContainer(this, "contentContainer");
		echoContainer.setHeight("1000px");
		echoContainer.setWidth("675pz");	
	}
	
	public void reset() {}
	
	
}