package com.sprapp.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.sprapp.dto.TempTableDTO;
import com.sprapp.entity.TempTableEB;
import com.sprapp.interceptor.TestEJB;
import com.sprapp.mapping.FactoryMapper;
import com.sprapp.springdata.TempTableRepositry;

@Service(value = "tempTableService")
public class TempTableServiceImpl implements TempTableService {

	private static final long	serialVersionUID	= 1L;

	@Resource
	private TempTableRepositry	repositry;

	@Resource
	private FactoryMapper<?, ?>	factoryMapper;
	
	@PersistenceContext
	private EntityManager em;

	@EJB(mappedName = "java.testEJB#com.sprapp.interceptor.TestEJB")
	private TestEJB				testEJB;

	@PostConstruct
	private void init() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TempTableDTO> findAllTempTable() {
		return (List<TempTableDTO>) factoryMapper.mapAsList(repositry.findAllTemps(), TempTableDTO.class);
	}

	@Override
	public TempTableDTO createTempTable(TempTableDTO dto) {
		TempTableEB tempEB = (TempTableEB) factoryMapper.mapAsObject(dto, TempTableEB.class);
		return (TempTableDTO) factoryMapper.mapAsObject(repositry.save(tempEB), dto.getClass());
	}

	@Override
	public TempTableDTO updateTempTable(TempTableDTO dto) {
		TempTableEB tempEB = (TempTableEB) factoryMapper.mapAsObject(dto, TempTableEB.class);
		return (TempTableDTO) factoryMapper.mapAsObject(repositry.save(tempEB), dto.getClass());
	}

	@Override
	public boolean deleteTempTable(TempTableDTO dto) {
		TempTableEB tempEB = (TempTableEB) factoryMapper.mapAsObject(dto, TempTableEB.class);
		try {
			repositry.delete(tempEB);
			return true;
		} catch (Exception exception) {
			return false;
		}

	}

	@Override
	public TempTableDTO findTempTableById(String tempName) {
		TempTableEB tempEB = repositry.findTempTableByTempName(tempName);
		return (TempTableDTO) factoryMapper.mapAsObject(tempEB, TempTableDTO.class);
	}

	public TestEJB instanceTestEJB() {
		return testEJB;
	}

	public EntityManager getEm() {
		return em;
	}

}
