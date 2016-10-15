package org.sample.configuration;

import org.sample.beans.Employee;
import org.sample.interfaces.IEmployee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {
	
	@Bean(name="employee")
	public IEmployee getEmployee(){
		return new Employee();
	}

}
