package com.example.spring.mvc.crud.service;

import com.example.spring.mvc.crud.dao.StudentRepository;
import com.example.spring.mvc.crud.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;

	// set up constructor injection
	public StudentServiceImpl(StudentRepository theStudentRepository){
		studentRepository = theStudentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);

		Student theStudent = null;

		if(result.isPresent()){
			theStudent = result.get();
		}else{
			// don't find the id
			throw new RuntimeException("Did not find the student id - " +theId);
		}
		return theStudent;
	}

	@Override
	public Student save(Student theStudent) {
		return studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {

		studentRepository.deleteById(theId);
	}
}
