package com.tntdjs.midi.controllers;

import javax.sound.midi.MidiMessage;

import com.tntdjs.midi.IMidiExecuter;
import com.tntdjs.midi.controllers.data.config.MidiDeviceXMLHelper;
import com.tntdjs.midi.controllers.data.config.objects.MidiButton;
import com.tntdjs.midi.executer.ExecuterFactory;

/**
 * 
 * @author tsenauskas
 *
 */
public class MIDIInputReceiver extends AbstractMidiInputReceiver {
	private static final int BANK = 0;
//	private IValidation validator = new MidiButtonEnabledValidator();	
		
	/**
	 * 
	 * @param MidiNote
	 * @return
	 */
	protected boolean isButtonEnabled(int MidiNote) {	
		for (MidiButton button : MidiDeviceXMLHelper.getInstance().getMidiButtonSet(BANK)) {			
			if (button.getMidiNote().equals(MidiNote)) { // && button.getEnabled()) {
//				return validator.isValid(button);
				return button.test();
			}
		}
		return false;
	}

	/**
	 * Send
	 */
	public void send(MidiMessage msg, long timeStamp) {
		int offSet1 = MidiDeviceXMLHelper.getInstance().getButtonSets().get(BANK).getBank();
		if (msg.getLength() > 0) {
			System.out.println("Offset="+offSet1);
			System.out.println("Message x,y,z="+msg.getMessage()[0]+", "+msg.getMessage()[1]+", "+msg.getMessage()[2]);
			if (Integer.valueOf(msg.getMessage()[0]).equals(offSet1)) {
				if (isButtonEnabled(msg.getMessage()[1])) {
					((IMidiExecuter)ExecuterFactory.getInstance().getExecuterByMidiNote(msg.getMessage()[1])).executer();
				}
			}
		}
	}
	
}