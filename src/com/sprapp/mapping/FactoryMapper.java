package com.sprapp.mapping;

import java.io.Serializable;
import java.util.List;

public interface FactoryMapper<S, T> extends Serializable {
	

	Object mapAsObject(Object object, Class<?> clazz);

	List<?> mapAsList(List<?> objects, Class<?> clazz);

}
