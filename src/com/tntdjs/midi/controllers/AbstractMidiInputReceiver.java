package com.tntdjs.midi.controllers;

import javax.sound.midi.Receiver;

import com.tntdjs.midi.IReceiver;

/**
 * 
 * @author tsenausk
 *
 */
public abstract class AbstractMidiInputReceiver implements Receiver, IReceiver {
	private MidiInputReceiverData midiInputReceiverData = new MidiInputReceiverData();
	
	public AbstractMidiInputReceiver(String receiverData) {
		super();
		midiInputReceiverData.receiverData = receiverData;
	}
	
	public AbstractMidiInputReceiver() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.tntdjs.midi.IReceiver#setMidiInputReciever(java.lang.String)
	 */
	@Override
	public void setMidiInputReciever(String receiverData) {
		midiInputReceiverData.receiverData = receiverData;
	}
	
	/**
	 * @ TODO understand better how midi devices get closed on a Receiver
	 */
	public void close() {}
	
	protected abstract boolean isButtonEnabled(int MidiNote);
}