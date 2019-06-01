/**
 * 
 */
package com.tntdjs.midi.bridge;

import javax.sound.midi.MidiMessage;

import com.tntdjs.midi.controllers.AbstractMidiInputReceiver;

/**
 * AbstractMidiInputReceiver
 * @author tsenausk
 */
public class MidiVirtualBridgeInputReceiver extends AbstractMidiInputReceiver {

	/**
	 * constructor
	 */
	public MidiVirtualBridgeInputReceiver() {
		super();
	}
	
	@Override
	public void send(MidiMessage msg, long timeStamp) {}

	/**
	 * Unused in the Midi Bridge
	 * @todo Refactor this abstract method out of the AbstractMidiInputReceiver
	 */
	@Override
	protected boolean isButtonEnabled(int MidiNote) {return false;}

}
