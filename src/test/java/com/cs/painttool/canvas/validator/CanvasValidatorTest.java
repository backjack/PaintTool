package com.cs.painttool.canvas.validator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cs.painttool.validator.CanvasValidator;
import com.cs.painttool.validator.parameters.ValidatorParameter;
import com.google.common.collect.Lists;

@RunWith(MockitoJUnitRunner.class)
public class CanvasValidatorTest {


	private CanvasValidator canvasValidator;
	
	@Mock
	private ValidatorParameter validatorParameter;
	
	@Before
	public void setUp() throws Exception {
		
		canvasValidator = new CanvasValidator();
	}

	@Test
	public void testValidate_valid() throws Exception {
	
		List<String> params = Lists.newArrayList();
		params.add("10");
		params.add("20");		
		Assert.assertTrue(canvasValidator.validate(params, validatorParameter));

	}
	
	@Test
	public void testValidate_invalid() {
	
		List<String> params = Lists.newArrayList();
		params.add("0");
		params.add("10");
		try {
			canvasValidator.validate(params, validatorParameter);
		} catch (Exception e) {
			Assert.fail("Canvas Height or Width cannot be zero");
		}
		
	}

}
