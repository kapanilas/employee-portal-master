/**
 * 
 */
package com.sg.ep.service;

import java.util.List;

import io.swagger.model.Employee;

/**
 * @author Kailash
 *
 */
public interface IEmployeeService {
	
	String registerEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	void deleteEmployees(Employee employee);
}
