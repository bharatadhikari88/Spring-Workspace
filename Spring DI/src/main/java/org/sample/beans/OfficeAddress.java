package org.sample.beans;

import org.sample.interfaces.IAddress;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("officeAddress")
@Profile("dev")
public class OfficeAddress implements IAddress {
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
