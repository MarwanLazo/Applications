package com.sprapp.oval;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;


public class ValidIDCheck extends AbstractAnnotationCheck<ValidID> {

	private static final long	serialVersionUID	= 1L;

	@Override
	public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context, Validator validator) throws OValException {

		if (validatedObject == null) {
			return false;
		}
		return true;
	}

}
