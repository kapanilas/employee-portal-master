package io.swagger.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sg.ep.service.IEmployeeService;

import io.swagger.model.Employee;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-24T04:53:56.519Z")

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeesApiController implements EmployeesApi {

	@Autowired
	IEmployeeService employeeService;

	public ResponseEntity<List<Employee>> getAllEmployees() {
		try {
			List<Employee> employees = employeeService.getAllEmployees();
			if (employees != null) {
				return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Employee>>(employees, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
