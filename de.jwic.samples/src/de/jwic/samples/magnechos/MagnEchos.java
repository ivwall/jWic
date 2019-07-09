package de.jwic.samples.magnechos;

import de.jwic.base.Application;
import de.jwic.base.Control;
import de.jwic.base.IControlContainer;
import de.jwic.base.Page;
import de.jwic.base.SessionContext;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class MagnEchos extends Application {
	
	public String echoWrapperClassName = 
	                          "de.jwic.samples.magnechos.EchoControllerWrapper";
	
	public Control createRootControl(IControlContainer container) {
		Page page = new Page(container);
		page.setTitle("MagnEchos");
		
		SessionContext sc = this.getSessionContext();
		HashMap initParams = (HashMap)sc.getInitParameters();
		Set keys = initParams.keySet();
		System.out.println("-----.  session context key count "+keys.size());
		for ( Iterator i = keys.iterator(); i.hasNext(); ) {
			String key = (String)i.next();
			String[] kValue = (String[])initParams.get(key);
			System.out.println(" key("+key+") name[0]"+kValue[0]);
		}
		
		Echo_Control_Factory echoFactory = new Echo_Control_Factory();
		
		IEchoController echoController = 
		                  echoFactory.getEchoController( echoWrapperClassName );
		
		echoController.init( page, "echoController");
		
		return page;
	}
	
}