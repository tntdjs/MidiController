package com.tntdjs.midi.executer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sun.glass.events.KeyEvent;
import com.tntdjs.midi.controllers.data.config.objects.MidiButton;

public class KeyExecuter extends MidiExecuter {
	private static final Logger LOGGER = LogManager.getLogger(KeyExecuter.class.getName());
	private Robot ROBOT;
	private static final String CTRL = "ctrl";
	private static final String ALT = "alt";
	private static final String SHIFT = "shift";
	private static final int DELAY = 500;
	
	/**
	 * KeyExecuter
	 * 
	 * @param midiButton
	 */
	public KeyExecuter(MidiButton midiButton) {
		super(midiButton);
		try {
			ROBOT = new Robot();
			ROBOT.setAutoDelay(DELAY);
			ROBOT.setAutoWaitForIdle(true);
		} catch (AWTException e) {
			LOGGER.error(e);
		}
	}

	/**
	 * executer
	 */
	@Override
	public void executer() {
		String[] keyMods = {};
		if (!getMidiButton().getKeymod().isEmpty()) {
			keyMods = getMidiButton().getKeymod().split(",");
		}

		type(getMidiButton().getKeypressed(), keyMods);
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void leftClick() {
		ROBOT.mousePress(InputEvent.BUTTON1_MASK);
		ROBOT.delay(DELAY);
		ROBOT.mouseRelease(InputEvent.BUTTON1_MASK);
		ROBOT.delay(DELAY);
	}

	@SuppressWarnings("unused")
	private void rightClick() {
		ROBOT.mousePress(InputEvent.BUTTON2_MASK);
		ROBOT.delay(DELAY);
		ROBOT.mouseRelease(InputEvent.BUTTON2_MASK);
		ROBOT.delay(DELAY);
	}

	/**
	 * type the key arg
	 * 
	 * @param argKey. String[] argKeyMods
	 */
	@SuppressWarnings("unused")
	private void type(int argKey, String[] argKeyMods) {
		ROBOT.delay(DELAY);
		ROBOT.keyPress(argKey);
		ROBOT.keyRelease(argKey);
	}

	/**
	 * type the key arg
	 * 
	 * @param argKey
	 */
	private void type(String argKey, String[] argKeyMods) {
		byte[] bytes = argKey.getBytes();
				
		for (byte b : bytes) {
			int code = b;
			// keycode only handles [A-Z not a-z] (which is ASCII decimal [65-90])
			if (code > 96 && code < 123) {
				code = code - 32;
			}
			ROBOT.delay(DELAY);		
			typeKeyModifiers(argKeyMods, 0);				
			ROBOT.delay(DELAY);
			ROBOT.keyPress(code);
			ROBOT.keyRelease(code);
			typeKeyModifiers(argKeyMods, 1);
		}
	}

	/**
	 * 
	 */
	private void typeKeyModifiers(String[] argKeyMods, int pressOrRelease) {
		for (int kmod = 0; kmod < argKeyMods.length; kmod++) {
			switch (argKeyMods[kmod].toLowerCase()) {
			case CTRL:
				if (pressOrRelease==0) {
					ROBOT.keyPress(KeyEvent.MODIFIER_CONTROL);
				} else {
					ROBOT.keyRelease(KeyEvent.MODIFIER_CONTROL);
				}
				break;
			case ALT:
				if (pressOrRelease==0) {					
					ROBOT.keyPress(KeyEvent.MODIFIER_ALT);
				} else {
					ROBOT.keyRelease(KeyEvent.MODIFIER_ALT);
				}				
				break;
			case SHIFT:
				if (pressOrRelease==0) {
					ROBOT.keyPress(KeyEvent.MODIFIER_SHIFT);
				} else {
//					robot.keyRelease(KeyEvent.MODIFIER_SHIFT);
				}				
				break;
			}
		}
	}
}
