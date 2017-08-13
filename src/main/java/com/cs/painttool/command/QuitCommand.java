package com.cs.painttool.command;

import java.util.List;

import com.cs.painttool.validator.parameters.ValidatorParameter;

public class QuitCommand extends AbstractCommand{

	
	@Override
	protected void processCommand(List<String> parameters) throws Exception {
		
		System.out.println("Thank you");
		System.exit(1);
	}

	@Override
	protected ValidatorParameter getValidatorParameter() {
		 return null;
	}

}
