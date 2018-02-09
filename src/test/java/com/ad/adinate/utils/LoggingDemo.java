package com.ad.adinate.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingDemo {
	public static final Logger log4 = LogManager.getLogger(LoggingDemo.class.getName());
	
	public static void main(String[] args) {
		log4.debug("Debug ....");
		log4.info("Info....");
		log4.error("Error....");
		
	
	}
}
