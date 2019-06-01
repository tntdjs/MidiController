package com.tntdjs.midi.controllers.data.config;

import java.util.List;

import com.tntdjs.midi.controllers.data.config.objects.ButtonSet;
import com.tntdjs.midi.controllers.data.config.objects.MidiButton;
import com.tntdjs.midi.controllers.data.config.objects.MidiDevices.Device;
import com.tntdjs.midi.controllers.data.config.objects.MidiDevices.Device.ButtonGroups;

public interface IMidiDeviceXMLHelper {

	boolean isDirty();

	void setDirty(boolean dirty);

	/**
	 * 
	 * @return
	 */
	Device getDevice();

	/**
	 * 
	 * @return
	 */
	ButtonGroups getButtonGroups();

	/**
	 * 
	 * @return
	 */
	List<ButtonSet> getButtonSets();

	/**
	 * 
	 * @param reqestedSet
	 * @return
	 */
	List<MidiButton> getMidiButtonSet(int reqestedSet);

	/**
	 * 
	 * @return
	 */
	String getXMLFileName();

}