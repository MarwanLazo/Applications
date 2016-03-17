package com.sprapp.jms;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.sprapp.interceptor.TestEJB;

public class InvoiceMDB implements MessageListener {

	@EJB(mappedName = "java.testEJB#com.sprapp.interceptor.TestEJB")
	private TestEJB	testEJB;

	private Integer	initialize	= 0;

	@PostConstruct
	private void init() {

		System.err.println("Test start");
	}

	@PreDestroy
	private void destroy() {
		System.err.println("Test");
	}

	@Override
	public void onMessage(Message message) {
		try {
			System.err.println(initialize);
			++initialize;
			testEJB.consumeJMS(((TextMessage) message).getText());
			System.out.println("Hello >>> test Done!");
		} catch (JMSException ex) {
			throw new RuntimeException(ex);
		}
	}

}
