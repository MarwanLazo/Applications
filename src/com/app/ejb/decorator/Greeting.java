package com.app.ejb.decorator;

import java.io.Serializable;

public interface Greeting extends Serializable {
	String greetVisitor(String name);

}
