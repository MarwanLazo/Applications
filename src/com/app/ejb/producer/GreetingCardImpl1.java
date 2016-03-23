package com.app.ejb.producer;

public class GreetingCardImpl1 implements GreetingCard {

	@Override
	public String greetVisitor(String name) {
		return "Hello 1 ! " + name;
	}

}
