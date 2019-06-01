package com.tntdjs.midi.controllers;

/**
 * IMidiControllerDef
 * @author tsenausk
 *
 */
public interface IMidiControllerDef {

	String getMidiControllerPath();

	void setMidiControllerPath(String midiControllerPath);

	String getMidiControllerName();

	void setMidiControllerName(String midiControllerName);

	int getAppHeight();
	
	void setAppHeight(int appheight);
	
	int getAppWidth();

	void setAppWidth(int appwidth);
	
	String getXmlConfiguration();
	
	void setXmlConfiguration(String argXMLConfiguration);
	
}