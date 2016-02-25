package com.sprapp.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sprapp.dto.TempTableDTO;

@Service("callRestWS")
public class CallRestWSImpl implements CallRestWS {

	private static final String REST_SERVICE_URI = "http://localhost:7007/sprTest/rest";

	public void createUser(TempTableDTO temp) {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		if (temp == null)
			temp = new TempTableDTO("Ronald", "ronald@temp.com");
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/empAdd/", temp, TempTableDTO.class);
		System.out.println("Location : " + uri.toASCIIString());
	}
}
