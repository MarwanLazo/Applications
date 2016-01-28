package com.sprapp.jsf.component;

import javax.el.MethodExpression;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;

public class UICustomButton extends UICommand {

	@Override
	public void setActionExpression(MethodExpression actionExpression) {
		FacesContext context = FacesContext.getCurrentInstance();
		actionExpression.getExpressionString();
		context.getApplication().evaluateExpressionGet(context, actionExpression.getExpressionString(), Object.class);
		context.getApplication().evaluateExpressionGet(context, actionExpression.getExpressionString(), Object.class);
		// super.setActionExpression(actionExpression);
	}

}
