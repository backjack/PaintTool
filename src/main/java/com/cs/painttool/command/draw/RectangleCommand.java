package com.cs.painttool.command.draw;

import java.util.ArrayList;
import java.util.List;

import com.cs.painttool.canvas.CanvasManager;
import com.cs.painttool.canvas.ICanvas;
import com.cs.painttool.canvas.draw.DrawLine;
import com.cs.painttool.canvas.draw.IDrawable;
import com.cs.painttool.command.AbstractCommand;
import com.cs.painttool.validator.IValidator;
import com.cs.painttool.validator.parameters.ValidatorParameter;
import com.google.common.collect.Lists;

public class RectangleCommand extends AbstractCommand {

	private IDrawable drawLine;
	private CanvasManager canvasManager;
	private ValidatorParameter validatorParameter;
	
	public RectangleCommand(IValidator ivalidator, CanvasManager canvasManager) {
		
		super(ivalidator);
		this.canvasManager = canvasManager;
		drawLine = new DrawLine();
	}
	
	@Override
	protected void processCommand(List<String> parameters) throws Exception {
		
		ICanvas canvas = canvasManager.getCanvas();
		String x1 = parameters.get(0);
		String y1 = parameters.get(1);
		String x2 = parameters.get(2);
		String y2 = parameters.get(3);

		drawLine(canvas,getParameterList(x1,y1,x2,y1));
		drawLine(canvas,getParameterList(x2,y1,x2,y2));
		drawLine(canvas,getParameterList(x1,y2,x2,y2));
		drawLine(canvas,getParameterList(x1,y1,x1,y2));
		canvas.draw();
	}
   
	private void drawLine(ICanvas canvas,List<String> parameters) throws Exception {
		
		drawLine.draw(canvas, parameters, "x");
	}
	
	private List<String> getParameterList(String x1,String y1, String x2, String y2) {

		List<String> params = new ArrayList<String>();
		params.add(x1);
		params.add(y1);
		params.add(x2);
		params.add(y2);
		return params;
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
