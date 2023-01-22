package com.pratyushapps.idgenerators;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pratyushapps.idgenerators.entities.Employee;
import com.pratyushapps.idgenerators.repos.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class IdgeneratorsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	EmployeeRepository er;

	@Test
	public void testCreateEployee() {

		Employee employee = new Employee();
		employee.setName("John");		

		er.save(employee);
	}
}
