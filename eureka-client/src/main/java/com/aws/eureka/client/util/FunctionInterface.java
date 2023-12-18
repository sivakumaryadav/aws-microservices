
package com.aws.eureka.client.util;

import java.util.List;
import java.util.stream.Collectors;

import com.aws.eureka.client.dto.EmployeeDTO;
import com.aws.eureka.client.entity.Employee;

public interface FunctionInterface {

	static EmployeeDTO entityToDto(Employee employee) {
		return EmployeeDTO.builder()
				.id(employee.getId())
				.firstName(employee.getFirstName())
				.lastName(employee.getLastName())
				.salary(employee.getSalary())
				.build();
	}
	
	static List<EmployeeDTO> entityListToDtos(List<Employee> employees) {
		return employees.stream().map(e -> entityToDto(e)).collect(Collectors.toList());
	}
	
	static Employee dtoToEntity(EmployeeDTO employeeDto) {
		return Employee.builder()
				.id(employeeDto.getId())
				.firstName(employeeDto.getFirstName())
				.lastName(employeeDto.getLastName())
				.salary(employeeDto.getSalary())
				.build();
	}
	
	static List<Employee> dtosToEntityList(List<EmployeeDTO> employeeDTOs) {
		return employeeDTOs.stream().map(e -> dtoToEntity(e)).collect(Collectors.toList());
	}

}
