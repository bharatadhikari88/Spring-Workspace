package org.sample.configuration;

import org.sample.beans.HomeAddress;
import org.sample.beans.OfficeAddress;
import org.sample.interfaces.IAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackageClasses={OfficeAddress.class})
public class AddressConfiguration {
	
	/*@Bean(name="officeAddress")
	public IAddress getOfficeAddress(){
		return new OfficeAddress();
	}*/
	
	@Profile({"dev","QA"})
	@Bean(name="homeAddress")
	public IAddress getHomeAddress(){
		return new HomeAddress();
	}

}
