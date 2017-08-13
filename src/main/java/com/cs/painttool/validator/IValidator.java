package com.cs.painttool.validator;

import java.util.List;

import com.cs.painttool.validator.parameters.ValidatorParameter;

public interface IValidator {

	public boolean validate(List<String> params, ValidatorParameter varPar) throws Exception;
}
