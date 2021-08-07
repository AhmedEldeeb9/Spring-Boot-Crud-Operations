package com.EmployeeActivity.MyEmployee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeActivity.MyEmployee.Entity.Employee;
import com.EmployeeActivity.MyEmployee.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
    
    @Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImpl") EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Transactional
	public Employee findById(int theId) {
		return employeeDao.findById(theId);
	}

	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);;
	}

	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);
	}

}
