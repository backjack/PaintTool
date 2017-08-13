package com.cs.painttool.canvas.draw;

import java.util.List;

import com.cs.painttool.canvas.ICanvas;

public interface IDrawable {
	
	void draw(ICanvas canvas, List<String> parameters, String character) throws Exception;
}
