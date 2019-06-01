package com.tntdjs.midi.executer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tntdjs.midi.IMidiExecuter;
import com.tntdjs.midi.controllers.data.config.objects.MidiButton;

/**
 * 
 * @author tsenausk
 *
 */
public class MidiExecuter implements IMidiExecuter {
	private static final Logger LOGGER = LogManager.getLogger(MidiExecuter.class.getName());
	protected MidiButton MIDI_BUTTON;
	
	/**
	 * MidiExecuter
	 * @param midiButton
	 */
	public MidiExecuter(MidiButton midiButton) {
		super();
		setMidiButton(midiButton);
	}
	
	@Override
	public void executer() {
		LOGGER.warn("Nothing to Execute, we should not have base executers... check MidiEnumTypes");
	}

	@Override
	public MidiButton getMidiButton() {
		return MIDI_BUTTON;
	}

	@Override
	public void setMidiButton(MidiButton midiButton) {
		this.MIDI_BUTTON = midiButton;
	}

}
