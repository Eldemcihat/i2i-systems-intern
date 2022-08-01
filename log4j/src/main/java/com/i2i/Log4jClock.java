package com.i2i;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.*;


public class ClockLogWithLog4j2 {
	
	private static Logger logger =LogManager.getLogger(ClockLogWithLog4j2.class.getName());										
	public static void main(String[] args) throws InterruptedException {
	while (true) {
	
	if("ERROR".equals(logger.getLevel().toString())) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now)+":00:00");  
		logger.error(dtf.format(now)+":00:00");
		Thread.sleep(3600000);
	}
	else if("INFO".equals(logger.getLevel().toString())) {
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now)+":00"); 
		logger.info(dtf.format(now)+":00");
		Thread.sleep(6000);	
	}
	else if("DEBUG".equals(logger.getLevel().toString())) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm.ss");  
	    LocalDateTime now = LocalDateTime.now();  
	    System.out.println(dtf.format(now)); 
	    logger.debug(dtf.format(now));
	    Thread.sleep(1000);	
	}
   }
  }
}