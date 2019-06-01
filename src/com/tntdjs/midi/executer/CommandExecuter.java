package com.tntdjs.midi.executer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tntdjs.midi.controllers.data.config.objects.MidiButton;

/**
 * CommandExecuter
 * 
 * @author tsenausk
 *
 */
public class CommandExecuter extends MidiExecuter {
	private static final Logger LOGGER = LogManager.getLogger(CommandExecuter.class.getName());

	/**
	 * CommandExecuter
	 * 
	 * @param midiButton
	 */
	public CommandExecuter(MidiButton midiButton) {
		super(midiButton);
	}

	/**
	 * executer
	 */
	@Override
	public void executer() {
		String cmd = getMidiButton().getCmd();
		try {
			if (!getMidiButton().getCmdargs().isEmpty()) {
				final String[] parsedArgs = getMidiButton().getCmdargs().split(",");
				for (int argv = 0; argv < parsedArgs.length; argv++) {
					cmd = " " + parsedArgs[argv];
				}
			}
			Runtime.getRuntime().exec(cmd);
		} catch (final Exception err) {
			// CHECKSTYLE:ON IllegalCatch
			LOGGER.error("Error launching external program.", err);
		}
	}
}