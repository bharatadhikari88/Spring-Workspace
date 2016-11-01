package org.eagle.spring.jpa;

import java.util.Properties;

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
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/hibernate");
		dataSource.setUsername("postgres");
		dataSource.setPassword("adhikari");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		localEntityManagerFactoryBean
				.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "create");
		
		localEntityManagerFactoryBean.setDataSource(dataSource());
		/** absence of scan it throw persistence.xml missing error**/
		localEntityManagerFactoryBean.setPackagesToScan("org.eagle.spring.jpa");
		localEntityManagerFactoryBean.setJpaProperties(properties);
		
		
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
