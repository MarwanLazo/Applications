package com.app.ejb.decorator;

public class GreetingImpl implements Greeting {

	private static final long	serialVersionUID	= 1L;

	
	@Override
	public String greetVisitor(String name) {
		return "Hello ! " + (name);
	}

	

}
