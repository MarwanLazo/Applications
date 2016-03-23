package com.app.ejb.cdi;

import java.io.Serializable;

public interface BeanCDI extends Serializable {

	String greeting(String name);

}
