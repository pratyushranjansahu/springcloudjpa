package com.pratyushapps.componentmapping.repos;

import org.springframework.data.repository.CrudRepository;

import com.pratyushapps.componentmapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
