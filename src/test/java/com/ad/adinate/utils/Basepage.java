package com.ad.adinate.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Basepage {
	private WebDriver driver;
	public static final Logger log4 = LogManager.getLogger(Basepage.class.getName());
	
	public Basepage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public String getPageTitle() {
		log4.info("Page Title is "+ driver.getTitle());
		return driver.getTitle();
	}
	
	public String getAlertText() {
		log4.info("Alert text is " + driver.switchTo().alert().getText());
		return driver.switchTo().alert().getText();
	}
	
	public String getAlertText(int waitTime) {
		WebDriverWait wait= new WebDriverWait(this.driver, waitTime);
		Alert a = wait.until(ExpectedConditions.alertIsPresent());
		a.getText();
		return null;
	}
	
	public void acceptAlert() {
		log4.info("Accepting Alert...");
		driver.switchTo().alert().accept();
	}
	
	public void rejectAlert() {
		log4.info("Rejcting Alert...");
	}
	
	
	
}
