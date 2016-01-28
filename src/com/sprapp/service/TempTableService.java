package com.sprapp.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.sprapp.dto.TempTableDTO;
import com.sprapp.interceptor.TestEJB;

public interface TempTableService extends Serializable {
	List<TempTableDTO> findAllTempTable();

	TempTableDTO createTempTable(TempTableDTO dto);

	TempTableDTO updateTempTable(TempTableDTO dto);

	boolean deleteTempTable(TempTableDTO dto);

	TempTableDTO findTempTableById(String tempName);

	TestEJB instanceTestEJB();

	EntityManager getEm();
}
