package com.cs.painttool.canvas.validator.factory;

import org.junit.Assert;
import org.junit.Test;

import com.cs.painttool.utils.Constants;
import com.cs.painttool.validator.CanvasValidator;
import com.cs.painttool.validator.IValidator;
import com.cs.painttool.validator.Validator;
import com.cs.painttool.validator.factory.ValidatorFactory;

public class ValidatorFactoryTest {

	@Test
	public void testGetValidatorFactory() {
		
		ValidatorFactory validatorFactory = ValidatorFactory.getValidatorFactory();
		Assert.assertTrue(validatorFactory!=null);
	}

	@Test
	public void testGetValidator_valid() {
		
		ValidatorFactory validatorFactory = ValidatorFactory.getValidatorFactory();
		IValidator validator =validatorFactory.getValidator("x");
		Assert.assertEquals(Validator.class, validator.getClass());
		
		validator =validatorFactory.getValidator(Constants.CANVAS_COMMAND);
		Assert.assertEquals(CanvasValidator.class, validator.getClass());
	}
	
	@Test
	public void testGetValidator_null() {
		
		ValidatorFactory validatorFactory = ValidatorFactory.getValidatorFactory();
		String command = null;
		IValidator validator =validatorFactory.getValidator(command);
		Assert.assertEquals(null, validator);

	}


}
