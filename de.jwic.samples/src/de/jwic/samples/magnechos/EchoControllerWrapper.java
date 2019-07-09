package de.jwic.samples.magnechos;

import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

public class EchoControllerWrapper implements IEchoController {

	private EchoController echoController;
	
	public EchoControllerWrapper () { }
	
	public void init ( IControlContainer container, String name ) {
		echoController = new EchoController( container );
	}
	
	public void reset() { echoController.reset(); }
	
	public void destroy() { echoController.destroy(); }
	
	public void setName() { }
	
	public ControlContainer getControlContainer() { return echoController; }
	
}