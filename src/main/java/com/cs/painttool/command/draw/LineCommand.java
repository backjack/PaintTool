package com.cs.painttool.command.draw;

import java.util.List;

import com.cs.painttool.canvas.CanvasManager;
import com.cs.painttool.canvas.ICanvas;
import com.cs.painttool.canvas.draw.DrawLine;
import com.cs.painttool.canvas.draw.IDrawable;
import com.cs.painttool.command.AbstractCommand;
import com.cs.painttool.validator.IValidator;
import com.cs.painttool.validator.parameters.ValidatorParameter;
import com.google.common.collect.Lists;

public class LineCommand extends AbstractCommand {

	private CanvasManager canvasManager;
	
	private IDrawable drawLine;	
	
	private ValidatorParameter validatorParameter;

	public LineCommand(IValidator ivalidator,CanvasManager canvasManager){

		super(ivalidator);
		this.canvasManager = canvasManager;
		drawLine = new DrawLine();
		
	}
	

	@Override
	protected void processCommand(List<String> parameters) throws Exception {
		
		ICanvas canvas = canvasManager.getCanvas();
		String drawCharacter = "x";
		drawLine.draw(canvas,parameters,drawCharacter);
		canvas.draw();
	}


	@Override
	protected ValidatorParameter getValidatorParameter() {

		if(validatorParameter == null) {
			List<Class> parameterTypes = Lists.newArrayList();
			parameterTypes.add(Integer.class);
			parameterTypes.add(Integer.class);
			parameterTypes.add(Integer.class);
			parameterTypes.add(Integer.class);
			validatorParameter = new ValidatorParameter(parameterTypes);
		 }
		return validatorParameter;
	}
	
}
