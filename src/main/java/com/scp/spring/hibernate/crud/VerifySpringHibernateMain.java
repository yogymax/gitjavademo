package com.scp.spring.hibernate.crud;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class VerifySpringHibernateMain {

public static void main(String[] args) {
	ApplicationContext context= new AnnotationConfigApplicationContext(
			SpringBeanConfigurations.class,EmpDaoImpl.class,EmpServiceImpl.class);
	
	EmpServiceImpl simpl1 = (EmpServiceImpl)context.getBean("serviceBean");
	EmpBean bean = new EmpBean(1101,"AAAA","PM", 27223.2, 33);
	boolean isAdded = simpl1.addEmp(bean);
	System.out.println("Is empAdded " + isAdded);
	
	
	
	
	
	if(true)
		return;
	
	EmpDaoImpl dimpl1 = (EmpDaoImpl)context.getBean("repoBean");
	EmpDaoImpl dimpl2 = simpl1.getEmpDao();
	
	SessionFactory sfactory1=(SessionFactory)context.getBean("factoryBean");
	SessionFactory sfactory2 = dimpl1.getSfactory();
	
	System.out.println(simpl1.hashCode());
	System.out.println(dimpl1.hashCode());
	System.out.println(sfactory1.hashCode());
	
	System.out.println(dimpl2.hashCode());
	System.out.println(sfactory2.hashCode());
	
	
	if(true)
		return;
	
	SpringBeanConfigurations configOb = (SpringBeanConfigurations)context.getBean("configBean");
	System.out.println("BeanConfig : "+configOb.hashCode());
	System.out.println("DataSource : "+configOb.specifyHSQLDataBaseProperties().hashCode());
	System.out.println("Sessionfactory :"+configOb.createHibernateMysqlSessionfactory().hashCode());
	

	SpringBeanConfigurations configOb1 = (SpringBeanConfigurations)context.getBean("configBean");
	System.out.println("BeanConfig : "+configOb1.hashCode());
	System.out.println("DataSource : "+configOb1.specifyHSQLDataBaseProperties().hashCode());
	System.out.println("Sessionfactory :"+configOb1.createHibernateHsqlSessionfactory().hashCode());

	
}
	
}
