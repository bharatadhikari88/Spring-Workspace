package org.eagle.spring;
import org.sample.interfaces.IAddress;
import org.sample.interfaces.IStudent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

@Component("MCAStudent")
public class Student implements IStudent,BeanNameAware,BeanFactoryAware,ApplicationContextAware {
	private String name;
	private int age;
	@Autowired
	@Qualifier("HomeAddress")
	private IAddress address;
	private IAddress officeAddress;
	
	public IAddress getOfficeAddress() {
		return officeAddress;
	}

	@Autowired
	public void setOfficeAddress(@Qualifier("OfficeAddress")IAddress officeAddress) {
		this.officeAddress = officeAddress;
	}

	//public Student(){}
	
	//@Autowired
	public Student(@Qualifier("name")String name){
		this.name = name;
	}
	
	@Autowired
	public Student(@Qualifier("name")String name,@Qualifier("OfficeAddress")IAddress officeAddres){
		this.name = name;
		this.officeAddress = officeAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public IAddress getAddress() {
		return address;
	}
	public void setAddress(IAddress address) {
		this.address = address;
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("Bean Application context");
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Bean factory ");
	}
	@Override
	public void setBeanName(String name) {
		System.out.println("Bean Name :-" + name);
	}
	
	
}
