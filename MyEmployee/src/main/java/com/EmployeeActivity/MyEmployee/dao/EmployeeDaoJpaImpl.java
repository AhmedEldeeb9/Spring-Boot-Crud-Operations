package com.EmployeeActivity.MyEmployee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EmployeeActivity.MyEmployee.Entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Override
	public List<Employee> findAll() {
		Query theQuery = entityManager.createQuery("from Employee");
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
         Employee theEmployee = entityManager.find(Employee.class, theId);
         return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
         Employee employee = entityManager.merge(theEmployee);
         theEmployee.setId(employee.getId());
	}

	@Override
	public void deleteById(int theId) {
        Query theQuery = entityManager.createQuery(
        		"delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
	}

}
