package com.tntdjs.midi.controllers;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tntdjs.midi.IReceiver;
import com.tntdjs.midi.controllers.data.config.IMidiDeviceXMLHelper;

/**
 * 
 * @author tsenauskas
 *
 */
public abstract class AbstractMidiDeviceHandler implements IMidiDeviceHandler {
	private static final Logger LOGGER = LogManager.getLogger(AbstractMidiDeviceHandler.class.getName());

	private static String DEVICE_NAME;
	private MidiDevice MIDI_DEVICE;
	private IReceiver MIDI_RECEIVER;
	private Transmitter MIDI_TRANSMITTER;

	private boolean initialized = false;

	private IMidiDeviceXMLHelper xmlHelper;
	
	/**
	 * 
	 * @TODO maybe needs a new MidiInputReceiver Interface
	 * @return
	 */
//	public abstract IReceiver getMidiInputReceiver();
	
	@Override
	public void deInitMidi() {
		if (null != MIDI_DEVICE && isInitialized()) {
			MIDI_DEVICE.close();
			setInitialized(false);
			LOGGER.info("Midi Controller De-initialized");
		}
	}

	@Override
	public void initMidi() {
		LOGGER.info("Midi Controller Initializing...");
		setInitialized(false);		
		
		MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
		// for (int i = 0; i < infos.length; i++) {
		for (MidiDevice.Info info : infos) {
			try {
				// if (DEVICE_NAME.equals(infos[i].getName())) {
				// device = MidiSystem.getMidiDevice(infos[i]);
				LOGGER.info("Midi Ctlrs Device(s)[" + info + "] for " + DEVICE_NAME);				
				if (DEVICE_NAME.equals(info.getName())) {
					MIDI_DEVICE = MidiSystem.getMidiDevice(info);
					// does the device have any transmitters?
					// if it does, add it to the device list
					LOGGER.info("Midi Ctlrs(" + info + ") for " + DEVICE_NAME);

					// get all transmitters
//					List<Transmitter> transmitters = MIDI_DEVICE.getTransmitters();
					// and for each transmitter assign a receiver
					MIDI_RECEIVER = getMidiInputReceiver();

					// for (int j = 0; j < transmitters.size(); j++) {
//					for (Transmitter transmitter : transmitters) {
//						ireceiver.setMidiInputReciever(midiDevice.getDeviceInfo().toString());
//						if (ireceiver instanceof Receiver) {
//							// transmitters.get(j).setReceiver((Receiver)ireceiver);
//							transmitter.setReceiver((Receiver) ireceiver);
//						} else {
//							LOGGER.info("Midi Ctlrs(" + info + ")" + info);
//						}
//					}

					MIDI_TRANSMITTER = MIDI_DEVICE.getTransmitter();
					MIDI_TRANSMITTER.setReceiver((Receiver) MIDI_RECEIVER);
					
					// open each device
					MIDI_DEVICE.open();
					// if code gets this far without throwing an exception
					// print a success message
					LOGGER.info(MIDI_DEVICE.getDeviceInfo() + " Was Opened");
					setInitialized(true);
					
//					ShortMessage midiMsg = new ShortMessage();
//					try {
//						midiMsg.setMessage(ShortMessage.NOTE_ON, 0, 60, 63);
//						((Receiver) MIDI_RECEIVER).send(midiMsg, 1000);
//						midiMsg.setMessage(ShortMessage.NOTE_ON, 0, 61, 63);
//						((Receiver) MIDI_RECEIVER).send(midiMsg, 1000);
//						midiMsg.setMessage(ShortMessage.NOTE_ON, 0, 62, 63);
//						((Receiver) MIDI_RECEIVER).send(midiMsg, 1000);
//					} catch (InvalidMidiDataException e) {
//						LOGGER.error(e);
//					}
										
					
				}
			} catch (MidiUnavailableException e) {
				// this is not severe it is just an unmappable device
				LOGGER.error("Error Aquiring Midi Device", e);
			}
		}
	}

	public AbstractMidiDeviceHandler() {
		super();
	}

	public AbstractMidiDeviceHandler(IMidiDeviceXMLHelper argXmlHelper) {
		super();
		xmlHelper = argXmlHelper;
		initMidi();
	}

	public IMidiDeviceXMLHelper getXmlHelper() {
		return xmlHelper;
	}
	
	@Override
	public boolean isInitialized() {
		return initialized;
	}

	private void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	public void configure() {

	}

	public IReceiver getReceiver() {
		return MIDI_RECEIVER;
	}

	public void setReceiver(IReceiver ireceiver) {
		this.MIDI_RECEIVER = ireceiver;
	}

	public Transmitter getTransmitter() {
		return MIDI_TRANSMITTER;
	}

	public void setTransmitter(Transmitter trans) {
		this.MIDI_TRANSMITTER = trans;
	}

	public void setDeviceName(String deviceName) {
		DEVICE_NAME = deviceName;
	}
	
	public String getDeviceName() {
		return DEVICE_NAME;
	}
	
}