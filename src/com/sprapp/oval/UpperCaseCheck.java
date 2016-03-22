package com.sprapp.oval;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

public class UpperCaseCheck extends AbstractAnnotationCheck<UpperCase> {

	private static final long serialVersionUID = 1L;

	public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context, Validator validator) {
		if (valueToValidate == null)
			return true;
		// String val = valueToValidate.toString();
		// return val.equals(val.toUpperCase());
		return true;
	}
}