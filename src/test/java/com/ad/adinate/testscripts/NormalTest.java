package com.ad.adinate.testscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NormalTest {
	static JavascriptExecutor js;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/adityabharadwaj/MissionJob/Tools/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.phptravels.net/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		List<WebElement> ls= driver.findElements(By.xpath("//li[@id='li_myaccount']/a"));
		for(WebElement w :ls) {
			if (w.isDisplayed()==true) {
				js= (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", w);
			}
		}
	}
}
