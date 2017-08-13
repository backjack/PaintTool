package com.cs.painttool.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader implements IReader {

	  private BufferedReader bufferedReader = null;
	  public ConsoleReader() {
		  
		  bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	  }
	
	@Override
	public String readInput() throws Exception {
		
		 String input = bufferedReader.readLine();
         return input;
	}

}
