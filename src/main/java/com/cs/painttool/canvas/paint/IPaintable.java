package com.cs.painttool.canvas.paint;

import java.util.List;

import com.cs.painttool.canvas.ICanvas;

public interface IPaintable {

	void paint(ICanvas canvas,List<String> params,String color) throws Exception;
	
}
