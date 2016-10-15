package org.sample.test;

import static org.junit.Assert.assertNotNull;

import org.eagle.spring.HelloConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.interfaces.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HelloConfiguration.class)
public class HelloTest {
	
	@Qualifier("MCAStudent")
	@Autowired
	private IStudent mcaStudent;
	
	@Qualifier("BCAStudent")
	@Autowired
	private IStudent bcaStudent;
	
	@Qualifier("testStudent")
	@Autowired
	private IStudent testStudent;
	
	@Test
	public void isStudentExist(){
		assertNotNull(mcaStudent);
		assertNotNull(bcaStudent);
		assertNotNull(testStudent);
	}
}
