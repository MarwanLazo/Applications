package com.sprapp.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprapp.dto.TempTableDTO;
import com.sprapp.service.TempTableService;

@Service("consumption")
public class Consumption {

	@Inject
	private TempTableService tableService;

//	@RequestMapping(method = RequestMethod.GET, value = "/rest/employees")
//	@ResponseBody
//	public List<TempTableDTO> findById() {
//		return tableService.findAllTempTable();
//	}
}
