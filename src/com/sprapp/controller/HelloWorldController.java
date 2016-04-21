package com.sprapp.controller;

import java.util.List;

import javax.inject.Inject;
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

	// @Inject
	// private ModelTest model;

	@PersistenceContext(unitName = "sprTest")
	private EntityManager		em;

	@Inject
	private TempTableRepositry	repositry;

	@SuppressWarnings("unchecked")
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		List<TempTableEB> temp = em.createQuery("SELECT t FROM TempTableEB t order by t.tempName asc ").getResultList();
		ModelAndView view = new ModelAndView("hellopage", "message", temp);
//		System.out.println(request.getUserPrincipal().getName());
		view.addObject("model", "");
		return view;
	}
	

	
	@SuppressWarnings("unchecked")
	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
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
//		System.out.println(request.getUserPrincipal().getName());
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
