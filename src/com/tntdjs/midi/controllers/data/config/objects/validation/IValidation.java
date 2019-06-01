package com.tntdjs.midi.controllers.data.config.objects.validation;

/**
 * IValidator
 * @author tsenausk
 *
 */
public interface IValidation {

	public String getValidationLevel();
	
	/**
	 * Validate
	 * 
	 * @return valid true or false
	 */
	public boolean isValid(Object valueObject);
	
	
}