package org.eagle.spring.db.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
/**
 * 
 * @author SINGH.BHARAT
 *
 */
public class DBConfig {
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/hibernate");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		return driverManagerDataSource;
	}
	
	/** hibernate configuration starts **/
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(){
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan("org.eagle.spring.db.entities");
		Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	    hibernateProperties.put("hibernate.show_sql", "true");
	    hibernateProperties.put("hibernate.hbm2ddl.auto", "create");
		localSessionFactoryBean.setHibernateProperties(hibernateProperties);
		return localSessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(){
		return new HibernateTransactionManager(localSessionFactoryBean().getObject());
	}
	/** hibernate Configuration ends **/
	
	
	/** JPA configuration **/
	@Bean
	public LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localEntityManagerFactoryBean.setDataSource(dataSource());
		Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	    hibernateProperties.put("hibernate.show_sql", "true");
	    hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
	    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		/** absence of scan it throw persistence.xml missing error**/
	    localEntityManagerFactoryBean.setPackagesToScan("org.eagle.spring.db.entities");
	    /** incase of entity manager jpa vendor adapter is mandatory **/
	    localEntityManagerFactoryBean
		.setJpaVendorAdapter(hibernateJpaVendorAdapter);
	    localEntityManagerFactoryBean.setJpaProperties(hibernateProperties);
		
		
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
	
	/** jpa configuration ends **/

}
