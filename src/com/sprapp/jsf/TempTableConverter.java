package com.sprapp.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sprapp.dto.TempTableDTO;
import com.sprapp.service.TempTableService;

@FacesConverter(value = "tempTableConverter")
public class TempTableConverter implements Converter {
	private TempTableService service;

	public TempTableConverter(TempTableService service) {
		this.service = service;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return service.findTempTableById(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return null;
		return ((TempTableDTO) value).getTempName();
	}

}
