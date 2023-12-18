package com.aws.eureka.client.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.eureka.client.dao.EmployeeRepository;
import com.aws.eureka.client.dto.EmployeeDTO;
import com.aws.eureka.client.entity.Employee;
import com.aws.eureka.client.util.FunctionInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeDTO> findAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		log.info("Employee records count : {}", employees.size());
		Function<List<Employee>, List<EmployeeDTO>> employeeList = FunctionInterface::entityListToDtos;
		return employeeList.apply(employees);
	}

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		Function<EmployeeDTO, Employee> employeeFunction = FunctionInterface::dtoToEntity;
		Employee resultEmployee = employeeRepository.save(employeeFunction.apply(employeeDTO));
		log.info("Employee record saved Successfully and Id : {}", resultEmployee.getId());
		employeeDTO.setId(resultEmployee.getId());
		return employeeDTO;
	}

	@Override
	public EmployeeDTO getEmployee(long employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		Function<Employee, EmployeeDTO> employeeFunction = FunctionInterface::entityToDto;
		return employeeFunction.apply(employee.get());
	}

	@Override
	public String deleteEmployee(long employeeId) {
		return null;
	}

}
