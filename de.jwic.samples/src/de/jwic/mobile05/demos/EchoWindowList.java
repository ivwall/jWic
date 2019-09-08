package de.jwic.mobile05.demos;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.Stack;

import de.jwic.controls.AnchorLinkControl;
import de.jwic.controls.actions.IAction;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EchoWindowList extends ControlContainer implements PropertyChangeListener {
	protected transient Log log = LogFactory.getLog(getClass());
	
	protected List actionOrder = new ArrayList();
	protected Map actionMap = new HashMap();

    protected ActionUpdateListener actionListener = null;
    
    private class ActionUpdateListener implements PropertyChangeListener {
        public void propertyChange(PropertyChangeEvent evt) {
            IndexAction a = (IndexAction)evt.getSource();
            requireRedraw();
        }
    }
	
	
	public EchoWindowList( IControlContainer container ) {
		super(container);
		
		for ( int x = 1; x < 20; x++ ) {
			addAction(new IndexAction( x ));
		}
		
	}
	
    public void addAction(IAction action) {
        Integer key = new Integer(action.getTitle());
        actionOrder.add(key);
        actionMap.put(key, action);
        action.addPropertyChangeListener(actionListener);
    }
	
    public List getActionKeys() {
        return actionOrder;
    }

    public IAction getActionByKey(Integer key) {
    	System.out.println("EchoWindowList.getActionByKey( "+key+" )");
        return (IAction)actionMap.get(key);
    }
	
    public void actionPerformed(String actionId, String parameter) {
        System.out.println("EchoWindowList actionPerformed actionId("+
                                     actionId+") parameter("+parameter+")");
    }
    
	public void propertyChange(PropertyChangeEvent evt) {
		IndexAction a = (IndexAction)evt.getSource();
		requireRedraw();
	}
    
}