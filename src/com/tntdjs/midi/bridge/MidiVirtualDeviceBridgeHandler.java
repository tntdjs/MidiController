package com.tntdjs.midi.bridge;

import com.tntdjs.midi.IReceiver;
import com.tntdjs.midi.controllers.AbstractMidiDeviceHandler;

/**
 * MidiVirtualDeviceBridgeHandler
 * @author tsenausk
 *
 */
public class MidiVirtualDeviceBridgeHandler extends AbstractMidiDeviceHandler {
	//"LoopBe1 Virtual Midi Cable e.g. LoopBe Internal MIDI";
	public static final String MIDI_OUTPUT_DEVICE = "LoopBe Internal MIDI"; 
	public static final String MIDI_INPUT_DEVICE = "LoopBe Internal MIDI";
	
	/**
	 * constructor
	 */
	public MidiVirtualDeviceBridgeHandler() {
		super();
		initMidi();
	}

	@Override
	public IReceiver getMidiInputReceiver() {
		return null;
	}

	@Override
	public String getDeviceName() {
		return MIDI_OUTPUT_DEVICE;
	}

}
