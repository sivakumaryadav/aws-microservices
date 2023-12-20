package com.aws.eureka.feign.client.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import feign.RequestLine;

//@FeignClient(name = "EUREKA-CLIENT-APP", url = "http://localhost:9081/employee")
@FeignClient(name = "${eureka-client.feign.config.name}", path = "/employee")//, url = "${spring.cloud.openfeign.client.config.url}")
public interface EmployeeService {

	@GetMapping("/findAllEmployees")
	public ResponseEntity<List<EmployeeDTO>> findAllEmployees();
	
	@GetMapping("/findEmployee/{employeeId}")
	//@RequestLine("GET")
	public EmployeeDTO findEmployee(@PathVariable long employeeId);
	
}
