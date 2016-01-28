package com.sprapp.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.convert.Converter;

import com.sprapp.service.TempTableService;

@SessionScoped
@ManagedBean
public class ConverterController implements Serializable {

	@ManagedProperty("#{tempTableService}")
	private TempTableService	tempTableService;

	private static final long	serialVersionUID	= 1L;

	public Converter getTempTableConverter() {
		return new TempTableConverter(tempTableService);
	}

	public void setTempTableService(TempTableService tempTableService) {
		this.tempTableService = tempTableService;
	}
}
