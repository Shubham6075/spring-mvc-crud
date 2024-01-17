package com.example.RestCrud.service;

import com.example.RestCrud.dao.EmployeeRepository;
import com.example.RestCrud.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;

	// set up constructor injection
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
		employeeRepository = theEmployeeRepository;
	}
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;

		if(result.isPresent()){
			theEmployee = result.get();
		}else{
			// we don't find the id
			throw new RuntimeException("Did not find employee id - " +theId);
		}
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
}
