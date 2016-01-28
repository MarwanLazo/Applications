package com.sprapp.controller;

import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sprapp.entity.TempTableEB;
import com.sprapp.springdata.TempTableRepositry;

@Controller
@RequestMapping(value = "/")
public class HelloWorldController {

//	@Inject
//	private ModelTest			model;

	@PersistenceContext(unitName = "sprTest")
	private EntityManager		em;

	@Inject
	private TempTableRepositry	repositry;

	@SuppressWarnings("unchecked")
	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		/*
		 * Connection conn = null; PreparedStatement prepared = null; ResultSet
		 * rSet = null; try { conn = dataSource.getConnection(); prepared =
		 * conn.prepareStatement(QUERY); rSet = prepared.executeQuery(); if
		 * (rSet.next()) { model.setName(rSet.getString("TEMP_NAME"));
		 * model.setEmail(rSet.getString("TEMP_EMAIL")); } } catch (SQLException
		 * e) { e.printStackTrace(); } finally { try { conn.close();
		 * prepared.close(); rSet.close(); } catch (SQLException e) {
		 * e.printStackTrace(); } }
		 */

		// Session session = model.getSession();

		Properties env = new Properties();
		env.put(Context.SECURITY_PRINCIPAL, "weblogic");
		env.put(Context.SECURITY_CREDENTIALS, "weblogic1");
		env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		env.put(Context.PROVIDER_URL, "t3://localhost:7007");

		try {
			InitialContext ctx = new InitialContext(env);
			System.out.println("---- connection ----->>>> "+ctx.lookup("ConnectionFactory_TEST").getClass().getCanonicalName());
			System.out.println("-----queue---->>>> "+ctx.lookup("queue_TEST").getClass().getCanonicalName());
//			JMSXAConnectionFactory
//			DestinationImpl
			
		} catch (NamingException e) {
			e.printStackTrace();
		}

		List<TempTableEB> temp = em.createQuery("SELECT t FROM TempTableEB t order by t.tempName asc ").getResultList();
		ModelAndView view = new ModelAndView("hellopage", "message", temp);
		view.addObject("model", "");
		return view;
	}

	@Transactional(transactionManager = "transactionManager")
	@RequestMapping("/submit")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		TempTableEB temp = new TempTableEB(name, email);
		em.merge(temp);
		em.flush();
		String message = "HELLO TEST";
		ModelAndView view = new ModelAndView("result", "message", message);
		return view;
	}

	// @Transactional(transactionManager = "transactionManager", propagation =
	// Propagation.REQUIRED)
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("item");
		// TempTableEB table = (TempTableEB) em.find(TempTableEB.class, name);
		// em.remove(table);
		TempTableEB table = repositry.findOne(name);
		repositry.delete(table);
		String message = "HELLO TEST";
		ModelAndView view = new ModelAndView("result", "message", message);
		return view;
	}

	public EntityManager getEm() {
		return em;
	}
}
