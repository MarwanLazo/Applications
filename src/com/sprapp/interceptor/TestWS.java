package com.sprapp.interceptor;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "ws", serviceName = "LibraryService")
public class TestWS {

	@EJB
	private TestEJB testEJB;

	@WebMethod(operationName = "name")
	public String getName(String name) {
		return "Hello! "  /*testEJB.getName(name)*/;
	}

}
