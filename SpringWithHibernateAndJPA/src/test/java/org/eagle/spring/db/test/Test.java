package org.eagle.spring.db.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.eagle.spring.db.config.Config;
import org.eagle.spring.db.entities.TestEntity;
import org.eagle.spring.db.repository.TestRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author SINGH.BHARAT
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional("hibernateTransactionManager")
@Rollback(false)
public class Test {

	@Autowired
	private SessionFactory sessionFactory;
	
	@org.junit.Test
	public void hibernateTest() {
		Session session = sessionFactory.getCurrentSession();
		TestEntity test = new TestEntity();
		test.setId(1l);
		test.setName("Bharat");
		session.persist(test);

	}

	@PersistenceContext
	private EntityManager entityManager;

	@org.junit.Test
	@Transactional("jpaTransactionManager")
	public void jpaTest() {
		TestEntity test = new TestEntity();
		test.setId(2l);
		test.setName("singh");
		entityManager.persist(test);

	}

	@Autowired
	private TestRepository testRepository;

	/*public void repositoryTest() {
		TestEntity test = new TestEntity();
		test.setId(3l);
		test.setName("adhikari");
		testRepository.save(test);

	}*/

}
