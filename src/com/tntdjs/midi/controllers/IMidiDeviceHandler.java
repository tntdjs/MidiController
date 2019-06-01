package com.tntdjs.midi.controllers;

import com.tntdjs.midi.IReceiver;

/**
 * IMidiDeviceHandler
 * @author tsenausk
 *
 */
public interface IMidiDeviceHandler {	
	public void deInitMidi();

	public void initMidi();

	public boolean isInitialized();

	public void configure();
	
	public IReceiver getMidiInputReceiver();
	
	public void setDeviceName(String deviceName);
	
	public String getDeviceName();

}