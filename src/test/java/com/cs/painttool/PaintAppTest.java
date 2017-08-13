package com.cs.painttool;

import org.junit.Before;
import org.junit.Test;

import com.cs.painttool.PaintApp;

public class PaintAppTest {

	private PaintApp paintApp;
	@Before
	public void setUp() throws Exception {
		paintApp = new PaintApp();
	}

	//@Test
	public void testProcessInput() {
	
		paintApp.processInput();
	}

}
