package de.jwic.samples.magnechos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

import de.jwic.controls.ScrollableContainer;

public class EchoController extends ControlContainer {
	
	public EchoController( IControlContainer container ) {
		super(container);
		this.setTemplateName("EchoController");
		ScrollingListOfEchos listOfEchos = new ScrollingListOfEchos(this,"contentContainer");
	}
	
	public void reset() {}
	
}