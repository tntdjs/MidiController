package com.tntdjs.midi.executer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tntdjs.mediaplayer.IMediaPlayerController;
import com.tntdjs.mediaplayer.MediaPlayerController;
import com.tntdjs.midi.controllers.data.config.objects.MidiButton;

/**
 * AudioMidiExecuter
 * @author tsenausk
 *
 */
public class AudioMidiExecuter extends MidiExecuter {
	private static Logger LOGGER = LogManager.getRootLogger();
	private IMediaPlayerController mpc;
	
	@Override
	public void executer() {
		LOGGER.warn("AudioMidiExecuter execute...");
		if (MIDI_BUTTON.getMidiDuration() == 0) {
			mpc.stop();
		} else {
			mpc.play();
		}
	}
	
	/**
	 * Constructor
	 * @param midiButton
	 */
	public AudioMidiExecuter(MidiButton midiButton) {
		super(midiButton);
		mpc = new MediaPlayerController(midiButton.getSource());
	}
}
