package com.aws.eureka.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/v1")
public class HelloController {

	@Autowired
	private Environment environment;
	
	@Value("${cloud.config.name}")
	private String configName;
	
	@GetMapping("/configName")
	public String getConfigServerDetails() {
		return environment.getProperty("cloud.config.name");
	}
	
	@GetMapping("/valueConfigName")
	public String valueConfigName() {
		return configName;
	}
}
