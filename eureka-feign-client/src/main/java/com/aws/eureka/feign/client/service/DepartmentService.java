package com.aws.eureka.feign.client.service;

import java.util.List;

import com.aws.eureka.feign.client.dto.DepartmentDTO;

public interface DepartmentService {

	public List<DepartmentDTO> findAllDepartments();
	
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
	
	public DepartmentDTO getDepartment(Long departmentId, Long employeeId);
	
}
