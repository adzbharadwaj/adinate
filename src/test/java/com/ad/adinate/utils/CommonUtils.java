package com.ad.adinate.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class CommonUtils {
	public static final Logger log4 = LogManager.getLogger(CommonUtils.class.getName());
	public static String getPropertyValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./TestData/config.properties");
		Properties p = new Properties();
		p.load(fis);
		log4.info("Got property Value " + p.getProperty(key));
		return p.getProperty(key);
	}
	
	public static String getCurrentDate() {
		DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
		Date d = new Date();
		log4.info("Date :"+ df.format(d));
		return df.format(d);
	}
	
	public static void takeScreenshot(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+getCurrentDate()+".png");
		log4.info("ScreenShot Captured "+ dest.getAbsolutePath() );
		FileUtils.copyFile(src, dest);
	}
}
