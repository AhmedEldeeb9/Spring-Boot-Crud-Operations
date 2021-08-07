package com.EmployeeActivity.MyEmployee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeActivity.MyEmployee.Entity.Employee;
import com.EmployeeActivity.MyEmployee.Service.EmployeeService;
import com.EmployeeActivity.MyEmployee.dao.EmployeeDao;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		this.employeeService = theEmployeeService;
	}


	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeService.findAll();
	}
	
	
	@GetMapping("/employees/{employeeId}")
	public Employee finById(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null) {
			
			throw new RuntimeException("Employee with id " + employeeId + " is not found !!");
		}
		
		return theEmployee;
		
		
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee thgEmployee) {
		thgEmployee.setId(0);
		employeeService.save(thgEmployee);
		
		return thgEmployee;
		
	}
	
	@PutMapping("/employees")
	public Employee updataEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		if(tempEmployee == null) {
			throw new RuntimeException("Employee with id " + employeeId + " is not found !!");
		}
		employeeService.deleteById(employeeId);
		return "Deleted Employee ID - " + employeeId;
	}
}
