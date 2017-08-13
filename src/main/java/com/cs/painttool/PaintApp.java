package com.cs.painttool;

import java.util.List;
import com.cs.painttool.canvas.CommandFactory;
import com.cs.painttool.command.ICommand;
import com.cs.painttool.reader.ConsoleReader;
import com.cs.painttool.reader.IReader;
import com.cs.painttool.utils.ParametersGenerator;

/**
 * 
 * 
 * Main Class to execute Program
 * @author SONY
 *
 */
public class PaintApp {

	private IReader ireader;
	private CommandFactory commandFactory;
	
	public PaintApp() {
		
		ireader = new ConsoleReader();
		commandFactory = CommandFactory.getCommandFactory();
	}
	
	public void processInput() {
		
		System.out.println("##################################");
		System.out.println("####  Welcome to Paint Tool   ####");
		System.out.println("####         v1.0             ####");
		System.out.println("##################################");
	

		while(true) {
		 try {
				System.out.print("Please enter command : ");
				String command = ireader.readInput();
				List<String> parameters = ParametersGenerator.getParameters(command);
				String commandStr = parameters.get(0);
				parameters = parameters.subList(1, parameters.size());
				ICommand function = commandFactory.getCommand(commandStr);
				if (function != null) {
					function.execute(parameters);
				} else {
					System.out.println("unable to find command: " + commandStr);
				}
		    } catch (Exception e) {
			  System.out.println("Error: "+e.getMessage());
		  }
		}
	}
	
	public static void main(String args[]) {
		
		PaintApp paintApp = new PaintApp();
		paintApp.processInput();
	}
}
