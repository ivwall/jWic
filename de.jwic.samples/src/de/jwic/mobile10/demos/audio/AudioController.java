package de.jwic.mobile10.demos.audio;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
//import de.jwic.controls.mobile04.MSelectmenu;
import de.jwic.data.ISelectElement;
//import de.jwic.mobile10.MobileDemoModule;

public class AudioController extends ControlContainer {
	
	private ControlContainer container;
	private PlayPause playPause;
	
	/**
	 * Constructor.
	 * @param parent
	 */
	public AudioController (IControlContainer parent) {
		super(parent);
		internalInit();
	}
	
	/**
	 * Initialize the control itself.
	 */
	private void internalInit() {
		this.container = new ControlContainer(this, "content");
	}

}