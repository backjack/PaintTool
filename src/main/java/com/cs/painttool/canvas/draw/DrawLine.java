package com.cs.painttool.canvas.draw;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import com.cs.painttool.canvas.ICanvas;

public class DrawLine implements IDrawable {

	
	@Override
	public void draw(ICanvas canvas, List<String> parameters, String character) throws Exception {
		
		int x1 = Integer.parseInt(parameters.get(0));
		int y1 = Integer.parseInt(parameters.get(1));
		int x2 = Integer.parseInt(parameters.get(2));
		int y2 = Integer.parseInt(parameters.get(3));

		if(canvas == null) {
			throw new Exception("Canvas doesn't exits. Kindly create it one");
		}
		
		if(!validate(canvas,x1,y1,x2,y2)) {
			throw new Exception("One of the point doesn't lines in Canvas");
		}
		
		Map<Integer,List<String>> screen  =canvas.getScreen();
		
		if((y1 == y2)) {
			
			int start = NumberUtils.min(x1,x2);
			int end = NumberUtils.max(x1,x2);
			List<String> pixelRow = screen.get(y1);
			for(int i =start;i<=end;i++) {
				pixelRow.set(i, character);
			}
		
		} else if(x1 == x2) {
			
			int start = NumberUtils.min(y1,y2);
			int end = NumberUtils.max(y1,y2);
			for(int i=start;i<=end;i++) {
				
				List<String> pixelRow = screen.get(i);
				pixelRow.set(x1,character);
			}
		} else {
			throw new Exception("It is basic version, hence only Horizontal or Vertical Line can be drawn");
		}
		
	}
	
	private boolean validate(ICanvas canvas, int x1, int y1, int x2, int y2){
		
		return (canvas.validatePixel(x1, y1) && canvas.validatePixel(x2, y2));
		
	}

}
