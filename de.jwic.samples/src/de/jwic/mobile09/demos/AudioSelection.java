package de.jwic.mobile09.demos;

import de.jwic.events.SelectionListener;
import de.jwic.events.SelectionEvent;
import de.jwic.controls.mobile04.MButton;
import de.jwic.controls.mobile08.MCheckBox;

public class AudioSelection implements SelectionListener {
	private String    audioTitle = "not set";
	private EchoLabel echoLabel = null;
	private MCheckBox ckBoxAsLbl = null;
	public AudioSelection(){
	}
	public AudioSelection(String t){
		audioTitle = t;
	}
	public AudioSelection(String t, EchoLabel lbl){
		audioTitle = t;
		echoLabel = lbl;
	}
	public AudioSelection(String t, EchoLabel lbl, MCheckBox ckbx){
		audioTitle = t;
		echoLabel = lbl;
		ckBoxAsLbl = ckbx;
	}
	public void objectSelected(SelectionEvent event){
		System.out.println("objectSelected = "+audioTitle);
		try {
			ckBoxAsLbl.setLabel(audioTitle);
		} catch( Exception ex) {
			System.out.println("AudioSelection.objectSelected "+ex.toString());
		}
	}
	public void setTitle(String t){
		audioTitle = t;
	}
}