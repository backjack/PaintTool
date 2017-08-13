package com.cs.painttool.command;

import java.util.List;

import com.cs.painttool.canvas.Canvas;
import com.cs.painttool.canvas.CanvasManager;
import com.cs.painttool.canvas.ICanvas;
import com.cs.painttool.validator.IValidator;
import com.cs.painttool.validator.parameters.ValidatorParameter;
import com.google.common.collect.Lists;

public class CanvasCommand extends AbstractCommand{

	private CanvasManager canvasManager;
	
	private ValidatorParameter validatorParameter;
	
	public CanvasCommand(IValidator ivalidator,CanvasManager canvasManager) {
		
		super(ivalidator);
		this.canvasManager = canvasManager;
	}
	
	@Override
	public void processCommand(List<String> parameters) throws Exception {

		ICanvas canvas = canvasManager.getCanvas();
		if(canvas == null) {
			int height = Integer.parseInt(parameters.get(1));
			int width = Integer.parseInt(parameters.get(0));
			canvas = new Canvas(height,width);
			canvas.draw();
			canvasManager.setCanvas(canvas);
		} else {
			throw new Exception("Cannot create new Canvas, as it already exits");
		}
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected ValidatorParameter getValidatorParameter() {
		
		if(validatorParameter == null) {
			List<Class> parameterTypes = Lists.newArrayList();
			parameterTypes.add(Integer.class);
			parameterTypes.add(Integer.class);
			validatorParameter = new ValidatorParameter(parameterTypes);
		}
		return validatorParameter;
	}

}
