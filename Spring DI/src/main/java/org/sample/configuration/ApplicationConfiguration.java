package org.sample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AddressConfiguration.class,EmployeeConfiguration.class})
//@ImportResource("spring_config.xml")
public class ApplicationConfiguration {
	@Bean(name="number")
	public int getNumber(){
		return 9;
	}
	
}
