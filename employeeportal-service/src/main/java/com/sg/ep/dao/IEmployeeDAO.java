package com.sg.ep.dao;

import java.util.List;

import io.swagger.model.Employee;

public interface IEmployeeDAO {
	String registerEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	void deleteEmployees(Employee employee);
}
