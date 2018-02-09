package com.ad.adinate.pageclasses;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ad.adinate.utils.Basepage;

public class Homepage extends Basepage {
	WebDriver driver;
	JavascriptExecutor js;
	public Homepage(WebDriver driver) {
		super(driver);
		this.driver =driver;
	}
	
	@FindBy(xpath="//li[@id='li_myaccount']/a")
	List<WebElement> myAccount;
	
	public void clickMyAccount() {
		for (WebElement w : myAccount) {
			if (w.isDisplayed() == true) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", w);
			}
		}
	}
	
	@FindBy(xpath = "//div[@id='sidebar_left']/div/div/ul/li[2]/a/strong/i/../../../preceding-sibling::li/ul/li[1]/a")
	WebElement login;
	
	@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/ul/li[1]/ul/li[2]/a")
	WebElement register;
	
	public RegistrationPage clickRegister() {
		WebDriverWait w = new WebDriverWait(driver, 10);
		WebElement wb = w.until(ExpectedConditions.visibilityOf(register));
		wb.click();
		return PageFactory.initElements(driver, RegistrationPage.class);
	}

}
