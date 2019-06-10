package com.scp.java.hibernate.integration;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration("springhbm")
public class SpringJavaConfig {
	
	
	//@Qualifier("s2")
	@Autowired
	SessionFactory sfactory;
	
	String hsql_driver_class = "org.hsqldb.jdbcDriver";
	String hsql_username="SA";
	String hsql_password="";
	String hsql_dialect_class="org.hibernate.dialect.HSQLDialect";
	String hsql_url="jdbc:hsqldb:hsql://localhost/";
	
	
	String msql_driver_class = "com.mysql.cj.jdbc.Driver";
	String msql_username="root";
	String msql_password="admin123";
	String msql_dialect_class="org.hibernate.dialect.MariaDB53Dialect";
	String msql_url="jdbc:mysql://localhost/scp";//?autoReconnect=true&amp;useSSL=false
	
	
	
	@Bean
	public DataSource getMysqlDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setUrl(msql_url);
		datasource.setDriverClassName(msql_driver_class);
		datasource.setUsername(msql_username);
		datasource.setPassword(msql_password);
		return datasource;
	}
	
	/*
	 * @Bean public DataSource getHsqlDataSource() { BasicDataSource datasource =
	 * new BasicDataSource(); datasource.setUrl(hsql_url);
	 * datasource.setDriverClassName(hsql_driver_class);
	 * datasource.setUsername(hsql_username); datasource.setPassword(hsql_password);
	 * return datasource; }
	 */
	

	@Bean("s1")
	public LocalSessionFactoryBean sessionFactory1() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getMysqlDataSource());
		factory.setPackagesToScan("com.scp.java.hibernate.integration");
		factory.setHibernateProperties(getHibernateProperties());
		return factory;
	}


	
	public Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", msql_dialect_class);
		prop.put("hibernate.hbm2ddl.auto","create");
		prop.put("hibernate.temp.use_jdbc_metadata_defaults",false);
		prop.setProperty("useSSL", "false");
		prop.setProperty("autoReconnect", "true");
		return prop;
	}
	
	
}
