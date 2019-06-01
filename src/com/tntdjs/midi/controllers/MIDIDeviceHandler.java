package com.tntdjs.midi.controllers;

import com.tntdjs.midi.IReceiver;

/**
 * MIDIDeviceHandler
 * @author tsenauskas
 *
 */
public final class MIDIDeviceHandler extends AbstractMidiDeviceHandler {
	
	@Override
	public IReceiver getMidiInputReceiver() {
		return new MIDIInputReceiver();
	}

}
