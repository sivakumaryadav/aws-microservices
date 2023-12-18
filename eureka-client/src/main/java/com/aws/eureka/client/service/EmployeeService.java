package com.aws.eureka.client.service;

import java.util.List;

import com.aws.eureka.client.dto.EmployeeDTO;

public interface EmployeeService {

	public List<EmployeeDTO> findAllEmployees();
	
	public EmployeeDTO saveEmployee(EmployeeDTO employee);
	
	public EmployeeDTO getEmployee(long employeeId);
	
	public String deleteEmployee(long employeeId);
	
}
