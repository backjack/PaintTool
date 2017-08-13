package com.cs.painttool.validator;

import java.util.List;

import com.cs.painttool.validator.parameters.ValidatorParameter;

public class CanvasValidator extends Validator {

	
	@Override
	public boolean validate(List<String> params,ValidatorParameter varPar) throws Exception {
		super.validate(params, varPar);
		int width = Integer.parseInt(params.get(0));
		int height = Integer.parseInt(params.get(1));
		if(width <0 || height <0) {
			throw new Exception("Canvas Height or Width cannot be zero");
		}
		return true;
	}

}
