package com.SpringSecurity.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.SpringSecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {
	@Autowired
	private Environment environment;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
			dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
			dataSource.setUser(environment.getProperty("jdbc.user"));
			dataSource.setPassword(environment.getProperty("jdbc.password"));
			
			dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
			dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
			dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
			dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
			
			logger.info(">> jdbc url "+ environment.getProperty("jdbc.url"));
			logger.info(">> jdbc user "+ environment.getProperty("jdbc.user"));
			logger.info(">> jdbc password "+ environment.getProperty("jdbc.password"));
		} catch (PropertyVetoException propertyVetoException) {
			// TODO Auto-generated catch block
			propertyVetoException.printStackTrace();
		}
		return dataSource;
	}
	
	private int getIntProperty(String property) {
		return Integer.parseInt(environment.getProperty(property));
	}

}
