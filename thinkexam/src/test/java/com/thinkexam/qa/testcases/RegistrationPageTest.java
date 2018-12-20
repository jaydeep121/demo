package com.thinkexam.qa.testcases;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.thinkexam.base.TestBase;
import com.thinkexam.pages.HomePage;
import com.thinkexam.pages.RegistrationPage;
import com.thinkexam.util.ExcelLib;
import com.thinkexam.util.TestUtil;

public class RegistrationPageTest extends TestBase {
	HomePage homePage;
	RegistrationPage registrationPage;
	ExcelLib excelLib;
	
	RegistrationPageTest(){
		super();
	}
	@BeforeMethod
	public void setup() {
		initilization();
		excelLib =new ExcelLib();
		registrationPage=new RegistrationPage();
	}
	@DataProvider
	public Object[][] getregistrationData() {
		Object[][] data=TestUtil.getTestData("reg");
		return data;
	}
	@Test(dataProvider="getregistrationData")
	public void registrationPageTest(String fullName,String email, String password, String confirmPassword, String phoneNumber,String selectCourse,String selectState,String selectCity) {
		Reporter.log("registrationPageTest data is "+fullName+email+password+confirmPassword+phoneNumber+selectCourse+selectState+selectCity);
		homePage=registrationPage.registration(fullName, email, password, confirmPassword, phoneNumber, selectCourse, selectState, selectCity);
		String candidateName=driver.findElement(By.xpath("//strong[contains(text(),'Ak')]")).getText();
		Assert.assertEquals(fullName, candidateName,"candidateName not verified");
	}
	
	/*@Test(priority=10,enabled=true)
	public void registrationTest() {
		homePage=registrationPage.registration();
		String sheet="registration";
		int row=1;
		String fullNamne=excelLib.getExcelData(sheet, row, 0);
		Reporter.log("fullNamne is "+fullNamne,true);
		String userName=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/strong[1]")).getText();
		Reporter.log("userName is "+userName,true);
		if(fullNamne.equals(userName)) {
			Reporter.log("registrationTest pass ",true);
		}
		else {
			Reporter.log("registrationTest fail ",true);
		}		
	}*/
	@Test(priority=1,enabled=false)
	public void featuresImageValidationTest() {
		boolean featureImage=registrationPage.featuresImageValidation();
		Assert.assertTrue(featureImage,"feature Image Not Dispalyed ");
	}
	@Test(priority=2,enabled=false)
	public void validateOnlineSupportTest() {
		String clinetNumer=registrationPage.validateTechSupportPage();
		Reporter.log("client numer is "+clinetNumer,true);
	}
	@Test(priority=3,enabled=false)
	public void validateTechSupportTest() {
		String techSupportnumer=registrationPage.validateTechSupportPage();
		if(techSupportnumer.equals(prop.getProperty("Tech Suppor"))) {
			Reporter.log("Tech Suppor number matched",true);
		}
		else {
			Reporter.log("Tech Suppor number not matched",true);
		}
		Reporter.log("client numer is "+techSupportnumer,true);
	}
	@Test(priority=4,enabled=false)
	public void validateClietEmailTest() {
		String clientEmail=registrationPage.validateClientEmailPage();
		if(clientEmail.equals(prop.getProperty("Email"))) {
			Reporter.log("Email matched",true);
		}
		else {
			System.out.println("Email not matched");
		}
		Reporter.log("client numer is "+clientEmail,true);
	}
	@Test(priority=5,enabled=false)
	public void validateCopyrightContentTextTest() {
		String copyrightContent=registrationPage.validateCopyrightContentPage();
		if(copyrightContent.equals(prop.getProperty("copyright"))) {
			System.out.println("copyright matched");
		}
		else {
			System.out.println("copyright not matched");
		}
		Reporter.log("client numer is "+copyrightContent,true);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
