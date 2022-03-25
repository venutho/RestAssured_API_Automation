package com.sprintboot.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintboot.crud.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
