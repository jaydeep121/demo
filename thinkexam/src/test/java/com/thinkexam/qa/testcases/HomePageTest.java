package com.thinkexam.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.thinkexam.base.TestBase;
import com.thinkexam.pages.HomePage;
import com.thinkexam.pages.LoginPage;
import com.thinkexam.pages.ProfilePage;
import com.thinkexam.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
    ProfilePage profilePage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initilization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=20,enabled=true)
	public void validateTitleTest() {
		String homePageTitle=homePage.validateTitle();
		Assert.assertEquals(homePageTitle, "Yuwam","titlenotmatched");
	}
	@Test(priority=21,enabled=true)
	public void validateUserNameTest() {
		String actualUserName=homePage.validateUserName();
		String expectedUserName=prop.getProperty("studentFullName");
		Assert.assertTrue(actualUserName.contains(expectedUserName));
		Reporter.log("userName verified, The UserName and Staus is : "+actualUserName,true);
	}
	@Test(priority=22,enabled=true)
	public void logoutHomePageTest() {
		boolean flag=homePage.logoutHomePage();	
		Assert.assertTrue(flag,"Logout not Working");
		Reporter.log("User Logout Succesfully",true);
	}
	@Test(priority=23,enabled=true)
	public void clickOnProfileMenuTest() {
		homePage.clickOnProfileMenu();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
