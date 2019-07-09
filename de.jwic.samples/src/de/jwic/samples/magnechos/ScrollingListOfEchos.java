package de.jwic.samples.magnechos;

import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.controls.Button;
import de.jwic.controls.InputBox;
import de.jwic.controls.LabelControl;
import de.jwic.controls.ListBoxControl;
import de.jwic.controls.RadioGroupControl;
import de.jwic.controls.ScrollableContainer;
import de.jwic.controls.layout.TableLayoutContainer;
import de.jwic.events.ElementSelectedEvent;
import de.jwic.events.ElementSelectedListener;
import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

public class ScrollingListOfEchos extends ControlContainer {
	
	private ScrollableContainer container;
	
	public ScrollingListOfEchos( IControlContainer container ) {
		this( container, null );
	}
	
	public ScrollingListOfEchos( IControlContainer parent, String name ) {
		super( parent, name );
		
		container = createDemoContent("group1");
		container.setWidth("300px");
		container.setHeight("150px");
		
	}
	
	private ScrollableContainer createDemoContent(String name) {
		
		ScrollableContainer group = new ScrollableContainer(this, name);
		group.setTemplateName(getClass().getName() + "_group");
		
		TableLayoutContainer tlc = new TableLayoutContainer(group, "table");
		tlc.setColumnCount(1);
		
		
		String audio_title = "1987-edification";
		String audio_speaker = "Ray Mellilow";
		AudioButton aButton01 = new AudioButton(tlc);
		aButton01.setTitle(audio_speaker+" : "+audio_title);
		aButton01.setAudioLink("http://localhost:8080/amp3s/"+audio_title+".mp3");
		aButton01.requireRedraw();
		
		audio_title = "jc-gooch-side-1";
		audio_speaker = "John Crowe";
		AudioButton aButton02 = new AudioButton(tlc);
		aButton02.setTitle(audio_speaker+" : "+audio_title);
		aButton02.setAudioLink("http://localhost:8080/amp3s/"+audio_title+".mp3");
		aButton02.requireRedraw();
		
		audio_title = "jc-gooch-side-2";
		audio_speaker = "John Crowe";
		AudioButton aButton03 = new AudioButton(tlc);
		aButton03.setTitle(audio_speaker+" : "+audio_title);
		aButton03.setAudioLink("http://localhost:8080/amp3s/"+audio_title+".mp3");
		aButton03.requireRedraw();
		
		return group;
	}	
}