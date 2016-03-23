package com.app.ejb.cdi;

public class BeanCDIImpl implements BeanCDI {

	private static final long serialVersionUID = 1L;

	@Override
	public String greeting(String name) {
		return "Hello ! " + name;
	}

}
