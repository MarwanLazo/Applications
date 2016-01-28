package com.sprapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sprapp.springdata.TempTableRepositry;

@Controller
public class SpringDataController {

	@Autowired
	private TempTableRepositry repositry;

	@RequestMapping("/temp")
	public ModelAndView Tesmp() {
		ModelAndView view = new ModelAndView("temp", "rep", repositry.findAllTemps("Osama"));
		return view;
	}

}
