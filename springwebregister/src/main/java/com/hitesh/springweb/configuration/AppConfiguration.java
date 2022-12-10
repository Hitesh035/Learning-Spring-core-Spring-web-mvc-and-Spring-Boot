package com.hitesh.springweb.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.hitesh.springweb.controller.RegisterRestController;

@Configuration
@EnableWebMvc
@ComponentScan("com.hitesh.springweb")
public class AppConfiguration {
	
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
		
	}
	
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(getDataSource());
		sessionFactoryBean.setPackagesToScan("com.hitesh.springweb.entity");
		
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		sessionFactoryBean.setHibernateProperties(properties);
		return sessionFactoryBean;
	}
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/trial1");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
		
	}
}
