package com.cs.painttool.command;

import java.util.List;

import com.cs.painttool.validator.IValidator;
import com.cs.painttool.validator.parameters.ValidatorParameter;

public abstract class AbstractCommand implements ICommand{

	
	private IValidator validator;
	
	public AbstractCommand(IValidator validator) {
		this.validator = validator;
	}
	
	public AbstractCommand() {

	}
	
	
	@Override
	public void execute(List<String> parameters) throws Exception {
		
		ValidatorParameter  validatorParameters = getValidatorParameter();
		if(validator !=null) {
            validator.validate(parameters,validatorParameters);
		}
        processCommand(parameters);
	}
	
	
	protected abstract void processCommand(List<String> parameters) throws Exception;

	protected abstract ValidatorParameter getValidatorParameter();
}
