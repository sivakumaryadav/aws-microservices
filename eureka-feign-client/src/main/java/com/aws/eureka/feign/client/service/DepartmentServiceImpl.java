package com.aws.eureka.feign.client.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.eureka.feign.client.dto.DepartmentDTO;
import com.aws.eureka.feign.client.entity.Department;
import com.aws.eureka.feign.client.external.service.EmployeeDTO;
import com.aws.eureka.feign.client.external.service.EmployeeService;
import com.aws.eureka.feign.client.repository.DepartmentRepository;
import com.aws.eureka.feign.client.util.FunctionInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public List<DepartmentDTO> findAllDepartments() {
		List<Department> departments = repository.findAll();
		Function<List<Department>, List<DepartmentDTO>> departmentFunction = FunctionInterface::entityListToDtos;
		return departmentFunction.apply(departments);
	}

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
		Function<DepartmentDTO, Department> departmentFunction = FunctionInterface::dtoToEntity;
		Department department = repository.save(departmentFunction.apply(departmentDTO));
		log.info("Department saved Successfully. departmentId : {}", department.getId());
		departmentDTO.setId(department.getId());
		return departmentDTO;
	}

	@Override
	public DepartmentDTO getDepartment(Long departmentId, Long employeeId) {
		Optional<Department> department = repository.findById(departmentId);
		Function<Department, DepartmentDTO> departmentFunction = FunctionInterface::entityToDto;
		DepartmentDTO departmentDTO = departmentFunction.apply(department.get());
		EmployeeDTO employeeDTO = employeeService.findEmployee(employeeId);
		departmentDTO.setEmployeeDTO(employeeDTO);
		return departmentDTO;
	}

}
