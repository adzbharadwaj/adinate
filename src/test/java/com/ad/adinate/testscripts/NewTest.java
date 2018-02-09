package com.ad.adinate.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ad.adinate.pageclasses.Homepage;
import com.ad.adinate.pageclasses.RegistrationPage;
import com.ad.adinate.utils.BrowserFactory;
import com.ad.adinate.utils.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NewTest {
	WebDriver driver;
	Homepage hp;
	RegistrationPage rp;
	ExtentReports report;
	ExtentTest test;
	
  @Parameters({"browser","runmode"})
  @BeforeMethod
  public void beforeMethod(String browser, String runmode) throws IOException {
	  report= new ExtentReports("./ExtentReports/Er.html", false);
	  test = report.startTest("First test");
	  driver = BrowserFactory.getBrowser(runmode, browser);
	  BrowserFactory.openurl();
	  test.log(LogStatus.INFO, "test started");
  }
  
  @DataProvider(name="testdata")
  public String[][] registrationData(){
	 return ExcelReader.twoDtestData("verifyRegistrationPage");
  }
  
  @Test(dataProvider="testdata" )
  public void verifyRegistration(String fn, String ln, String ph,String em, String pwd, String cpwd) {
	  hp = PageFactory.initElements(driver, Homepage.class);
	  hp.clickMyAccount();
	  rp = hp.clickRegister();
	  rp.enterFirstName(fn);
	  rp.enterLastName(ln);
	  rp.enterEmail(em);
	  rp.enterMobileNumber(ph);
	  rp.enterPassword(pwd);
	  rp.enterConfirmPassword(cpwd);
	  String actual=rp.getPageTitle();
	  Assert.assertEquals(actual, "Expected");
	  test.log(LogStatus.INFO, "Test Complete");
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(500);
	  driver.quit();
	  report.endTest(test);
	  report.flush();
  }

}
