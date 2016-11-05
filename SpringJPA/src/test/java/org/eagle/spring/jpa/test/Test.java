package org.eagle.spring.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.eagle.spring.jpa.JPAConfiguration;
import org.eagle.spring.jpa.entities.JPATest;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JPAConfiguration.class)
@Transactional
@Rollback(false)
public class Test {
	@PersistenceContext
	private EntityManager entityManager;
	
	@org.junit.Test
	public void test(){
		entityManager.persist(new JPATest(1l, "Bharat")); 
	}
}
