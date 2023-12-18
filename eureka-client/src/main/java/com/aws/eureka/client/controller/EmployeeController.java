package com.aws.eureka.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.eureka.client.dto.EmployeeDTO;
import com.aws.eureka.client.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/findAllEmployees")
	public ResponseEntity<List<EmployeeDTO>> findAllEmployees() {
		log.info("findAll method invoked.");
		List<EmployeeDTO> employees = employeeService.findAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	@PostMapping("/saveEmployee")
	public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		log.info("saveEmployee method invoked. Employee : {}", employeeDTO.toString());
		return employeeService.saveEmployee(employeeDTO);
	}
	
	@GetMapping("/findEmployee/{employeeId}")
	public EmployeeDTO findEmployee(@PathVariable long employeeId) {
		return employeeService.getEmployee(employeeId);
	}
}
