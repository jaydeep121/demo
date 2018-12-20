package com.thinkexam.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.thinkexam.base.TestBase;
import com.thinkexam.pages.HomePage;
import com.thinkexam.pages.LoginPage;
import com.thinkexam.pages.ProfilePage;
import com.thinkexam.util.TestUtil;

public class ProfilePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	TestUtil testUtil;
	
	public ProfilePageTest(){
		super();
	}
	@BeforeClass
	public void setup() {
		initilization();
		testUtil=new TestUtil();
		profilePage=new ProfilePage();
	    loginPage=new LoginPage();
	    profilePage=new ProfilePage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilePage=homePage.clickOnProfileMenu();
	}
	@Test(priority=30,enabled=true)
	public void validatePersonalInformationLebelTest() {
		String personalInformationLebel=profilePage.validatePersonalInformationLebelPage();
		Assert.assertEquals(personalInformationLebel, "Personal Information","Personal Information Lebel not varified");
	}
	@Test(priority=31,enabled=true)
	public void validateSecurityLebelTest() {
		String SecurityLebel=profilePage.validateSecurityLebelPage();
		Assert.assertEquals(SecurityLebel, "Security","Security Lebel Not verified");
	}
	@Test(priority=32,enabled=true)
	public void validateEnrollmentInformationLebelTest() {
		String enrollmentInformationLebel=profilePage.validateEnrollmentInformationLebelPage();
		Assert.assertEquals(enrollmentInformationLebel, "Enrollment Information","Enrollment Information Lebel not verified");
	}
	@Test(priority=33,enabled=true)
	public void clickOnBuyPackageTest() {
		profilePage.clickOnBuyPackageLink();
	}
	@Test(priority=34,enabled=true)
	public void clickOnReportLinkTest() {
		profilePage.clickOnReportLink();
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
