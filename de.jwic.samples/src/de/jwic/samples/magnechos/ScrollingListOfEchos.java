package de.jwic.samples.magnechos;

import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.controls.Button;
import de.jwic.controls.InputBox;
import de.jwic.controls.LabelControl;
import de.jwic.controls.ListBoxControl;
import de.jwic.controls.RadioGroupControl;
import de.jwic.controls.ScrollableContainer;
import de.jwic.controls.layout.TableLayoutContainer;
import de.jwic.events.ElementSelectedEvent;
import de.jwic.events.ElementSelectedListener;
import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

public class ScrollingListOfEchos extends ControlContainer {
	
	private ScrollableContainer container;
	
	public ScrollingListOfEchos( IControlContainer container ) {
		this( container, null );
	}
	
	public ScrollingListOfEchos( IControlContainer parent, String name ) {
		super( parent, name );
		
		container = createDemoContent("group1");
		container.setWidth("300px");
		container.setHeight("150px");
		
	}
	
	private ScrollableContainer createDemoContent(String name) {
		
		ScrollableContainer group = new ScrollableContainer(this, name);
		group.setTemplateName(getClass().getName() + "_group");
		
		
		return group;
	}	
}