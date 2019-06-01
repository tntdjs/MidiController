package com.tntdjs.midi;

import com.tntdjs.midi.controllers.data.config.objects.MidiButton;

/**
 * IMidiExecuter
 * @author tsenausk
 */
public interface IMidiExecuter {

	public MidiButton getMidiButton();
	public void setMidiButton(MidiButton midiButton);
	public void executer();

}