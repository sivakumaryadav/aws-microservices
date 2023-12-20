package com.aws.eureka.feign.client.dto;

import java.io.Serializable;

import com.aws.eureka.feign.client.external.service.EmployeeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String location;
	private EmployeeDTO employeeDTO;
}
