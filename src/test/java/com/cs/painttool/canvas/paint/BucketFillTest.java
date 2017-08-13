package com.cs.painttool.canvas.paint;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cs.painttool.canvas.Canvas;
import com.cs.painttool.utils.Constants;
import com.google.common.collect.Lists;

public class BucketFillTest {

	private BucketFill bucketFill;
	
	@Before
	public void setUp() throws Exception {
		bucketFill = new BucketFill();
	}

	@Test
	public void testPaint_1() throws Exception {
	
		Canvas canvas = new Canvas(2,2);
		/*canvas.getScreen().get(1).set(2,"x");
		canvas.getScreen().get(1).set(1,"x");
		canvas.getScreen().get(2).set(1,"x");
		canvas.getScreen().get(2).set(2,"x");*/
		List<String> parameters = Lists.newArrayList();
		parameters.add("1");
		parameters.add("2");
		bucketFill.paint(canvas, parameters, "o");
		
		Assert.assertEquals("o", canvas.getScreen().get(1).get(2));
		Assert.assertEquals("o", canvas.getScreen().get(1).get(1));
		Assert.assertEquals("o", canvas.getScreen().get(2).get(1));
		Assert.assertEquals("o", canvas.getScreen().get(2).get(2));		
	}
	
	@Test
	public void testPaint_2() throws Exception {
	
		Canvas canvas = new Canvas(2,2);
		canvas.getScreen().get(1).set(2,Constants.DEFAULT_LINE_CHARACTER);
		List<String> parameters = Lists.newArrayList();
		parameters.add("2");
		parameters.add("1");
		bucketFill.paint(canvas, parameters, "o");
		Assert.assertEquals(Constants.DEFAULT_LINE_CHARACTER, canvas.getScreen().get(1).get(2));
		Assert.assertEquals(Constants.EMPTY_PIXEL_VALUE, canvas.getScreen().get(1).get(1));
		Assert.assertEquals(Constants.EMPTY_PIXEL_VALUE, canvas.getScreen().get(2).get(1));
		Assert.assertEquals(Constants.EMPTY_PIXEL_VALUE, canvas.getScreen().get(2).get(2));		
	}
	
	@Test
	public void testPaint_invalid() {
	
		try {
			Canvas canvas = new Canvas(2,2);
			List<String> parameters = Lists.newArrayList();
			parameters.add("3");
			parameters.add("3");
			bucketFill.paint(canvas, parameters, "o");
			fail("3,3 doesn't lies in Canvas");
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}


}
