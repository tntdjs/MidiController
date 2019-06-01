package com.tntdjs.midi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MidiControllerDefMgr
 * @author tsenauskas
 */
@Service
public class MidiControllerDefMgr {
	private IMidiControllerDef midiControllerDef;

	/**
	 * 
	 * @return
	 */
	public IMidiControllerDef getMidiControllerDef() {
		return midiControllerDef;
	}

	/**
	 * 
	 * @param midiControllerDef
	 */
	@Autowired
	public void setMidiControllerDef(IMidiControllerDef midiControllerDef) {
		this.midiControllerDef = midiControllerDef;
	}
	
}
