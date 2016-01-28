package com.sprapp.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Logging
public class EEInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object logMethodEntry(InvocationContext invocationContext) throws Exception {
		System.out.println(invocationContext.getMethod().getName() + " invoked.");
		return invocationContext.proceed();

	}
}
