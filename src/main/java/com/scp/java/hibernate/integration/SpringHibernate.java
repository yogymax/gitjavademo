package com.scp.java.hibernate.integration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringHibernate {

	public static void main(String[] args) {
		ProductInfo pinfo1 = new ProductInfo(101,"Remote",234.4, "LG");
		ProductInfo pinfo2 = new ProductInfo(102,"TV",23224.4, "LG");
		ProductInfo pinfo3 = new ProductInfo(103,"Fridge",11234.4, "LG");
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("newbean_mysql.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfig.class);
		
		SpringJavaConfig javaConfig = (SpringJavaConfig) context.getBean("springhbm");
		SessionFactory sfactory = javaConfig.sfactory;
		System.out.println("Sfactory : "+sfactory);
		Session session = sfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(pinfo1);session.save(pinfo2);session.save(pinfo3);
		session.flush();
		tr.commit();
	}
	
}

