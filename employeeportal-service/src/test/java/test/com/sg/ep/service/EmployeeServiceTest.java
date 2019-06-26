package test.com.sg.ep.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sg.ep.dao.EmployeeDAOImpl;
import com.sg.ep.dao.IEmployeeDAO;
import com.sg.ep.service.EmployeeService;
import com.sg.ep.service.IEmployeeService;

import io.swagger.model.Employee;


@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
	
	private static final String REQUIRED = "required";
	private static final String SUCCESS = "success";
	private static final String DUPLICATE = "duplicate";
	
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public IEmployeeService employeeService() {
            return new EmployeeService();
        }
        
        @Bean
        public IEmployeeDAO employeeServiceDAO() {
            return new EmployeeDAOImpl();
        }
    }
	
	@Autowired
	IEmployeeService employeeService;
	
	@Test
	public void testRegisterEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeId(1235);
		employee.setFirstName("abc");
		employee.setLastName("xyz");
		employee.setDob("14-09-1999");
		employee.setGender("Male");
		employee.setDepartment("Engg");
		String status = employeeService.registerEmployee(employee);
		assertEquals(SUCCESS,status);
		employeeService.deleteEmployees(employee);
	}
	
	@Test
	public void testDuplicateEntryForRegisterEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeId(1234);
		employee.setFirstName("abc");
		employee.setLastName("xyz");
		employee.setDob("14-09-1999");
		employee.setGender("Male");
		employee.setDepartment("Engg");
		employeeService.registerEmployee(employee);
		
		Employee employee1 = new Employee();
		employee1.setEmployeeId(1234);
		employee1.setFirstName("abc");
		employee1.setLastName("xyz");
		employee1.setDob("14-09-1999");
		employee1.setGender("Male");
		employee1.setDepartment("Engg");
		String status = employeeService.registerEmployee(employee1);
		assertEquals(DUPLICATE,status);
		employeeService.deleteEmployees(employee);
	}
	
	@Test
	public void testEmployeeNull() {
		Employee employee = null;
		String status = employeeService.registerEmployee(employee);
		assertEquals(REQUIRED, status);
	}
	
	@Test
	public void testEmployeeIdNullAndEmpty() {
		Employee employee1 = new Employee();
		employee1.setFirstName("abc");
		employee1.setLastName("xyz");
		employee1.setDob("14-09-1999");
		employee1.setGender("Male");
		employee1.setDepartment("Engg");
		String status1 = employeeService.registerEmployee(employee1);
		assertEquals(REQUIRED, status1);		
	}
	
	@Test
	public void testEmployeeFirstNameNullAndEmpty() {
		Employee employee1 = new Employee();
		employee1.setEmployeeId(1234);
		employee1.setFirstName(null);
		employee1.setLastName("xyz");
		employee1.setDob("14-09-1999");
		employee1.setGender("Male");
		employee1.setDepartment("Engg");
		String status1 = employeeService.registerEmployee(employee1);
		assertEquals(REQUIRED, status1);
		
		Employee employee2 = new Employee();
		employee2.setEmployeeId(1234);
		employee2.setFirstName("");
		employee2.setLastName("xyz");
		employee2.setDob("14-09-1999");
		employee2.setGender("Male");
		employee2.setDepartment("Engg");
		String status2 = employeeService.registerEmployee(employee1);
		assertEquals(REQUIRED, status2);
	}
	
	@Test
	public void testEmployeeDobNullAndEmpty() {
		Employee employee1 = new Employee();
		employee1.setEmployeeId(1234);
		employee1.setFirstName("abc");
		employee1.setLastName("xyz");
		employee1.setDob(null);
		employee1.setGender("Male");
		employee1.setDepartment("Engg");
		String status1 = employeeService.registerEmployee(employee1);
		assertEquals(REQUIRED, status1);
		
		Employee employee2 = new Employee();
		employee2.setEmployeeId(1234);
		employee2.setFirstName("abc");
		employee2.setLastName("xyz");
		employee2.setDob("");
		employee2.setGender("Male");
		employee2.setDepartment("Engg");
		String status2 = employeeService.registerEmployee(employee2);
		assertEquals(REQUIRED, status2);
	}
	
	@Test
	public void testEmployeeDepartmentNullAndEmpty() {
		Employee employee1 = new Employee();
		employee1.setEmployeeId(1234);
		employee1.setFirstName("abc");
		employee1.setLastName("xyz");
		employee1.setDob("14-09-1999");
		employee1.setGender("Male");
		employee1.setDepartment(null);
		String status1 = employeeService.registerEmployee(employee1);
		assertEquals(REQUIRED, status1);
		
		Employee employee2 = new Employee();
		employee2.setEmployeeId(1234);
		employee2.setFirstName("abc");
		employee2.setLastName("xyz");
		employee2.setDob("14-09-1999");
		employee2.setGender("Male");
		employee2.setDepartment("");
		String status2 = employeeService.registerEmployee(employee2);
		assertEquals(REQUIRED, status2);
	}
	
	@Test
	public void testGetAllEmployeesForEmpty() {
		List<Employee> employeeList = employeeService.getAllEmployees();
		assertNull(employeeList);
	}
	
	@Test
	public void testGetAllEmployees() {
		Employee employee1 = new Employee();
		employee1.setEmployeeId(1237);
		employee1.setFirstName("abc");
		employee1.setLastName("xyz");
		employee1.setDob("14-09-1999");
		employee1.setGender("Male");
		employee1.setDepartment("Engg");
		employeeService.registerEmployee(employee1);
		List<Employee> employeeList = employeeService.getAllEmployees();
		assertEquals(1, employeeList.size());
		
		Employee employee2 = new Employee();
		employee2.setEmployeeId(1236);
		employee2.setFirstName("abcd");
		employee2.setLastName("wxyz");
		employee2.setDob("14-10-1999");
		employee2.setGender("Female");
		employee2.setDepartment("Engg");
		employeeService.registerEmployee(employee2);
		List<Employee> employeeList2 = employeeService.getAllEmployees();
		assertEquals(2, employeeList2.size());
		employeeService.deleteEmployees(employee1);
		employeeService.deleteEmployees(employee2);
	}
}
