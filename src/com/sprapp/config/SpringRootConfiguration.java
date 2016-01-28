package com.sprapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = { "/WEB-INF/applicationContext-servlet.xml" })
public class SpringRootConfiguration {
}
