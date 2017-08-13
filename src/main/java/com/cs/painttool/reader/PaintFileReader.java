package com.cs.painttool.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * Below class to read input from File
 * 
 * @author SONY
 *
 */
public class PaintFileReader implements IReader{

	private BufferedReader bufferedReader;
	
	public PaintFileReader(String path) {
		
		File f = new File(path);
		try {
			FileReader fr = new FileReader(f);
			 bufferedReader = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void readFile() {
		
		List<String> inputList = new LinkedList<String>();
		String input = null;
		try {
			while((input=bufferedReader.readLine())!=null) {
				
				inputList.add(input);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public String readInput() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
