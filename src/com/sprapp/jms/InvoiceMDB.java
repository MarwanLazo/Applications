package com.sprapp.jms;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.sprapp.interceptor.TestEJB;

public class InvoiceMDB implements MessageListener {

	@EJB(mappedName = "java.testEJB#com.sprapp.interceptor.TestEJB")
	private TestEJB testEJB;

	@Override
	public void onMessage(Message message) {
		try {
			testEJB.consumeJMS(((TextMessage) message).getText());
			System.out.println("Hello >>> test Done!");
		} catch (JMSException ex) {
			throw new RuntimeException(ex);
		}
	}

}
