/*
 * Copyright 2005-2007 jWic group (http://www.jwic.de)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * de.jwic.ecolib.controls.stackpanel.StackPanelChangeListener
 * Created on 20.04.2007
 * $Id: StackPanelChangeListener.java,v 1.2 2007/04/20 08:39:33 lordsam Exp $
 */
package de.jwic.ecolib.controls.stackpanel;

import java.io.Serializable;

/**
 * 
 * @author Sebastian
 */
public interface StackPanelChangeListener extends Serializable
{
	/**
	 * Another stack panel was activated. The event contains the old
	 * and new id.
	 * @param evt
	 */
	public void stackPanelChanged(StackPanelChangeEvent evt);

}