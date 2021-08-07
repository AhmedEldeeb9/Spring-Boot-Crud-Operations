package com.EmployeeActivity.MyEmployee.dao;

import java.util.List;

import com.EmployeeActivity.MyEmployee.Entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
