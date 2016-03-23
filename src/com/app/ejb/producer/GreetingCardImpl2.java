package com.app.ejb.producer;

public class GreetingCardImpl2 implements GreetingCard {
	@Override
	public String greetVisitor(String name) {
		return "Hi 2 ! " + name;
	}

}
