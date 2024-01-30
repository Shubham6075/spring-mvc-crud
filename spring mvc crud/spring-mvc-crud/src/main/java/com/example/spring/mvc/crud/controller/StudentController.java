package com.example.spring.mvc.crud.controller;

import com.example.spring.mvc.crud.entity.Student;
import com.example.spring.mvc.crud.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;

	// constructor injection
	public StudentController(StudentService theStudentService){
		studentService = theStudentService;
	}

	// add mapping for("/list")
	@GetMapping("/list")
	public String listStudents(Model theModel){

		// get employee from db
		List<Student> theStudents = studentService.findAll();

		// add to spring model
		theModel.addAttribute("students",theStudents);

		return "students/list-students";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create the model attribute
		Student theStudent = new Student();

		// add to the Model
		theModel.addAttribute("student", theStudent);

		return "students/student-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel){

		// get the employee from service
		Student theStudent = studentService.findById(theId);

		// set the student as a model attribute
		theModel.addAttribute("student",theStudent);

		// send over to form
		return "students/student-form";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id, Model model){

		studentService.deleteById(id);

		return "redirect:/students/list";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student2") Student theStudent){

		// save the student
		studentService.save(theStudent);

		// use a redirect to prevent duplicates
		return "redirect:/students/list";
	}

}

