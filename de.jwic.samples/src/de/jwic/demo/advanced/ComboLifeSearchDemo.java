/*******************************************************************************
 * Copyright 2015 xWic group (http://www.xwic.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 *  
 *******************************************************************************/
package de.jwic.demo.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.controls.LabelControl;
import de.jwic.controls.combo.LifeSearchCombo;
import de.jwic.controls.combo.VisualSearchCombo;
import de.jwic.data.IBaseLabelProvider;
import de.jwic.data.DataLabel;
import de.jwic.events.ElementSelectedEvent;
import de.jwic.events.ElementSelectedListener;
import de.jwic.samples.controls.propeditor.PropertyEditorView;

/**
 *
 * @author lippisch
 */
public class ComboLifeSearchDemo extends ControlContainer {

	private List<PartObject> demoData = new ArrayList<PartObject>();
	private List<VisualSearchObject> vsData = new ArrayList<VisualSearchObject>();
	private LabelControl lbResult;
	
	/**
	 * @param container
	 * @param name
	 */
	public ComboLifeSearchDemo(IControlContainer container, String name) {
		super(container, name);
	
		createDemoData();
		createVisualSearchData();
		
		VisualSearchCombo<VisualSearchObject> visualSearchCombo = new VisualSearchCombo<VisualSearchObject>(this, "visualSearchCombo");
		visualSearchCombo.setWidth(400);
		visualSearchCombo.setContentProvider(new VisualSearchContentProvider(vsData));
		visualSearchCombo.setBaseLabelProvider(new IBaseLabelProvider<VisualSearchObject>() {
			private static final long serialVersionUID = 1L;

			public DataLabel getBaseLabel(VisualSearchObject object) {
				return new DataLabel(object.getValue());
			}
		});
		visualSearchCombo.getComboBehavior().setLabelProviderJSClass("Samples.PartObjectLabelProvider");
		visualSearchCombo.getComboBehavior().setTransferFullObject(true);
		
		LifeSearchCombo<PartObject> lsCombo = new LifeSearchCombo<PartObject>(this, "lsCombo");
		lsCombo.setContentProvider(new PartObjectContentProvider(demoData));
		lsCombo.setBaseLabelProvider(new IBaseLabelProvider<PartObject>() {
			public DataLabel getBaseLabel(PartObject object) {
				return new DataLabel(object.getTitle());
			}
		});
		lsCombo.setWidth(400);
		lsCombo.setAutoPickFirstHit(false); // disabled
		lsCombo.getComboBehavior().setLabelProviderJSClass("Samples.PartObjectLabelProvider");
		lsCombo.getComboBehavior().setTransferFullObject(true); // serialize the whole object
		lsCombo.addElementSelectedListener(new ElementSelectedListener() {
			public void elementSelected(ElementSelectedEvent event) {
				onElementSelected(event.getElement());
			}
		});
		
		lsCombo.setEmptyInfoText("Enter at least 3 characters of a part number or name");
		
		lbResult = new LabelControl(this, "lbResult");
		lbResult.setText("Pick a Part...");
		
		// create the property editor
		PropertyEditorView propEditor = new PropertyEditorView(this, "propEditor");
		propEditor.setBean(lsCombo);
		
	}

	/**
	 * @param element
	 */
	protected void onElementSelected(Object element) {
		
		lbResult.setText("Selected: " + element);
		
	}

	/**
	 * 
	 */
	private void createDemoData() {
		
		String[] color = {"Red", "Green", "Blue", "White", "Black" };
		String[] type = {"Book", "Wheel", "Chair", "Computer"};
		String[] extension = {"Light", "Premium", "Express", "Master" };
		
		Random rnd = new Random(0l);
		
		for (int i = 0; i < 10000; i++) {
			PartObject po = new PartObject();
			String name = color[rnd.nextInt(color.length)] + " " + type[rnd.nextInt(type.length)] + " X" + (i % 10) + "00 " + extension[rnd.nextInt(extension.length)];
			po.setName(name);
			po.setPartNumber(name.substring(0, 1) + "XX-" + i);
			demoData.add(po);
		}
		
	}
	
	/**
	 * 
	 */
	private void createVisualSearchData() {
		
		String[] color = {"Red", "Green", "Blue", "White", "Black" };
		String[] type = {"Book", "Wheel", "Chair", "Computer"};
		String[] extension = {"Light", "Premium", "Express", "Master" };
		
		Random rnd = new Random(0l);
		
		for (int i = 0; i < 5; i++) {
			VisualSearchObject po = new VisualSearchObject();
			String name = color[rnd.nextInt(color.length)] + " " + type[rnd.nextInt(type.length)] + " X" + (i % 10) + "00 " + extension[rnd.nextInt(extension.length)];
			po.setValue(name);
			po.setKey(name.substring(0, 1) + "XX-" + i);
			for (int j = 0; j < 1000; j++){
				VisualSearchObject poChild = new VisualSearchObject();
				String childName = color[rnd.nextInt(color.length)] + " " + type[rnd.nextInt(type.length)] + " X" + (i % 10) + "00 " + extension[rnd.nextInt(extension.length)];
				poChild.setValue(childName);
				poChild.setKey(childName.substring(0, 1) + "XX-" + i);
				po.addChild(poChild);
			}
			vsData.add(po);
		}
		
	}

}
