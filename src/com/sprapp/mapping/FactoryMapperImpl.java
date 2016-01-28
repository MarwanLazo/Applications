package com.sprapp.mapping;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sprapp.dto.TempTableDTO;
import com.sprapp.service.TempTableService;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;

@Service
public class FactoryMapperImpl<S, D> implements FactoryMapper<S, D> {

	private static final long		serialVersionUID	= 1L;
	private static MapperFactory	mapperFactory;

	@Inject
	private TempTableService		tableService;

	@PostConstruct
	public void init() {

		mapperFactory = new DefaultMapperFactory.Builder().build();
		
		mapperFactory.getConverterFactory().registerConverter(new BidirectionalConverter<String, TempTableDTO>() {

			@Override
			public TempTableDTO convertTo(String source, Type<TempTableDTO> destinationType) {
				return tableService.findTempTableById(source);
			}

			@Override
			public String convertFrom(TempTableDTO source, Type<String> destinationType) {
				return source.getTempName();
			}
		});

	}

	public Object mapAsObject(Object object, Class<?> clazz) {
		return mapperFactory.getMapperFacade().map(object, clazz);
	}

	public List<?> mapAsList(List<?> objects, Class<?> clazz) {
		return mapperFactory.getMapperFacade().mapAsList(objects, clazz);
	}

}
