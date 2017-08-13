package com.cs.painttool.validator.factory;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.cs.painttool.validator.CanvasValidator;
import com.cs.painttool.validator.IValidator;
import com.cs.painttool.validator.Validator;
import static com.cs.painttool.utils.Constants.CANVAS_COMMAND;

public class ValidatorFactory {

	private Map<String,IValidator> commandValidatorMap;
	private IValidator defaultValidator;
	private static ValidatorFactory validatorFactory;
	
	private ValidatorFactory() {
		
		commandValidatorMap = new HashMap<String,IValidator>();
		CanvasValidator canvasvalidator = new CanvasValidator();
		commandValidatorMap.put(CANVAS_COMMAND,canvasvalidator);
		defaultValidator = new Validator();
	}
	
	public static ValidatorFactory getValidatorFactory() {
		
		if( validatorFactory ==null) {			
			validatorFactory = new ValidatorFactory();
		}
		return validatorFactory;
	}
	
	public IValidator getValidator(String command) {
		
		IValidator iValidator = null;
		if (!StringUtils.isEmpty(command)) {
			 iValidator = commandValidatorMap.get(command);
			if (iValidator == null) {
				return defaultValidator;
			}
		}
		return iValidator;
	}
}
