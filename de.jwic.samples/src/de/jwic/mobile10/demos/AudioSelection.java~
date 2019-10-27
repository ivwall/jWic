package de.jwic.mobile10.demos;

import de.jwic.events.SelectionListener;
import de.jwic.events.SelectionEvent;
import de.jwic.controls.mobile04.MButton;
import de.jwic.controls.mobile08.MCheckBox;

import de.jwic.mobile10.demos.audio.Player;
import de.jwic.mobile10.demos.audio.AudioController;

public class AudioSelection implements SelectionListener {
	private String    audioTitle = "not set";
	private EchoLabel echoLabel = null;
	private MCheckBox ckBoxAsLbl = null;
	private Player    player = null;
	private AudioController audioCtl = null;
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
	public AudioSelection(String t, EchoLabel lbl, MCheckBox ckbx, Player p){
		audioTitle = t;
		echoLabel = lbl;
		ckBoxAsLbl = ckbx;
		player = p;
	}
	public AudioSelection(String t, EchoLabel lbl, MCheckBox ckbx, AudioController ac){
		audioTitle = t;
		echoLabel = lbl;
		ckBoxAsLbl = ckbx;
		audioCtl = ac;
	}
	public void objectSelected(SelectionEvent event){
		System.out.println("objectSelected = "+audioTitle);
		try {
			ckBoxAsLbl.setLabel(audioTitle);
		} catch( Exception ex) {
			System.out.println("AudioSelection.objectSelected "+ex.toString());
		}
		try {
			//player.setAudio(audioTitle);
			//player.requireRedraw();
			audioCtl.setAudio(audioTitle);
			audioCtl.requireRedraw();
		} catch( Exception x2 ) {
			System.out.println("AudioSelection.objectSelected "+x2.toString());
		}
	}
	public void setTitle(String t){
		audioTitle = t;
	}
}