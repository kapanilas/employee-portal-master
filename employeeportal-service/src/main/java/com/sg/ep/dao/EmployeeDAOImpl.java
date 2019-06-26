/**
 * 
 */
package com.sg.ep.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.swagger.model.Employee;

/**
 * @author Kailash
 *
 */
@Component
public class EmployeeDAOImpl implements IEmployeeDAO{
	
	private static final String DUPLICATE = "duplicate";
	private static final String SUCCESS = "success";
	
	List<Employee> employeeList = new ArrayList<Employee>();
	
	Map<Integer, String> employeesMap = new HashMap<Integer, String>();
	
	@Override
	public String registerEmployee(Employee employee) {
		if(!isEmployeeExists(employee)){
			employeeList.add(employee);
			employeesMap.put(employee.getEmployeeId(), employee.getFirstName());
			return SUCCESS;
		} else {
			return DUPLICATE;
		}
	}

	private boolean isEmployeeExists(Employee employee) {
		if(employeesMap.containsKey(employee.getEmployeeId())) {
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		if(!employeeList.isEmpty()){
			return employeeList;
		}
		return null;
	}

	@Override
	public void deleteEmployees(Employee employee) {
		employeeList.remove(employee);
		employeesMap.remove(employee.getEmployeeId());
	}

	
}
