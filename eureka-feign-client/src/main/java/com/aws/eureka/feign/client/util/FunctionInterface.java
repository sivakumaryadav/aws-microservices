package com.aws.eureka.feign.client.util;

import java.util.List;
import java.util.stream.Collectors;

import com.aws.eureka.feign.client.dto.DepartmentDTO;
import com.aws.eureka.feign.client.entity.Department;

public interface FunctionInterface {

	static DepartmentDTO entityToDto(Department department) {
		return DepartmentDTO.builder()
				.id(department.getId())
				.name(department.getName())
				.location(department.getLocation())
				.build();
	}
	
	static List<DepartmentDTO> entityListToDtos(List<Department> Departments) {
		return Departments.stream().map(e -> entityToDto(e)).collect(Collectors.toList());
	}
	
	static Department dtoToEntity(DepartmentDTO departmentDTO) {
		return Department.builder()
				.id(departmentDTO.getId())
				.name(departmentDTO.getName())
				.location(departmentDTO.getLocation())
				.build();
	}
	
	static List<Department> dtosToEntityList(List<DepartmentDTO> DepartmentDTOs) {
		return DepartmentDTOs.stream().map(e -> dtoToEntity(e)).collect(Collectors.toList());
	}
}
