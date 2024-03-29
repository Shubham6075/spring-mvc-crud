package com.example.RestCrud.dao;

import com.example.RestCrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	// that's it... no need to write any code
	// no need of implementation class

	// get these methods for free - findByAll(), findById(), save(), deleteById(), others....

	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
