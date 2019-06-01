package com.tntdjs.midi.controllers.data.config.objects.validation;

import java.util.List;

/**
 * IValidatable
 * @author tsenausk
 *
 */
public interface IValidatable {

	public List<IValidation> getValidations();
	public boolean setValidations(List<IValidation> validations);
	
}
