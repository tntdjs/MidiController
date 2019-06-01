package com.tntdjs.midi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MidiControllerDef
 * @author tsenauskas
 */
@Service
public class MidiControllerDef implements IMidiControllerDef {

	private String midiControllerPath;
	private String midiControllerName;
	
	private int appHeight;
	private int appWidth;

	private String xmlConfiguration;
	
	/* (non-Javadoc)
	 * @see com.tntdjs.midi.IMidiControllerDef#getMidiControllerPath()
	 */
	@Override
	public String getMidiControllerPath() {
		return midiControllerPath;
	}

	/* (non-Javadoc)
	 * @see com.tntdjs.midi.IMidiControllerDef#setMidiControllerPath(java.lang.String)
	 */
	@Override
	@Autowired
	public void setMidiControllerPath(String midiControllerPath) {
		this.midiControllerPath = midiControllerPath;
	}

	/* (non-Javadoc)
	 * @see com.tntdjs.midi.IMidiControllerDef#getMidiControllerName()
	 */
	@Override
	public String getMidiControllerName() {
		return midiControllerName;
	}
	
	/* (non-Javadoc)
	 * @see com.tntdjs.midi.IMidiControllerDef#setMidiControllerName(java.lang.String)
	 */
	@Override
	@Autowired
	public void setMidiControllerName(String midiControllerName) {
		this.midiControllerName = midiControllerName;
	}

	/*
	 * (non-Javadoc)
	 * @see com.tntdjs.midi.controllers.IMidiControllerDef#getAppHeight()
	 */
	@Override
	public int getAppHeight() {
		return appHeight;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.tntdjs.midi.controllers.IMidiControllerDef#getAppWidth()
	 */
	@Override
	public int getAppWidth() {
		return this.appWidth;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.tntdjs.midi.controllers.IMidiControllerDef#setAppWidth(int)
	 */
	@Override
	@Autowired
	public void setAppWidth(int appwidth) {
		this.appWidth = appwidth;
	}

	/*
	 * (non-Javadoc)
	 * @see com.tntdjs.midi.controllers.IMidiControllerDef#setAppHeight(int)
	 */
	@Override
	@Autowired
	public void setAppHeight(int appheight) {
		this.appHeight = appheight;
	}

	@Override
	public String getXmlConfiguration() {
		return xmlConfiguration;
	}

	@Override
	public void setXmlConfiguration(String argXMLConfiguration) {
		xmlConfiguration = argXMLConfiguration;
		
	}

}
