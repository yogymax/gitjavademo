package com.scp.java;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestLoggers {

		public static Logger logger = Logger.getLogger(TestLoggers.class);

	public static void main(String[] args) throws InterruptedException {
		System.out.println("THis is line1 ");
		System.out.println("THis is line2 ");
		System.out.println("THis is line3 ");
		System.out.println("THis is line4 ");
		
		 
		// this will force a reconfiguration
		
		
		
		logger.setLevel(Level.ALL);
		
		for(int i=0;i<10000;i++) {
			logger.debug("This is newline"+i);
			logger.warn("This is newline"+i);
			logger.trace("This is newline "+i);
			TimeUnit.SECONDS.sleep(5);
		}
		
	}
	
}
