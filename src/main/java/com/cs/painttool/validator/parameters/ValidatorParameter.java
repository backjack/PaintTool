package com.cs.painttool.validator.parameters;

import java.util.Collections;
import java.util.List;

public class ValidatorParameter implements IValidatorParameter{

	private int parameterSize;
	
	private List<Class> paramtersTypes;

	public ValidatorParameter(List<Class> parametersTypes) {
		
		if(parametersTypes!=null) {
			this.parameterSize = parametersTypes.size();
			this.paramtersTypes = Collections.unmodifiableList(parametersTypes);
		}
	}

	@Override
	public List<Class> getParameterTypes() {
		// TODO Auto-generated method stub
		return paramtersTypes;
	}

	@Override
	public int getParamterSize() {
		// TODO Auto-generated method stub
		return parameterSize;
	}
	
}
