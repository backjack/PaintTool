package com.cs.painttool.canvas.validator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cs.painttool.validator.Validator;
import com.cs.painttool.validator.parameters.ValidatorParameter;
import com.google.common.collect.Lists;

public class ValidatorTest {

	
	private Validator validator;
	
	@Before
	public void setUp() throws Exception {
		validator = new Validator();
	}

	@Test
	public void testValidate_valid_case1() throws Exception {
		
		List<Class> parametersTypes = Lists.newArrayList();
		parametersTypes.add(Integer.class);
		parametersTypes.add(Integer.class);
		parametersTypes.add(String.class);
		parametersTypes.add(Double.class);

		ValidatorParameter validatorParameter = new ValidatorParameter(parametersTypes);
		
		List<String> params = Lists.newArrayList();
		params.add("1");
		params.add("167");
		params.add("test");
		params.add("12.5");
		Assert.assertTrue(validator.validate(params, validatorParameter));
	}
	
	@Test
	public void testValidate_invalid_case2() {
		
		List<Class> parametersTypes = Lists.newArrayList();
		parametersTypes.add(Integer.class);
		parametersTypes.add(Integer.class);
		parametersTypes.add(String.class);
		ValidatorParameter validatorParameter = new ValidatorParameter(parametersTypes);
		
		List<String> params = Lists.newArrayList();
		params.add("1");
		try {
			validator.validate(params, validatorParameter);
			Assert.fail(" Insufficent parameters for command. Minimum required is 3");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testValidate_invalid_case3() {
		
		List<Class> parametersTypes = Lists.newArrayList();
		parametersTypes.add(Integer.class);
		ValidatorParameter validatorParameter = new ValidatorParameter(parametersTypes);
		List<String> params = Lists.newArrayList();
		params.add("1.2");
		try {
			validator.validate(params, validatorParameter);
			Assert.fail("1.2 is not type of java.lang.Integer");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
