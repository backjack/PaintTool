package com.cs.painttool.canvas;

import java.util.List;
import java.util.Map;

/**
 * Interface of Canvas 
 * @author SONY
 *
 */
public interface ICanvas {

	void draw();

	void clear();

	Map<Integer, List<String>> getScreen();

	boolean validatePixel(Integer x, Integer y);

	String getRowBoundarySymbol();

	String getColumnBoundarySymbol();
}
