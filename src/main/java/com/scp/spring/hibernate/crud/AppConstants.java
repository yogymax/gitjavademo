package com.scp.spring.hibernate.crud;

public interface AppConstants {
	String HSQL_DB_DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	String HSQL_DB_CONNECTION_STRING = "jdbc:hsqldb:hsql://localhost/";
	String HSQL_DB_USERNAME = "SA";
	String HSQL_DB_PASSOWORD = "";
	String HSQL_DB_DIALECT = "org.hibernate.dialect.HSQLDialect";
	String MY_APP_ENTITY_PCKG = "com.scp.spring.hibernate.crud";


	enum supported_db{
		MYSQL,
		HSQL
	}

	String MSQL_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	String MSQL_USERNAME="root";
	String MSQL_PASSWORD="admin123";
	String MSQL_DIALECT_CLASS="org.hibernate.dialect.MariaDB53Dialect";
	String MSQL_URL="jdbc:mysql://localhost/scp";//?autoReconnect=true&amp;useSSL=false
	


}




