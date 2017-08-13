package com.cs.painttool.canvas.paint;

import java.util.List;
import java.util.Map;

import com.cs.painttool.canvas.ICanvas;
import com.cs.painttool.utils.Constants;

public class BucketFill implements IPaintable {

	@Override
	public void paint(ICanvas canvas, List<String> parameters, String color) throws Exception {
		
		
		Integer x = Integer.parseInt(parameters.get(0));
		Integer y = Integer.parseInt(parameters.get(1));

		if(canvas == null) {
			throw new Exception("Canvas doesn't exits. Kindly create it one");
		}
		
		if(!canvas.validatePixel(x, y)) {
			throw new Exception(x +","+y+" doesn't lies in Canvas");
		}
		
		Map<Integer,List<String>> screen  =canvas.getScreen();
		color = color.substring(0, 1);
		colorFill(screen,x,y,color);
		canvas.draw();
	}
	
	private void colorFill(Map<Integer,List<String>> screen, Integer x, Integer y, String color) {
		
		if(y >0 && y < screen.keySet().size()-1) {
			 List<String> row = screen.get(y);
			  if(x>0 && x<row.size()-1) {
				  String pixel = row.get(x);
				  if(color.equals(pixel)) {
					  return;
				  } else if(Constants.DEFAULT_LINE_CHARACTER.equals(pixel)){
					  return;
				  }else {
					  row.set(x,color);
					  colorFill(screen,x+1,y,color);
					  colorFill(screen,x-1,y,color);
					  colorFill(screen,x,y+1,color);
					  colorFill(screen,x,y-1,color);
				  }
			  }

		}
	}

}
