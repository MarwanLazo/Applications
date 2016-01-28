package com.sprapp.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class InvoiceQueueSenderImpl implements MessageCreator, InvoiceQueueSender {

	private JmsTemplate			jmsTemplate;
	protected String			textMessage;
	private final static String	QUEUE_NAME	= "queue_TEST";

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public void sendMesage(String textMessage) {
		this.textMessage = textMessage;
		jmsTemplate.send(QUEUE_NAME, this);
	}

	@Override
	public Message createMessage(Session session) throws JMSException {
		TextMessage textMSG = session.createTextMessage();
		textMSG.setText(textMessage);
		return textMSG;
	}

}
