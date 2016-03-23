package com.app.ejb.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class GreetingDecorator implements Greeting {

	private static final long	serialVersionUID	= 1L;
	@Inject
	@Delegate
	@Any
	private Greeting			ticketService;

	public String greetVisitor(String name) {
		System.out.println(ticketService.greetVisitor(name));
		return (ticketService.greetVisitor(name)).toUpperCase() + "      >>>>>>>>>>> test DONE!";
	}


}
