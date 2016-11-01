package org.eagle.spring.jpa;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfiguration {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql:Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/hibernate");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localEntityManagerFactoryBean.setDataSource(dataSource());
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		localEntityManagerFactoryBean
				.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		return localEntityManagerFactoryBean;
	}

	/**
	 * @Transactional using this manager when can create multiple and specify
	 *                along with @transactional
	 **/
	@Bean
	public JpaTransactionManager jpaTransactionManager() {
		return new JpaTransactionManager(localEntityManagerFactoryBean()
				.getObject());
	}

}
