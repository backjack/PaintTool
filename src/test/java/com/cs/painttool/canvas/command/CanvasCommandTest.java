package com.cs.painttool.canvas.command;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.cs.painttool.canvas.CanvasManager;
import com.cs.painttool.command.CanvasCommand;
import com.cs.painttool.validator.IValidator;
import com.google.common.collect.Lists;

public class CanvasCommandTest {

	private CanvasCommand canvasCommand;
	
	private CanvasManager canvasManager;
	
	@Mock
	private IValidator ivalidator;
	
	@Before
	public void setUp() throws Exception {
		canvasManager = new CanvasManager();
		canvasCommand = new CanvasCommand(ivalidator,canvasManager);

	}

	@Test
	public void testProcessCommand() throws Exception {
		
		List<String> params = Lists.newArrayList();
		params.add("5");
		params.add("5");
		canvasCommand.processCommand(params);
		Assert.assertTrue(canvasManager.getCanvas()!=null);
		
	}

	@Test
	public void testProcessCommand_invalid() {
		
		try {
			List<String> params = Lists.newArrayList();
			params.add("5");
			params.add("5");
			canvasCommand.processCommand(params);
		} catch(Exception ex) {
			Assert.fail("Cannot create new Canvas, as it already exits");
			System.out.println(ex.toString());
		}
		
		
	}
	
}
