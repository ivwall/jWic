package de.jwic.mobile05.demos;

import de.jwic.mobile05.MobileDemoModule;
import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

import de.jwic.controls.ScrollableContainer;

import de.jwic.controls.AnchorLinkControl;
import de.jwic.controls.actions.IAction;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EchoWindow extends MobileDemoModule implements PropertyChangeListener {
	
    protected transient Log log = LogFactory.getLog(getClass());
    
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

	
    
    public void actionPerformed(String actionId, String parameter) {
        //System.out.println("pinnacle Index.actionPerformed actionId("+
        //                             actionId+") parameter("+parameter+")");
        int x = Integer.parseInt(parameter);
        //nu.xom.Element guestData = (nu.xom.Element)guestList.getChild(x);
        //System.out.println(guest.getFirstChildElement("DataCenter").getValue());
        
        if (actionId.equals("click")) {
            /*****
            IndexAction action = 
                             (IndexAction)actionMap.get(new Integer(parameter));
            if (action != null) {
                if (action.isEnabled()) {
                    setCorrectIndexActive(action);
                    action.setActiveTrue();
                    PropertyChangeEvent pce = new PropertyChangeEvent(
                                        action,action.getTitle(),action,action);
                    // This should be moved below so guestInstallColumn 
                    // sits with guestInstallColumn
                    actionListener.propertyChange(pce);
                    ((PropertyChangeListener)
                                        guestInstallColumn).propertyChange(pce);
                    int guest_id = Integer.parseInt(action.getTitle());
                    
                    guestDetails.setGuestValues(guestData,guest_id);
                    
                    pce = new PropertyChangeEvent(action,"guest_index",action,action);
                    ((PropertyChangeListener)guestInstallColumn).propertyChange(pce);
                    
                } else {
                    log.warn("Action with the ID '" + parameter +
                            "' was clicked but is disabled");
                }
            } else {
                log.warn("Action with ID '" + parameter +
                        "' does not exist");
            }
            *****/
        }
    }
    
    
    //--------------------------------------------------------------------------
    public void propertyChange(PropertyChangeEvent event) {
         System.out.println("pinnacle.Index.propertyChange "+event.getPropertyName());
        if(event.getPropertyName().equals("sow_data_change")) {
            //System.out.println("pinnacle.Index.propertyChange .. sow_data_change .. event");
            //reset();
            //requireRedraw();
        } else {
            log.debug(" something not expected happned ..........");
        }
    }
	
	
	
}