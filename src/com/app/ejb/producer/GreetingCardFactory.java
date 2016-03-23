package com.app.ejb.producer;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.app.ejb.cdi.CustomQualifier;
import com.app.ejb.cdi.EnumType;

@ApplicationScoped
public class GreetingCardFactory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Produces
	@CustomQualifier(getType = EnumType.MAIN)
	public GreetingCard getGreetingCard() {
		return new GreetingCardImpl1();
	}

	@Produces
	@CustomQualifier(getType = EnumType.TEMP)
	public GreetingCard getAnotherGreetingCard() {
		return new GreetingCardImpl2();
	}

}
