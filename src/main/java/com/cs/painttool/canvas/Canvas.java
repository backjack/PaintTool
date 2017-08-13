package com.cs.painttool.canvas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cs.painttool.utils.Constants;

/**
 * 
 * Canvas class to draw and paint objects
 * @author SONY
 *
 */
public class Canvas implements ICanvas {

	private Map<Integer,List<String>> screen;
	
	private int height;
	
	private int width;
	
	private String rowBoundarySymbol;
	
	private String columnBoundaySymbol;
	
	
	public Map<Integer, List<String>> getScreen() {
		return screen;
	}

	public void setScreen(Map<Integer, List<String>> screen) {
		this.screen = screen;
	}

	public Canvas(int height, int width,String rowBoundarySymbol, String columnBoundaySymbol) {
		
		this.height = height+2;
		this.width = width +2;
		this.rowBoundarySymbol = rowBoundarySymbol;
		this.columnBoundaySymbol = columnBoundaySymbol;
		screen = new HashMap<Integer,List<String>>();
	
		for(int rowCount = 0;rowCount<this.height;rowCount++) {
			 
			String[] row = new String[this.width]; 
			
			if(rowCount ==0 || rowCount == this.height-1) {
			   Arrays.fill(row, rowBoundarySymbol);
			} else {
			    Arrays.fill(row, Constants.EMPTY_PIXEL_VALUE);
			    row [0] = columnBoundaySymbol;
			    row[this.width-1]= columnBoundaySymbol;
			}
			
			List<String> filledRow = Arrays.asList(row);
			screen.put(rowCount,filledRow);
		}
	}
	
	 public Canvas(int height, int width) {
		
		this(height,width,Constants.DEFAULT_ROW_BORDER,Constants.DEFAULT_COLUMN_BORDER);
	 }
	
	
	 public int getHeight() {
		return height-2;
	 }

	 public void setHeight(int height) {
		this.height = height+2;
	 }

	public int getWidth() {
		return width-2;
	}

	public void setWidth(int width) {
		this.width = width+2;
	}

	@Override
	public void draw() {
	
		Set<Integer> rowSet = this.screen.keySet();
		for(Integer row:rowSet) {
			List<String> pixels = screen.get(row);
			for(String pixel:pixels) {
				System.out.print(pixel);
			}
			System.out.println("");
		}
		
	}

	@Override
	public void clear() {
		
		Set<Integer> rowSet = this.screen.keySet();
		for(Integer row:rowSet) {
			if(row!=0 || row != rowSet.size()-1) {
				List<String> pixels = screen.get(row);
				for(int i=1;i< pixels.size()-1;i++) {
					pixels.set(i,Constants.EMPTY_PIXEL_VALUE);
				}
			}
		}
		
	}

	@Override
	public boolean validatePixel(Integer x, Integer y) {
		
		if(y > 0 && y < this.height-1) {
			List<String> row = screen.get(y);
			if(x>0 && x <row.size()-1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getRowBoundarySymbol() {

		return rowBoundarySymbol;
	}

	@Override
	public String getColumnBoundarySymbol() {

		return columnBoundaySymbol;
	}

}
