package com.example.RestCrud.controller;

import com.example.RestCrud.entity.Employee;
import com.example.RestCrud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService){
		employeeService = theEmployeeService;
	}

	// add mapping for the ("/list")
	@GetMapping("/list")
	public String listEmployees(Model theModel){

		// get the employee from db
		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees",theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){

		// create model attribute
		Employee theEmployee = new Employee();

		// add to the model
		theModel.addAttribute("employee",theEmployee);

		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);

		// set the employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee",theEmployee);

		// send over to the form
		return "employees/employee-form";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id, Model model) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}


	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

		// save the employee
		employeeService.save(theEmployee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
}
