package com.sprapp.ws.soap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.sprapp.entity.TempTableEB;

@Component
@WebService(name = "ws", serviceName = "TestService")
public class HelloWorldWS extends SpringBeanAutowiringSupport {

	private RestTemplate template;

	@PostConstruct
	public void init() {
		template = new RestTemplate();
	}

	@WebMethod(operationName = "helloWorld")
	public List<TempTableEB> getHelloWorld(String tempName) {
		List<TempTableEB> list = new ArrayList<TempTableEB>();
		@SuppressWarnings("unchecked")
		List<Map<String, String>> tempss = template.getForObject("http://localhost:7007/sprTest/rest/employees", List.class);
		for (Map<String, String> map : tempss) {
			list.add(new TempTableEB(map.get("tempName"), map.get("tempEmail")));
		}
		return list;
	}

}
