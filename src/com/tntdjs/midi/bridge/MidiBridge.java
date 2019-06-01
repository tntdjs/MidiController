package com.tntdjs.midi.bridge;

/*
 *	MidiNote.java
 *
 *	This file is part of jsresources.org
 */

/*
 * Copyright (c) 1999 - 2006 by Matthias Pfisterer
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * MidiBridge
 * Bridge for Midi program to chat with another Midi program. This
 * is dependent on the virtual LoopBe1 Midi driver from http://www.nerds.de/
 */
public class MidiBridge {
	private static final Logger LOGGER = LogManager.getLogger(MidiBridge.class.getName());
	
	/**
	 * send
	 * @param args - "LoopBe Internal MIDI"	12	10 10
	 */
	public void send(String device, int channel, int key, int velocity, int duration) {
		MidiDevice outputDevice = null;
		Receiver receiver = null;
		if (device != null) {
			MidiDevice.Info info = MidiBridgeCommon.getMidiDeviceInfo(device, true);
			if (info == null) {
				LOGGER.warn("no device info found for name " + device);
			}
			try {
				outputDevice = MidiSystem.getMidiDevice(info);
				LOGGER.info("MidiDevice: " + outputDevice);
				outputDevice.open();
				receiver = outputDevice.getReceiver();
			} catch (MidiUnavailableException e) {
				LOGGER.error("Unable to retrieve MidiDevice", e);			
			}
		} else {
			/*
			 * Retrieve a Receiver for the default MidiDevice.
			 */
			try {
				receiver = MidiSystem.getReceiver();
			} catch (MidiUnavailableException e) {
				LOGGER.error(e);
			}
		}
		if (receiver == null) {
			LOGGER.warn("wasn't able to retrieve Receiver");
		}

		LOGGER.debug("Receiver: " + receiver);
		
		/*
		 * Prepare the MIDI msgs to send. One is for turning 
		 * the key on and one for turning it off.
		 */
		ShortMessage onMsg = null;
		ShortMessage offMsg = null;
		try {
			onMsg = new ShortMessage();
			offMsg = new ShortMessage();
			onMsg.setMessage(ShortMessage.NOTE_ON, channel, key, velocity);
			offMsg.setMessage(ShortMessage.NOTE_OFF, channel, key, 0);
			LOGGER.debug("On Msg: " + onMsg.getStatus() + " " + onMsg.getData1() + " " + onMsg.getData2());
			LOGGER.debug("Off Msg: " + offMsg.getStatus() + " " + offMsg.getData1() + " " + offMsg.getData2());
		} catch (InvalidMidiDataException e) {
			LOGGER.error(e);
		}

		/*
		 * Turn the note on
		 */
		LOGGER.debug("sending on message...");
		if (null != receiver) {
			receiver.send(onMsg, -1);
		}
		LOGGER.debug("...sent");

		/*
		 * Wait for the specified amount of time, the duration of the note
		 */
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			LOGGER.error(e);
		}

		/*
		 * Turn the note off.
		 */
		LOGGER.debug("sending off message...");
		if (null != receiver) {
			receiver.send(offMsg, -1);
		}
		LOGGER.debug("...sent");

		if (null != receiver) {
			receiver.close();
		}
		if (outputDevice != null) {
			outputDevice.close();
		}
	}

}
