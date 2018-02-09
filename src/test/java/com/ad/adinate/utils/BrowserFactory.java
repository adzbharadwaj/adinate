package com.ad.adinate.utils;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	private static WebDriver driver ;
	
	public static WebDriver getBrowser(String runmode, String browser) throws IOException {
		if(runmode.equalsIgnoreCase("local")) {
			if(browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "/Users/adityabharadwaj/MissionJob/Tools/drivers/chromedriver");
				driver = new ChromeDriver();
			}
			if(browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "/Users/adityabharadwaj/MissionJob/Tools/drivers/geckodriver");
				driver =new FirefoxDriver();
			}
		}
		if(runmode.equalsIgnoreCase("remote")) {
			if(browser.equalsIgnoreCase("Chrome")) {
				ChromeOptions opt = new ChromeOptions();
				String node = CommonUtils.getPropertyValue("node1");
				driver = new RemoteWebDriver(new URL(node),opt);
			}
			if(browser.equalsIgnoreCase("Firefox")) {
				FirefoxOptions opt = new FirefoxOptions();
				String node = CommonUtils.getPropertyValue("node1");
				System.out.println(node);
				driver = new RemoteWebDriver(new URL(node),opt);
			}
		}
		return driver;
	}
	
	public static void openurl() throws IOException {
		String url = CommonUtils.getPropertyValue("url");
		driver.get(url);
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Constants.PAGE_LOAD_TIME_IN_SECONDS, TimeUnit.SECONDS);
	}
}
