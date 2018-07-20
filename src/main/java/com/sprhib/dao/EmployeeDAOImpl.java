package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEmployee(Employee employee) {
		getCurrentSession().save(employee);
	}

	public void updateEmployee(Employee employee) {
		Employee employeeToUpdate = getEmployee(employee.getId());
		employeeToUpdate.setNu_badge(employee.getNu_badge());
		employeeToUpdate.setFirst_name(employee.getFirst_name());
		employeeToUpdate.setLast_name(employee.getLast_name());
		employeeToUpdate.setStatus(employee.getStatus());
		getCurrentSession().update(employeeToUpdate);
		
	}

	public Employee getEmployee(int id_employee) {
		Employee employee = (Employee) getCurrentSession().get(Employee.class, id_employee);
		return employee;
	}

	public void deleteEmployee(int id_employee) {
		Employee employee = getEmployee(id_employee);
		if (employee != null)
			getCurrentSession().delete(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		return getCurrentSession().createQuery("from Employee order by 1").list() ;
	}

}
