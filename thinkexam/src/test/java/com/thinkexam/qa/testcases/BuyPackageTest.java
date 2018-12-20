package com.thinkexam.qa.testcases;


import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.thinkexam.base.TestBase;
import com.thinkexam.pages.BuyPackagePage;
import com.thinkexam.pages.HomePage;
import com.thinkexam.pages.LoginPage;
import com.thinkexam.pages.ProfilePage;
import com.thinkexam.util.TestUtil;

public class BuyPackageTest extends TestBase {
	
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	BuyPackagePage buyPackagePage;
	
	
	Logger log=Logger.getLogger(BuyPackageTest.class);
	
	public BuyPackageTest() {
		super();
	}
	@BeforeClass
	public void setUp() {
		initilization();
		testUtil=new TestUtil();
	    loginPage=new LoginPage();
	    homePage=new HomePage();
	    profilePage=new ProfilePage();
	    buyPackagePage=new BuyPackagePage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilePage=homePage.clickOnProfileMenu();
		buyPackagePage=profilePage.clickOnBuyPackageLink();
		log.info("*******************************setUp Executed****************************");
	}
	@Test(priority=40,enabled=true)
	public void validateBuyPackagePageTest() {
		buyPackagePage.validateBuyPackagePage();
		log.info("Buy package page validated");
	
	}
	@Test(priority=41,enabled=true)
	public void validateViewSyllabusTest() {
		buyPackagePage.validateViewSyllabusPage();
		log.info("*****************Syllabus verified***************");
	}
	@Test(priority=42,enabled=true)
	public void buyNowPageTest() {
		buyPackagePage.buyNowPackage();
		log.info("*****************Package Bought successfully************");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
