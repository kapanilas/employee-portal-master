package io.swagger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.sg.ep.dao.EmployeeDAOImpl;
import com.sg.ep.dao.IEmployeeDAO;
import com.sg.ep.service.EmployeeService;
import com.sg.ep.service.IEmployeeService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "io.swagger", "io.swagger.api", "io.swagger.configuration" })
public class EmployeePortal implements CommandLineRunner {

	@Bean
	IEmployeeService getEmployeeService() {
		return new EmployeeService();
	}
	
	@Bean
	IEmployeeDAO getEmployeeDAOImpl() {
		return new EmployeeDAOImpl();
	}

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
	}

	public static void main(String[] args) throws Exception {
		new SpringApplication(EmployeePortal.class).run(args);
	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}

}
