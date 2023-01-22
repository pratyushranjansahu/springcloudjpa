package com.pratyushapps.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.pratyushapps.idgenerators.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
