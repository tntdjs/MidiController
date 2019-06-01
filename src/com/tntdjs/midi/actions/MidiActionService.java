package com.tntdjs.midi.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tntdjs.midi.controllers.data.config.objects.MidiButton;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * MidiActionService defines something to happen when a midi button is pushed on
 * the FX midi UI or midi hardware device.
 * 
 * @author tsenausk
 * @deprecated
 */
public class MidiActionService extends Service<MidiButton> {
	private static final Logger LOGGER = LogManager.getLogger(MidiActionService.class.getName());
	private MidiButton MIDI_BUTTON;
	
	@Override
	protected Task<MidiButton> createTask() {
		return new Task<MidiButton>() {
			@Override
			protected MidiButton call() {
				LOGGER.info("InAction=" + MIDI_BUTTON.getValue());
				return MIDI_BUTTON;
			}
		};
	}

	public MidiButton getMIDI_BUTTON() {
		return MIDI_BUTTON;
	}

	public void setMIDI_BUTTON(MidiButton mIDI_BUTTON) {
		MIDI_BUTTON = mIDI_BUTTON;
	}
}
