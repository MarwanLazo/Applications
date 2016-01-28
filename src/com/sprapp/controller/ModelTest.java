package com.sprapp.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ModelTest {

	@Inject
	private SessionFactory sessionFactory;
	private org.hibernate.Session session;

	@Value("W. W. Adam")
	private String name;
	@Value("ww@gmail.com")
	private String email;

	@PostConstruct
	private void init() {
		session = sessionFactory.openSession();
		System.err.println("-->> hibernate session opened");
	}

	@PreDestroy
	private void destroy() {
		session.close();
		System.err.println("-->> hibernate session closed");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public org.hibernate.Session getSession() {
		return session;
	}

}
