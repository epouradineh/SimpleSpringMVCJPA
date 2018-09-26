package com.adineh.jpatest.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.adineh.jpatest")
@EnableTransactionManagement
@PropertySource({"classpath:hibernate.properties"})
public class ApplicationConfiguration {

	@Autowired
	private Environment env;
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		/////////
		dataSource.setInitialPoolSize(getInteger(env.getProperty("connection.pool.initialPoolSize")));
		dataSource.setMinPoolSize(getInteger(env.getProperty("connection.pool.minPoolSize")));
		dataSource.setMaxPoolSize(getInteger(env.getProperty("connection.pool.maxPoolSize")));
		dataSource.setMaxIdleTime(getInteger(env.getProperty("connection.pool.maxIdleTime")));
		return dataSource;
	}
	
	protected int getInteger(String envProp) {
		int dataSourceIntProp = Integer.parseInt(envProp);
		return dataSourceIntProp;
	}
	
	protected Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return hibernateProperties;
	}
	
	@Bean
	protected LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory  = new LocalSessionFactoryBean();
		//set datasource for session factory
		sessionFactory.setDataSource(dataSource());
		//set hibernate properties for session factory
		sessionFactory.setHibernateProperties(getHibernateProperties());
		//set package to scan for session factory
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packageToScan"));
		return sessionFactory;
	}
	
	@Autowired
	@Bean
	protected HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
}
