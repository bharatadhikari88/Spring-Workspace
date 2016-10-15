package org.eagle.mvcboot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * @Component, @Service, @Repository, @Controller all these annotations are scanned by
 * @Component scan and bean are added in spring container.
 * 
 * @Controller in presentation layer to handle http request response
 * @Service in service layer b/w presentation and persistence layer
 * @Repository in persistence layer
 * @Component for bean creation.
 * Top three are sterotype annotation just for bean type identification else same as @Component
 * 
 * 
 * @EntityScan for scan of @Entity and create table in db
 * 
 * @EnableJPARepository for make spring data JPARepository enable.
 * 
 * when @SpringBootApplication is created in root folder like org.eagle.mvcboot.sample
 * and all other annotations are in sub folder like org.eagle.mvcboot.sample.* 
 * than no scan is required explicitly. 
 */
@SpringBootApplication
public class SampleInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(SampleInitializer.class, args);
	}

}
