package com.EmployeeActivity.MyEmployee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeActivity.MyEmployee.Entity.Employee;

@Repository
public class EmployeddDaoImpl implements EmployeeDao {
	private EntityManager entityManager;

	@Autowired
	public EmployeddDaoImpl(EntityManager theEntityManager) {

		this.entityManager = theEntityManager;
	}

	
	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> theEmployees = theQuery.getResultList();
		return theEmployees;

	}


	@Override
	public Employee findById(int theId) {
	    Session currentSession = entityManager.unwrap(Session.class);
        Employee theEmployee = currentSession.get(Employee.class, theId);
        return theEmployee;
	}


	@Override
	public void save(Employee theEmployee) {
	    Session currentSession = entityManager.unwrap(Session.class);
	    currentSession.saveOrUpdate(theEmployee);
	}


	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
	    theQuery.executeUpdate();
	}

}
