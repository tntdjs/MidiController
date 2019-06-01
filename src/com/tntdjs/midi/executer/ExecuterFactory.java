package com.tntdjs.midi.executer;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tntdjs.midi.IMidiExecuter;
import com.tntdjs.midi.MidiTypeTypes;
import com.tntdjs.midi.controllers.data.config.objects.MidiButton;

/**
 * ExecuterFactory
 * A Factory and manager class to generate midi executers of the following types
 * 		- midi bridge
 * 		- midi triggered audio clips
 * 		- key
 * 		- execute
 * 
 * @author tsenausk
 *
 */
public class ExecuterFactory {
	private static final Logger LOGGER = LogManager.getLogger(ExecuterFactory.class.getName());
	private static ExecuterFactory INSTANCE;
	private Map<Integer, IMidiExecuter> EXECUTERS = new Hashtable<Integer, IMidiExecuter>();
	
	/**
	 * 
	 */
	private ExecuterFactory() {}
	
	/**
	 * Get Instance
	 * @return
	 */
	public static ExecuterFactory getInstance() {
		if (null == INSTANCE) {
			INSTANCE = new ExecuterFactory();
		}
		return INSTANCE;
	}
	
	/**
	 * 
	 * @param id
	 */
	public IMidiExecuter getExecuterByID(String id) {		
		Iterator<Entry<Integer, IMidiExecuter>> it = EXECUTERS.entrySet().iterator();				
		while(it.hasNext()) {
			IMidiExecuter me = it.next().getValue();
			if (me.getMidiButton().getId().equalsIgnoreCase(id)) {
				return me;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param note
	 * @return
	 */
	public IMidiExecuter getExecuterByMidiNote(int note) {
		return EXECUTERS.get(note);
	}
	
	/**
	 * Create the MAP of executers based on supplied XML configurations
	 * @return
	 */
	public int generateExecuters(List<MidiButton> midiButtons) throws Exception {
		for (MidiButton midiButton : midiButtons) {		
			LOGGER.info(midiButton + " button is enabled [" + midiButton.getEnabled() +"]");
						
			if (midiButton.getEnabled()) {
				IMidiExecuter executer = null;
				
				switch (midiButton.getType().toLowerCase()) {
					case MidiTypeTypes.audio:
						executer = new AudioMidiExecuter(midiButton);
						break;					
					case MidiTypeTypes.bridge:
						executer = new BridgeMidiExecuter(midiButton);
						break;
					case MidiTypeTypes.os:
						if (midiButton.getAction().equalsIgnoreCase("cmd")) {
							executer = new CommandExecuter(midiButton);
						} else if (midiButton.getAction().equalsIgnoreCase("key")) {
							executer = new KeyExecuter(midiButton);
						}
						break;
			         default:
						executer = new MidiExecuter(new MidiButton());
				}
				
//				if (MidiTypeEnum.audio.toString().equals(midiButton.getType())) {
//					executer = new AudioMidiExecuter(midiButton);
//					
//				} else if (MidiTypeEnum.bridge.toString().equals(midiButton.getType())) {
//					executer = new BridgeMidiExecuter(midiButton);
//					
//				} else {
//					executer = new MidiExecuter(new MidiButton());
//				}
				EXECUTERS.put(midiButton.getMidiNote(), executer);
			}			
		}
		
		if (EXECUTERS.size()==0) {
			throw new Exception("Error generating executers, no Midi Buttons define check app device XML configurations");
		}
		return EXECUTERS.size();
	}

}
