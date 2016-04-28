package com.sprapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = { "/WEB-INF/applicationContext-servlet.xml" })
@Import(value = { LoginSecurityConfig.class })
public class SpringRootConfiguration {
}
