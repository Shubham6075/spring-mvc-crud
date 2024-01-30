package com.example.spring.mvc.crud.dao;

import com.example.spring.mvc.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	// no need to write code

	// no need of implementation class also

	// spring will provide automatic functions
	// findByAll() , findById() , save() , deleteById()
}
