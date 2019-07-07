package de.jwic.samples.magnechos;

import de.jwic.base.Application;
import de.jwic.base.Control;
import de.jwic.base.IControlContainer;
import de.jwic.base.Page;
import de.jwic.base.SessionContext;

public class MagnEchos extends Application {
	
	public Control createRootControl(IControlContainer container) {
		Page page = new Page(container);
		page.setTitle("MagnEchos");
		return page;
	}
	
}