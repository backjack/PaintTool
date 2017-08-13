package com.cs.painttool.validator;

import java.util.List;

import com.cs.painttool.validator.parameters.ValidatorParameter;

public class Validator implements IValidator{

	@SuppressWarnings("rawtypes")
	@Override
	public boolean validate(List<String> params,ValidatorParameter varPar) throws Exception {
		
		if(varPar !=null) {
			int paramSize = varPar.getParamterSize();
			List<Class> paramTypes = varPar.getParameterTypes();
			if(params.size()< paramTypes.size()) {
				throw new Exception("Insufficent parameters for command. Minimum required is "+paramSize);
			}
			 
			for(int i =0;i < varPar.getParameterTypes().size(); i++) {
	
				String param = params.get(i);
				Class paramClass = paramTypes.get(i);
				try{
				  checkTypes(paramClass,param);
				}catch (NumberFormatException ex) {
					throw new Exception(param +" is not type of "+paramClass.getName());
				}
			}
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	private boolean checkTypes(Class c, String param) throws NumberFormatException{
		
		if(c.equals(Integer.class)) {
			Integer.parseInt(param);

		} else if(c.equals(Double.class)) {
			Double.parseDouble(param);
		} else if(c.equals(String.class)) {
			return true;
		}
		return false;
	}
	


}
