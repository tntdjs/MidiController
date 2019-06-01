package com.tntdjs.midi.controllers.data.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.tntdjs.midi.controllers.data.config.objects.ButtonSet;
import com.tntdjs.midi.controllers.data.config.objects.MidiButton;
import com.tntdjs.midi.controllers.data.config.objects.MidiDevices;
import com.tntdjs.midi.controllers.data.config.objects.MidiDevices.Device;
import com.tntdjs.midi.controllers.data.config.objects.MidiDevices.Device.ButtonGroups;

/**
 * 
 * @author tsenauskas
 *
 */
public class MarshallMidiDevice {
	private static final Logger LOGGER = LogManager.getLogger(MarshallMidiDevice.class.getName());
	
	public static void main(String[] args) {
		MidiDevices midiDevices = new MidiDevices();
		Device device = new Device();
		device.setManufacturer("Novation");
		device.setName("LaunchPad");
		midiDevices.setDevice(device);

		JAXBContext jaxbContext;
		try {
			ButtonGroups buttonGroups = new ButtonGroups();
			device.setButtonGroups(buttonGroups);
			List<ButtonSet> buttonSetList = new ArrayList<ButtonSet>();
			ButtonSet buttonSet = new ButtonSet();
			buttonSetList.add(buttonSet);
			buttonGroups.setButtonSet(buttonSetList);

			buttonSet.setName("Bank1");
			buttonSet.setBank(new Integer(0));			
			List<MidiButton> midiButtonList = new ArrayList<MidiButton>();
			midiButtonList.add(0, new MidiButton("1", "value", new Integer(1), "type", "Play", "true", "filesource"));
			midiButtonList.add(1, new MidiButton("2", "value", new Integer(2), "type", "Play", "true", "filesource"));
			midiButtonList.add(2, new MidiButton("3", "value", new Integer(3), "type", "Play", "true", "filesource"));
			midiButtonList.add(3, new MidiButton("4", "value", new Integer(4), "type", "Play", "true", "filesource"));
			buttonSet.setMidiButtons(midiButtonList);
			
 			/**
			 * This is for the XML validation using XSD
			 */
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI );
			Schema schema = null;
			try {
				schema = sf.newSchema( new File( "config/midi/controllers/MidiDevice.xsd" ) );
												
			} catch (SAXException e) {
				LOGGER.error(e);
			}
			/**
			 * End Validation
			 */
			
			jaxbContext = JAXBContext.newInstance( MidiDevices.class );
			JAXBSource jaxbsourceMidiDevices = new JAXBSource( jaxbContext, midiDevices );
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			Validator validator;
			validator = schema.newValidator();
			validator.setErrorHandler( new XMLErrorHandler() );
			
	        //validator is used
	        try {
	            validator.validate( jaxbsourceMidiDevices );
	            System.out.println( "Midi Deives has no problems" );
	        }
	        catch( SAXException ex ) {
	            ex.printStackTrace();
	            System.out.println( "Midi Deives has SAXException problems" );
	        } catch (IOException e) {
				e.printStackTrace();
	            System.out.println( "Midi Deives has I/O problems" );
			}
			
			jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
			jaxbMarshaller.marshal( midiDevices, new File( "config/LaunchPadConfig.xml" ) );
			jaxbMarshaller.marshal( midiDevices, System.out );
			
		} catch (JAXBException e1) {
			LOGGER.error(e1);
		}
		
	}
	
}
