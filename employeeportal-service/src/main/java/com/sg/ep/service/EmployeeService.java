/**
 * 
 */
package com.sg.ep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.ep.dao.IEmployeeDAO;

import io.swagger.model.Employee;

/**
 * 
 * @author Kailash
 *
 */
@Service
public class EmployeeService implements IEmployeeService {
	
	private static final String REQUIRED = "required";
	
	@Autowired
	IEmployeeDAO employeeDao;

	@Override
	public String registerEmployee(Employee employee) {
		if(!validateEmployee(employee)){
			return REQUIRED;
		} else {
			String status = employeeDao.registerEmployee(employee);
			return status;
		}
	}

	private boolean validateEmployee(Employee employee) {
		if (employee == null || employee.getEmployeeId() == 0 || employee.getFirstName() == null || employee.getDob() == null
				|| employee.getDepartment() == null) {
			return false;
		} else if (employee.getFirstName().isEmpty() || employee.getDob().isEmpty()
				|| employee.getDepartment().isEmpty()) {
			return false;
		} 
		
		return true;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}
	
	@Override
	public void deleteEmployees(Employee employee) {
		employeeDao.deleteEmployees(employee);
	}
	
	

}
