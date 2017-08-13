package com.cs.painttool.canvas.draw;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.cs.painttool.canvas.Canvas;
import com.cs.painttool.utils.Constants;
import com.google.common.collect.Lists;

public class DrawLineTest {

	private DrawLine drawLine;
	
	@Mock
	private Canvas canvas;
	
	@Before
	public void setUp() throws Exception {
		
		drawLine = new DrawLine();
	}

	@Test
	public void testDraw() throws Exception {
	
		Canvas canvas = new Canvas(3,6);
		List<String> parameters = Lists.newArrayList();
		parameters.add("2");
		parameters.add("1");
		parameters.add("4");
		parameters.add("1");
		drawLine.draw(canvas, parameters, "x");
		Assert.assertEquals(Constants.DEFAULT_LINE_CHARACTER, canvas.getScreen().get(1).get(2));
		Assert.assertEquals(Constants.DEFAULT_LINE_CHARACTER, canvas.getScreen().get(1).get(3));
		Assert.assertEquals(Constants.DEFAULT_LINE_CHARACTER, canvas.getScreen().get(1).get(4));		
	}
	
	
	@Test
	public void testDraw_1() throws Exception {
	
		Canvas canvas = new Canvas(4,6);
		List<String> parameters = Lists.newArrayList();
		parameters.add("1");
		parameters.add("2");
		parameters.add("1");
		parameters.add("4");
		drawLine.draw(canvas, parameters, "x");
		Assert.assertEquals(Constants.DEFAULT_LINE_CHARACTER, canvas.getScreen().get(2).get(1));
		Assert.assertEquals(Constants.DEFAULT_LINE_CHARACTER, canvas.getScreen().get(3).get(1));
		Assert.assertEquals(Constants.DEFAULT_LINE_CHARACTER, canvas.getScreen().get(4).get(1));		
	}
	
	@Test
	public void testDraw_fail() {
	
		Canvas canvas = new Canvas(4,6);
		List<String> parameters = Lists.newArrayList();
		parameters.add("1");
		parameters.add("2");
		parameters.add("3");
		parameters.add("4");
		try {
			drawLine.draw(canvas, parameters, "x");
			Assert.fail("It is basic version, hence only Horizontal or Vertical Line can be drawn");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}	
	}

}
