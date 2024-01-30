package com.example.spring.mvc.crud.service;

import com.example.spring.mvc.crud.entity.Student;

import java.util.List;

public interface StudentService {

	List<Student> findAll();

	Student findById(int theId);

	Student save(Student theStudent);

	void deleteById(int theId);
}
