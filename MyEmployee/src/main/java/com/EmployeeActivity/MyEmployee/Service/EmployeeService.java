package com.EmployeeActivity.MyEmployee.Service;

import java.util.List;

import com.EmployeeActivity.MyEmployee.Entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
