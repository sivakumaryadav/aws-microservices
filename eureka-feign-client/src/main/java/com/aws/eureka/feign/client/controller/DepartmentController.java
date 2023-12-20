package com.aws.eureka.feign.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.eureka.feign.client.dto.DepartmentDTO;
import com.aws.eureka.feign.client.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/findAllDepartments")
	public List<DepartmentDTO> findAllDepartments() {
		return departmentService.findAllDepartments();
	}
	
	@PostMapping("/saveDepartment")
	public DepartmentDTO saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
		return departmentService.saveDepartment(departmentDTO);
	}
	
	@GetMapping("/getDepartment/{departmentId}/{employeeId}")
	public DepartmentDTO getDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
		return departmentService.getDepartment(departmentId, employeeId);
	}
	
	
}
