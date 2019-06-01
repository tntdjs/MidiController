package com.tntdjs.midi.controllers.data.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.tntdjs.midi.controllers.MidiControllerDefMgr;
import com.tntdjs.midi.controllers.data.config.objects.ButtonSet;
import com.tntdjs.midi.controllers.data.config.objects.MidiButton;
import com.tntdjs.midi.controllers.data.config.objects.MidiDevices;
import com.tntdjs.midi.controllers.data.config.objects.MidiDevices.Device;
import com.tntdjs.midi.controllers.data.config.objects.MidiDevices.Device.ButtonGroups;

/**
 * 
 * Copyright (c) 2017, Todd M. Senauskas and/or its affiliates. All rights reserved.
 * @author tsenauskas
 *
 */
public class MidiDeviceXMLHelper implements IMidiDeviceXMLHelper {
	private static final Logger LOGGER = LogManager.getLogger(MidiDeviceXMLHelper.class.getName());
	private JAXBContext jaxbContext;
	private Unmarshaller jaxbUnmarshaller;
	private MidiDevices midiDevices;
	private boolean dirty = false;
	private static ApplicationContext CONTEXT = null;	
	private static MidiDeviceXMLHelper INSTANCE;
	private MidiControllerDefMgr midiDefMgr = null;
			
	/**
	 * Constructor
	 * @param appContext
	 */
	public MidiDeviceXMLHelper(ApplicationContext appContext) {
		super();
		CONTEXT = appContext;
		midiDefMgr = (MidiControllerDefMgr) CONTEXT.getBean("midiControllerDefMgr");
		LOGGER.info("\r\nCurrent Controller is: " + 
				midiDefMgr.getMidiControllerDef().getMidiControllerPath() + 
					midiDefMgr.getMidiControllerDef().getMidiControllerName() +
					"\r\nXML Configuration is:" +
					midiDefMgr.getMidiControllerDef().getXmlConfiguration());

		File file = new File(getXMLFileName());
		LOGGER.info("MIDI XML device configuration file [" +getXMLFileName()+ "] - exists? " + file.exists());
		
		try {
			jaxbContext = JAXBContext.newInstance(MidiDevices.class);
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			midiDevices = (MidiDevices) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			LOGGER.fatal("Error parsing XML file (" + getXMLFileName() + ")", e);
		}
	}
	
	/**
	 * getInstance with an Application Context initially
	 * @param CONTEXT
	 * @return
	 */
	public static MidiDeviceXMLHelper getInstance(ApplicationContext appContext) {
		if (null != appContext) {
			INSTANCE = new MidiDeviceXMLHelper(appContext);
		} else {
			LOGGER.error("Class requires ApplicationContext CONTEXT to initialize.");
		}
		return INSTANCE;
	}
		
	public static MidiDeviceXMLHelper getInstance() {
		if (null == INSTANCE) {
			LOGGER.error("Class requires ApplicationContext CONTEXT to initialize.");
		}
		return INSTANCE;
	}
	
	/**
	 * 
	 */
	public String getXMLFileName() {
		return midiDefMgr.getMidiControllerDef().getXmlConfiguration();
//		return "config/midi/controllers/akai/lpd8/LPD8Config.xml";
	}
	
	
	/* (non-Javadoc)
	 * @see com.tntdjs.midi.controllers.data.config.IMidiDeviceXMLHelper#isDirty()
	 */
	@Override
	public boolean isDirty() {
		return dirty;
	}

	/* (non-Javadoc)
	 * @see com.tntdjs.midi.controllers.data.config.IMidiDeviceXMLHelper#setDirty(boolean)
	 */
	@Override
	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	/* (non-Javadoc)
	 * @see com.tntdjs.midi.controllers.data.config.IMidiDeviceXMLHelper#getDevice()
	 */
	@Override
	public Device getDevice() {
		return midiDevices.getDevice();
	}

	/* (non-Javadoc)
	 * @see com.tntdjs.midi.controllers.data.config.IMidiDeviceXMLHelper#getButtonGroups()
	 */
	@Override
	public ButtonGroups getButtonGroups() {
		ButtonGroups buttonGroups = getDevice().getButtonGroups();
		return buttonGroups;
	}

	/* (non-Javadoc)
	 * @see com.tntdjs.midi.controllers.data.config.IMidiDeviceXMLHelper#getButtonSets()
	 */
	@Override
	public List<ButtonSet> getButtonSets() {
		List<ButtonSet> buttonList = getButtonGroups().getButtonSet();
		return buttonList;
	}
	
	/* (non-Javadoc)
	 * @see com.tntdjs.midi.controllers.data.config.IMidiDeviceXMLHelper#getMidiButtonSet(int)
	 */
	@Override
	public List<MidiButton> getMidiButtonSet(int bank) {
		List<MidiButton> mButtonList = new ArrayList<MidiButton>();
		if (!getButtonSets().isEmpty() && getButtonSets().size() >= bank) {
			mButtonList = getButtonSets().get(bank).getMidiButtons();
		}
		return mButtonList;
	}

	/* (non-Javadoc)
	 * @see com.tntdjs.midi.controllers.data.config.IMidiDeviceXMLHelper#getXMLFileName()
	 */
//	@Override
//	public abstract String getXMLFileName();

}