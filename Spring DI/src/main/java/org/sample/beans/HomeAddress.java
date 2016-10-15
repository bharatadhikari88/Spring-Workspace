package org.sample.beans;
import org.sample.interfaces.IAddress;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("HomeAddress")
public class HomeAddress implements IAddress {
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
