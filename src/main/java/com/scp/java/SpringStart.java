package com.scp.java;
/**
 * PP -- works fine
 * SS -- works fine
 * PS -- works fine
 * SP -- singletone -- singltone -- resolve -- Lookup method
 * 
 * 
 * 
 */



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStart {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("newbean.xml");
		
		Product prod1 = (Product)context.getBean("prod");
		//Vendor v1 = (Vendor)context.getBean("ven");

		System.out.println(prod1);
		
		context.registerShutdownHook();
		
	}
}
