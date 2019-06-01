package com.tntdjs.midi.controllers.data.config;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tntdjs.midi.controllers.data.config.objects.ButtonSet;
import com.tntdjs.midi.controllers.data.config.objects.MidiButton;
import com.tntdjs.midi.controllers.data.config.objects.MidiDevices;
import com.tntdjs.midi.controllers.data.config.objects.MidiDevices.Device.ButtonGroups;

/**
 * 
 * @author tsenausk
 *
 */
public class UnMarshallMidiDevice {
	private static final Logger LOGGER = LogManager.getLogger(UnMarshallMidiDevice.class.getName());

	public static void main(String[] args) {
		try {

			File file = new File("config/midi/controllers/akai/lpd8/LPD8Config.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(MidiDevices.class);

			/**
			 * the only difference with the marshaling operation is here
			 */
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			MidiDevices midiDevices = (MidiDevices) jaxbUnmarshaller.unmarshal(file);
			LOGGER.info("Manufacturer=" + midiDevices.getDevice().getManufacturer());
			LOGGER.info("Device=" + midiDevices.getDevice().getName());

			ButtonGroups buttonGroups = midiDevices.getDevice().getButtonGroups();
			List<ButtonSet> buttonList = buttonGroups.getButtonSet();

			for (int i = 0; i < buttonList.size(); i++) {
				ButtonSet buttonSet = buttonList.get(i);
				LOGGER.info("");
				LOGGER.info("ButtonSet=" + buttonSet.getName());
				LOGGER.info("ButtonSet Bank=" + buttonSet.getBank());
				LOGGER.info("");

				List<MidiButton> mButtonList = buttonSet.getMidiButtons();

				for (int n = 0; n < mButtonList.size(); n++) {
					MidiButton mButton = mButtonList.get(n);
					LOGGER.info("Button " + mButton.getId());
					LOGGER.info("\t" + mButton.getId());
					LOGGER.info("\t" + mButton.getAction());
					LOGGER.info("\t" + mButton.getSource());
					LOGGER.info("\t" + mButton.getType());
					LOGGER.info("\t" + mButton.getValue());
					LOGGER.info("\t" + mButton.getMidiNote());
				}
			}
			LOGGER.info(midiDevices);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
