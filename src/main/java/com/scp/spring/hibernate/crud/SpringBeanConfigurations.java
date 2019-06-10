package com.scp.spring.hibernate.crud;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import static com.scp.spring.hibernate.crud.AppConstants.*;

@Configuration("configBean")
public class SpringBeanConfigurations {

	@Bean
	public DataSource specifyHSQLDataBaseProperties() {
		BasicDataSource bsDs = new BasicDataSource();
		bsDs.setDriverClassName(HSQL_DB_DRIVER_CLASS);
		bsDs.setUrl(HSQL_DB_CONNECTION_STRING);
		bsDs.setUsername(HSQL_DB_USERNAME);
		bsDs.setPassword(HSQL_DB_PASSOWORD);
		return bsDs;
	}

	@Bean
	public DataSource specifyMySQLDataBaseProperties() {
		BasicDataSource bsDs = new BasicDataSource();
		bsDs.setDriverClassName(MSQL_DIALECT_CLASS);
		bsDs.setUrl(MSQL_URL);
		bsDs.setUsername(MSQL_URL);
		bsDs.setPassword(MSQL_PASSWORD);
		return bsDs;
	}
	
	@Bean("hsqlBean")
	public LocalSessionFactoryBean createHibernateHsqlSessionfactory() {
		LocalSessionFactoryBean lbean =new LocalSessionFactoryBean();
		lbean.setDataSource(specifyHSQLDataBaseProperties());
		lbean.setHibernateProperties(specifyHibernateProperties(supported_db.HSQL));
		lbean.setPackagesToScan(MY_APP_ENTITY_PCKG);
		return lbean;
	}
	
	
	@Bean("mysqlBean")
	public LocalSessionFactoryBean createHibernateMysqlSessionfactory() {
		LocalSessionFactoryBean lbean =new LocalSessionFactoryBean();
		lbean.setDataSource(specifyMySQLDataBaseProperties());
		lbean.setHibernateProperties(specifyHibernateProperties(supported_db.MYSQL));
		lbean.setPackagesToScan(MY_APP_ENTITY_PCKG);
		return lbean;
	}
	
	
	public Properties specifyHibernateProperties(supported_db whichDb) {
		Properties props = new Properties();
		if(whichDb.equals(supported_db.MYSQL)) {
			props.put(Environment.DIALECT, HSQL_DB_DIALECT);
			props.put("useSSL", "false");
			props.put("autoReconnect", "true");
	}else if(whichDb.equals(supported_db.HSQL)) {
			props.put(Environment.DIALECT, MSQL_DIALECT_CLASS);
	}
		
		props.put(Environment.HBM2DDL_AUTO,"create");
		props.put(Environment.SHOW_SQL, true);
		props.put("hibernate.temp.use_jdbc_metadata_defaults",false);
		return props;
	}
	
	
	
	

}
