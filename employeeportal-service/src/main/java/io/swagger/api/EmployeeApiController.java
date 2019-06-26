package io.swagger.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.sg.ep.service.IEmployeeService;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Employee;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-24T04:53:56.519Z")

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeApiController implements EmployeeApi {

	private static final String DUPLICATE = "duplicate";
	private static final String SUCCESS = "success";
	private static final String REQUIRED = "required";

	@Autowired
	IEmployeeService employeeService;

	public ResponseEntity<String> registerEmployee(
			@ApiParam(value = "Employee Details", required = true) @Valid @RequestBody Employee employee) {
		try {
			String status = employeeService.registerEmployee(employee);
			if (status.equalsIgnoreCase(SUCCESS)) {
				return new ResponseEntity<String>(String.valueOf(HttpStatus.OK), HttpStatus.OK);
			} else if (status.equalsIgnoreCase(DUPLICATE)) {
				return new ResponseEntity<String>(String.valueOf(HttpStatus.CONFLICT), HttpStatus.CONFLICT);
			} else if (status.equalsIgnoreCase(REQUIRED)) {
				return new ResponseEntity<String>(String.valueOf(HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
	}

}
