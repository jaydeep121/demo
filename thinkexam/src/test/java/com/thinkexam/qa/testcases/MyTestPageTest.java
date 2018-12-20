package com.thinkexam.qa.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.thinkexam.base.TestBase;
import com.thinkexam.pages.BuyPackagePage;
import com.thinkexam.pages.HomePage;
import com.thinkexam.pages.LoginPage;
import com.thinkexam.pages.MyTestPage;
import com.thinkexam.pages.ProfilePage;
import com.thinkexam.util.TestUtil;

public class MyTestPageTest extends TestBase {
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
 // BuyPackagePage buyPackagePage;
	MyTestPage myTestPage;
	
	public MyTestPageTest(){
		super();
	}
	@BeforeClass
	public void setUp() {
		initilization();
		testUtil=new TestUtil();
	    loginPage=new LoginPage();
	    homePage=new HomePage();
	    profilePage=new ProfilePage();
	//  buyPackagePage=new BuyPackagePage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilePage=homePage.clickOnProfileMenu();
	//  buyPackagePage=profilePage.clickOnBuyPackageLink();
	//	buyPackagePage.buyNowPage();
		myTestPage=new MyTestPage();
	}
	@Test(priority=50,enabled=true)
	public void positiveTestAttemptValidationTest() {
		String myMarks=myTestPage.positiveTestAttemptValidation();
		Reporter.log("my total msrks is : "+myMarks,true);
	}
	@Test(priority=51,enabled=true)
	public void negativeTestAttemptValidationTest() {
		String myMarks=myTestPage.negativeTestAttemptValidation();
		Reporter.log("my total msrks is : "+myMarks,true);
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
