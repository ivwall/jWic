package de.jwic.mobile05.demos;

import de.jwic.mobile05.MobileDemoModule;
import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

import de.jwic.controls.ScrollableContainer;

public class EchoWindow extends MobileDemoModule {
	
	public EchoWindow() {
		super("Echo Window");
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer);
		
		ScrollableContainer sc = new ScrollableContainer(container);
		sc.setHeight("250px");
		sc.setWidth("250px");
		
		EchoWindowList ewList = new EchoWindowList(sc);
		
		return container;
	}

	
}