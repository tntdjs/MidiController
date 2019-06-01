package com.tntdjs.midi.executer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tntdjs.midi.MidiTypeTypes;
import com.tntdjs.midi.bridge.MidiBridge;
import com.tntdjs.midi.controllers.data.config.objects.MidiButton;

/**
 * BridgeMidiExecuter
 * @author tsenausk
 *
 */
public class BridgeMidiExecuter extends MidiExecuter {
	private static Logger LOGGER = LogManager.getRootLogger();
	private MidiBridge bridge = new MidiBridge();
	
	@Override
	public void executer() {
		LOGGER.warn("BridgeMidiExecuter execute...");
    	if (getMidiButton().getType().equalsIgnoreCase(MidiTypeTypes.bridge)) {
    		/*
    		 * @See value defaults in MidiButton.java
    		 */
    		bridge.send(getMidiButton().getMidiDevice(), getMidiButton().getMidiChannel(), getMidiButton().getMidiNote(), getMidiButton().getMidiVelocity(), getMidiButton().getMidiDuration());
    	}
	}
	
	/**
	 * Constructor
	 * @param midiButton
	 */
	public BridgeMidiExecuter(MidiButton midiButton) {
		super(midiButton);
	}

}
