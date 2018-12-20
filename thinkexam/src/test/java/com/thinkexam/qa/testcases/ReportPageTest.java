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
import com.thinkexam.pages.ReportPage;
import com.thinkexam.util.TestUtil;

public class ReportPageTest extends TestBase {
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	ReportPage reportPage;
	
	public ReportPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initilization();
		testUtil=new TestUtil();
	    loginPage=new LoginPage();
	    homePage=new HomePage();
	    profilePage=new ProfilePage();
	    reportPage=new ReportPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//profilePage=homePage.clickOnProfileMenu();
		reportPage=profilePage.clickOnReportLink();
	}
	@Test(priority=60,enabled=true)
	public void validateReportPageTest() {
		String text=reportPage.validateReportPage();
		Assert.assertEquals(text, "Report","Report page not verified");
	}
	@Test(priority=61,enabled=true)
	public void postiveMarksValidationTest() {
		String positiveMarks=reportPage.postiveMarksValidation();
		//Reporter.log("Candidate Postive Marks is "+positiveMarks,true);
		if(positiveMarks.equals("6")) {
			Reporter.log("postiveMarksValidationTest Pass, Candidate Marks is :  "+positiveMarks,true);
		}
		else{
		    Reporter.log("postiveMarksValidationTest Fail, Candidate Marks is :  "+positiveMarks,true);
		}
	}
	@Test(priority=62,enabled=true)
	public void negativeMarksValidation() {
		String negativeMarks=reportPage.negativeMarksValidation();
		//Reporter.log("Candidate negative Marks is "+negativeMarks,true);
		if(negativeMarks.equals("-1.5")) {
			Reporter.log("negativeMarksValidation Pass, Candidate Marks is : "+negativeMarks,true);
		}
		else {
			Reporter.log("negativeMarksValidation Fail, Candidate Marks is : "+negativeMarks,true);
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
