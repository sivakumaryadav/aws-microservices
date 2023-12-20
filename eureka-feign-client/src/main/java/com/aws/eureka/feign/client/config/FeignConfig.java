package com.aws.eureka.feign.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aws.eureka.feign.client.exception.FeignErrorDecoder;

@Configuration
public class FeignConfig {

	@Bean
	public FeignErrorDecoder errorDecoder() {
		return new FeignErrorDecoder();
	}
	
	
}
