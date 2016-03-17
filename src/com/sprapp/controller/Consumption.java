package com.sprapp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
