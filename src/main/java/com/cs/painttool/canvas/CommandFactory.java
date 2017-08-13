package com.cs.painttool.canvas;

import java.util.HashMap;
import java.util.Map;

import com.cs.painttool.command.CanvasCommand;
import com.cs.painttool.command.ICommand;
import com.cs.painttool.command.QuitCommand;
import com.cs.painttool.command.draw.LineCommand;
import com.cs.painttool.command.draw.RectangleCommand;
import com.cs.painttool.command.paint.PaintCommand;
import com.cs.painttool.validator.IValidator;
import com.cs.painttool.validator.factory.ValidatorFactory;
import static com.cs.painttool.utils.Constants.CANVAS_COMMAND;
import static com.cs.painttool.utils.Constants.LINE_COMMAND;
import static com.cs.painttool.utils.Constants.RECTANGLE_COMMAND;
import static com.cs.painttool.utils.Constants.PAINT_COMMAND;
import static com.cs.painttool.utils.Constants.QUIT_COMMAND;

public class CommandFactory {
	
	private Map<String,ICommand> commandMap;
	private CanvasManager canvasManager;
	private static ValidatorFactory validatorFactory;
	
	private static CommandFactory commandFactory;
	
	private  CommandFactory() {
		
		commandMap = new HashMap<String,ICommand>();
		canvasManager = new CanvasManager();
		validatorFactory = ValidatorFactory.getValidatorFactory();

	}
	
	public static CommandFactory getCommandFactory() {
		
		if(commandFactory==null) {
			commandFactory = new CommandFactory();
		}
		return commandFactory;
	}
	
	public ICommand getCommand(String commandType) {
		
		ICommand command = null;
		
		switch(commandType) {
		       
		    case CANVAS_COMMAND :   
		    			command = commandMap.get(commandType);
		    			if(command == null) {
		    				
		    			  IValidator validator = validatorFactory.getValidator(commandType);
		    			  command = new CanvasCommand(validator,canvasManager);
		    			  commandMap.put("C", command);
		    			}
		    			break;
		    			
		    case LINE_COMMAND :   command = commandMap.get(commandType);
		    	         if(command == null) {
		    	           IValidator validator = validatorFactory.getValidator(commandType);
			 			   command = new LineCommand(validator,canvasManager);
			 			   commandMap.put("L", command);
			 			} 
			 			 break;	
			 			
		    case RECTANGLE_COMMAND :  command = commandMap.get(commandType);
		    			if(command == null) {
		    				 IValidator validator = validatorFactory.getValidator(commandType);
	 			             command = new RectangleCommand(validator,canvasManager);
	 			             commandMap.put(commandType, command);
	 					}
	 					break;	
	 					
		    case PAINT_COMMAND :  command = commandMap.get(commandType);
						if(command == null) {
							     IValidator validator = validatorFactory.getValidator(commandType);
					             command = new PaintCommand(validator,canvasManager);
					             commandMap.put(commandType, command);
						}
						break;
						
		    case QUIT_COMMAND :  command = commandMap.get(commandType);
						if(command == null) {
				             command = new QuitCommand();
				             commandMap.put(commandType, command);
						}
						break;
		    	

		}
		
		return command;
	}
	
	 
	
}
