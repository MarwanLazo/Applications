package com.sprapp.ws.restful;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprapp.entity.TempTableEB;
import com.sprapp.springdata.TempTableRepositry;

@RestController
public class TempTableRESTController {

	@Inject
	private TempTableRepositry temp;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<TempTableEB> getAllTempTable() {
		// temp.findAll();
		return (List<TempTableEB>) temp.findAll();
	}
}
