package com.thinkexam.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.thinkexam.base.TestBase;
import com.thinkexam.pages.HomePage;
import com.thinkexam.pages.LoginPage;
import com.thinkexam.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initilization();
		testUtil=new TestUtil();
		loginPage= new LoginPage();
	}
	@Test(priority=11,enabled=true)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("loginTitle"),"Login Page Title Not Verified");
	}
	@Test(priority=12,enabled=true)
	public void validateLoginPageLogoTest() {
		boolean flag=loginPage.validateLoginPageLogo();
		Assert.assertTrue(flag, "Vasishta Education");
	}
	@Test(priority=14,enabled=true)
	public void validatPasswordRecovery()
	{
		String passwordRecoveryAlert=loginPage.validatePasswordRecovery();
		Assert.assertEquals(passwordRecoveryAlert, "Your User Id and Password has been sent to your Email Id.","passwordRecoveryAlert Text Not Matched");
		Reporter.log("Credential Sent to your Registered mail please verify : "+passwordRecoveryAlert,true);
	}
	
	@Test(priority=13,enabled=true)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown() {
		driver.quit();	}
}
