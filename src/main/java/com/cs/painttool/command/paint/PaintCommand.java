package com.cs.painttool.command.paint;

import java.util.List;

import com.cs.painttool.canvas.CanvasManager;
import com.cs.painttool.canvas.ICanvas;
import com.cs.painttool.canvas.paint.BucketFill;
import com.cs.painttool.canvas.paint.IPaintable;
import com.cs.painttool.command.AbstractCommand;
import com.cs.painttool.validator.IValidator;
import com.cs.painttool.validator.parameters.ValidatorParameter;
import com.google.common.collect.Lists;

public class PaintCommand extends AbstractCommand{
	
	private IPaintable paintable;
	private CanvasManager canvasManager;
	private ValidatorParameter validatorParameter;
	
	@SuppressWarnings("rawtypes")
	public PaintCommand(IValidator ivalidator,CanvasManager canvasManager) {
		
		super(ivalidator);
		this.paintable = new BucketFill();
		this.canvasManager = canvasManager;
		List<Class> parameterTypes = Lists.newArrayList();
		parameterTypes.add(Integer.class);
		parameterTypes.add(Integer.class);
		parameterTypes.add(String.class);
		validatorParameter = new ValidatorParameter(parameterTypes);
	}
	
	@Override
	protected void processCommand(List<String> parameters) throws Exception {
		
		ICanvas canvas = canvasManager.getCanvas();
		paintable.paint(canvas, parameters, parameters.get(parameters.size()-1));
	}

	@Override
	protected ValidatorParameter getValidatorParameter() {
		return validatorParameter;
	}

	
}
