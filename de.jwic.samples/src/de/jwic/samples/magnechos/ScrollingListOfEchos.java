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

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;


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
		
		
		System.out.println(">>>  pull list of mp3 ....  <<<");
		System.out.println(">>>  pull list from where ....  <<<");
		System.out.println(">>>  a json list ....  <<<");
		System.out.println(">>>  how to correlate list with user actions  <<<");
		System.out.println(">>>  .......................................  <<<");
		System.out.println(">>>  Make an HTTP GET request ????            <<<");
		System.out.println(">>>  to get the list to create the buttins    <<<");
		
		
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
		
		
		try {
		  String url = "http://localhost:8080/amp3s/amp3s-list2.json";
		  URL obj = new URL(url);
		  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		  int responseCode = con.getResponseCode();
		  System.out.println("\nSending 'GET' request to URL : " + url);
		  System.out.println("Response Code : " + responseCode);
		  BufferedReader in =new BufferedReader(
		  new InputStreamReader(con.getInputStream()));
		  String inputLine;
		  StringBuffer response = new StringBuffer();
		   while ((inputLine = in.readLine()) != null) {
			 response.append(inputLine);
		   } in .close();
		   //print in String
		    System.out.println(response.toString());
		   JSONObject myresponse = new JSONObject(response.toString());
		   
		   
			JSONArray arr = myresponse.getJSONArray("echo-list");
			
			
			//AudioButton[] arrayOButtons = new AudioButton(tlc)[arr.length()];
			AudioButton[] arrayOButtons = new AudioButton[arr.length()];
			
			
			
			for (int i = 0; i < arr.length(); i++) {
				System.out.println(" " + arr.get(i));
				arrayOButtons[i] = new AudioButton(tlc);
				arrayOButtons[i].setTitle(""+arr.get(i));
				arrayOButtons[i].setAudioLink("http://localhost:8080/amp3s/"+arr.get(i));
				
			}		   
		   
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return group;
	}
	
	public void reset() {}
	public void destory() {}
}