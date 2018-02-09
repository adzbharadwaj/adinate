package com.ad.adinate.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ad.adinate.utils.Basepage;

public class RegistrationPage extends Basepage {
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(name="firstname")
	WebElement firstname;
	
	public void enterFirstName(String s) {
		firstname.sendKeys(s);
	}
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	public void enterLastName(String s) {
		lastname.sendKeys(s);
	}
	
	@FindBy(name="phone")
	WebElement phone;
	
	public void enterMobileNumber(String s) {
		phone.sendKeys(s);
	}
	
	@FindBy(name="email")
	WebElement email;
	
	public void enterEmail(String s) {
		email.sendKeys(s);
	}
	
	@FindBy(name="password")
	WebElement password;
	
	public void enterPassword(String s) {
		password.sendKeys(s);
	}
	
	@FindBy(name="confirmpassword")
	WebElement confirmpassword;
	
	public void enterConfirmPassword(String s) {
		confirmpassword.sendKeys(s);
	}
	
	@FindBy(xpath="//form[@id='headersignupform']/div[9]/button")
	WebElement signupButton;
	
	public void clickSignUp() {
		signupButton.click();
	}
}
