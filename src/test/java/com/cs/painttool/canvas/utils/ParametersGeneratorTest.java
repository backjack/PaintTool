package com.cs.painttool.canvas.utils;

import static org.junit.Assert.fail;

import java.util.List;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cs.painttool.utils.ParametersGenerator;

public class ParametersGeneratorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetParameters_valid() throws Exception {
		
		String input = "B 2 1 o";
		List<String> params = ParametersGenerator.getParameters(input);
		Assert.assertEquals("B", params.get(0));
		Assert.assertEquals("2", params.get(1));
	}
	
	@Test
	public void testGetParameters_valid2() throws Exception {
		
		String input = "  B    2     6   7   ";
		List<String> params = ParametersGenerator.getParameters(input);
		Assert.assertEquals("B", params.get(0));
		Assert.assertEquals("2", params.get(1));
		Assert.assertEquals("6", params.get(2));
		Assert.assertEquals("7", params.get(3));
		Assert.assertEquals(4, params.size());
	}
	
	@Test
	public void testGetParameters_invalid() {
		
		try {
				String input = "          ";
				List<String> params = ParametersGenerator.getParameters(input);
				System.out.println(params);
				fail("The command is empty");
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
	    }
	}
}
