package com.cs.painttool.canvas;

import org.junit.Assert;
import org.junit.Test;

import com.cs.painttool.canvas.Canvas;
import com.cs.painttool.utils.Constants;

public class CanvasTest {


	@Test
	public void testClear() {
		
		Canvas canvas = new Canvas(2,2);
		canvas.getScreen().get(1).set(2,"x");
		canvas.getScreen().get(1).set(1,"x");
		canvas.getScreen().get(2).set(1,"x");
		canvas.getScreen().get(2).set(2,"x");
		canvas.clear();
		Assert.assertEquals(Constants.EMPTY_PIXEL_VALUE, canvas.getScreen().get(1).get(2));
		Assert.assertEquals(Constants.EMPTY_PIXEL_VALUE, canvas.getScreen().get(1).get(1));
		Assert.assertEquals(Constants.EMPTY_PIXEL_VALUE, canvas.getScreen().get(2).get(1));
		Assert.assertEquals(Constants.EMPTY_PIXEL_VALUE, canvas.getScreen().get(2).get(2));		
	}

	@Test
	public void testValidatePixel() {
		
		Canvas canvas = new Canvas(5,5);
		Assert.assertTrue(canvas.validatePixel(1, 2));
		Assert.assertTrue(canvas.validatePixel(5, 5));
		Assert.assertTrue(!canvas.validatePixel(0, 0));
		Assert.assertTrue(!canvas.validatePixel(-1, 3));
		Assert.assertTrue(!canvas.validatePixel(3, -1));
	}

}
