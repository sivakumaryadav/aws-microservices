package com.aws.eureka.feign.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aws.eureka.feign.client.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
