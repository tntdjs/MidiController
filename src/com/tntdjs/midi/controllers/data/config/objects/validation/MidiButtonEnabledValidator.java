package com.tntdjs.midi.controllers.data.config.objects.validation;

import com.tntdjs.midi.controllers.data.config.objects.MidiButton;

/**
 * MidiButtonEnabledValidator
 * @author tsenausk
 */
public class MidiButtonEnabledValidator implements IValidation {

	@Override
	public boolean isValid(Object valueObject) {
		return ((MidiButton)valueObject).getEnabled();
	}

	@Override
	public String getValidationLevel() {
		return null;
	}

}
