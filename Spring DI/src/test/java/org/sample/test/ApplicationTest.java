package org.sample.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.configuration.ApplicationConfiguration;
import org.sample.interfaces.IAddress;
import org.sample.interfaces.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
//@ActiveProfiles("QA")
public class ApplicationTest {
	
	@Autowired
	IAddress officeAddress;   //compare type, variable name and qualifier name in spring container
	@Autowired
	IAddress homeAddress;
	@Autowired
	IEmployee employee;
	@Autowired
	int number;
	@Autowired
	private Environment env;
	
	@Test
	public void test() {
		assertNotNull(officeAddress);
		assertNotNull(homeAddress);
		assertNotNull(employee);

	}
	
	@Test
	public void numberTest(){
		System.out.println(number);
	}
	
	@Test
	public void getActiveProfiles(){
		System.out.println(env.getActiveProfiles().toString());
	}
}
