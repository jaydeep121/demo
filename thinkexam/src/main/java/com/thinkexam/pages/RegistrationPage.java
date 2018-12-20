package com.thinkexam.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.thinkexam.base.TestBase;
import com.thinkexam.util.ExcelLib;
import com.thinkexam.util.JsLib;
import com.thinkexam.util.TestUtil;

public class RegistrationPage extends TestBase {
	ExcelLib excelLib=new ExcelLib();
	TestUtil testUtil=new TestUtil();
	JsLib jsLib=new JsLib();

	@FindBy(id="Stuidentname")
	private WebElement fullNameText;
	 
	@FindBy(xpath="//input[@id='email1']") 
	private WebElement emailAddressText;
	
	@FindBy(xpath="//input[@id='password1']")
	private WebElement passwordText;
	
	@FindBy(xpath="//input[@id='Cnfpassword']")
	private WebElement confirmPasswordText;
	
	@FindBy(xpath="//input[@id='mobile']")
	private WebElement mobileText;
	
	@FindBy(xpath="//select[@id='Course']//option")
	private List<WebElement> courseOptions;
	
	@FindBy(xpath="//select[@id='Course']")
	private WebElement course;
	
	@FindBy(xpath="//select[@id='state']//option")
	private List<WebElement> stateOptions;
	
	@FindBy(xpath="//select[@id='state']")
	private WebElement state;
	
	@FindBy(xpath="//select[@id='city']//option")
	private List<WebElement> cityOptions;
	
	@FindBy(xpath="//select[@id='city']")
	private WebElement  city;
	
	@FindBy(xpath="//input[@name='submit' and @value='REGISTER NOW']")
	private WebElement registerNowbutton;
	
	@FindBy(xpath="//div[@class='wrapper_main']//img[@src='student/images/dashboard.jpg']")
	private WebElement condidateHomePageScreenshot;
	
	@FindBy(xpath="//a//img[@id='logo_img']")
	private WebElement homepagelogo;
	
	@FindBy(xpath="//footer//ul//li[1]")
	private WebElement helplineNumer;
	
	@FindBy(xpath="//footer//ul//li[2]")
	private WebElement techsupport;
	
	@FindBy(xpath="//footer//ul//li[3]")
	private WebElement clientemail;
	
	@FindBy(xpath="//div[@class='cprgt']")
	private WebElement copyrightcontent;
	
	
	public RegistrationPage(){
		PageFactory.initElements(driver, this);
	}
	/*public HomePage registration() {
		String sheet="registration";
		int row=1;
		String ExceldataFullNamne=excelLib.getExcelData(sheet, row, 0);
		String ExceldataEmailAddress=excelLib.getExcelData(sheet, row, 1);
		String ExceldataPassword=excelLib.getExcelData(sheet, row, 2);
		String ExceldataConfirPPassword=excelLib.getExcelData(sheet, row, 3);
		String ExceldataPhoneNumer=excelLib.getExcelData(sheet, row, 4);
		String ExceldataCourse=excelLib.getExcelData(sheet, row, 5);
		String ExceldataState=excelLib.getExcelData(sheet, row, 6);
		String ExceldataCity=excelLib.getExcelData(sheet, row, 7);
		fullNameText.sendKeys(ExceldataFullNamne);
		emailAddressText.sendKeys(ExceldataEmailAddress);
		passwordText.sendKeys(ExceldataPassword);
		confirmPasswordText.sendKeys(ExceldataConfirPPassword);
		mobileText.sendKeys(ExceldataPhoneNumer);
		int courseIndex=0;
		Reporter.log("size of the dropdown is : "+courseOptions.size(),true);
		for(WebElement crs: courseOptions) {
			if(courseOptions.get(courseIndex).getText().contains(ExceldataCourse)) {
				crs.click();
				Reporter.log("course selected ",true);
				break;
			}
		}
		course.sendKeys(ExceldataCourse);
		int stateIndex=0;
		Reporter.log("state size is : "+stateOptions.size(),true);
		for(WebElement st:stateOptions) {
			if(stateOptions.get(stateIndex).getText().contains(ExceldataState)) {
				st.click();
				Reporter.log("state selected ",true);
			}
		}
		state.sendKeys(ExceldataState);
		testUtil.threadWait(1000);
		int cityIndex=0;
		for(WebElement ct:cityOptions) {
			if(cityOptions.get(cityIndex).getText().contains(ExceldataCity)) {
				testUtil.threadWait(1000);
				ct.click();
				Reporter.log("city selected ",true);
			}
		}
		for(int i=0;i<=2;i++) {
			try {
				city.sendKeys(ExceldataCity);
				break;
			}
			catch(Exception e) {
				Reporter.log("exception ",true);
			}
		}
		//selectCity.sendKeys(city);
		registerNowbutton.click();
		return new HomePage();
	}*/
	public HomePage registration(String fullName,String email, String password, String confirmPassword, String phoneNumber,String selectCourse,String selectState,String selectCity) {
		Reporter.log(fullName+" "+"fullName page is  ",true);
		fullNameText.sendKeys(fullName);
		emailAddressText.sendKeys(email);
		passwordText.sendKeys(password);
		confirmPasswordText.sendKeys(confirmPassword);
		mobileText.sendKeys(phoneNumber);
		int courseIndex=0;
		Reporter.log("size of the course dropdown is :"+courseOptions.size(),true);
		for(WebElement courseValue:courseOptions) {
			if(courseOptions.get(courseIndex).getText().contains(selectCourse)) {
				//courseValue.click();
				Reporter.log(courseValue+" "+"Course is selected ",true);
				break;
			}
			else {
				Reporter.log("Course not found please check the Excel sheet",true);
			}
		}
		course.sendKeys(selectCourse);
		int stateIndex=0;
		Reporter.log("size of the course dropdown is :"+stateOptions.size(),true);
		for(WebElement stateValue:stateOptions ) {
			if(stateOptions.get(stateIndex).getText().equals(selectState)) {
				Reporter.log("Sate name is "+stateValue.getText(),true);
				//stateValue.click();
				break;
			}
			else {
				Reporter.log("State not cound please check the Excel sheet ",true);
			}
		}
		state.sendKeys(selectState);
		try {
			Thread.sleep(1022);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int cityIndex=0;
		Reporter.log("Size of the city is "+cityOptions.size(),true);
		for(WebElement cityValue:cityOptions ) {
			if(cityOptions.get(cityIndex).getText().contains(selectCity)) {
				cityValue.click();
				break;
			}
			else {
				Reporter.log("coty not found please check the excel sheet",true);
			}
		}
		for(int i=0;i<=2;i++) {
			try {
				city.sendKeys(selectCity);
			}
			catch(Exception e) {
				Reporter.log("Something went with select course : Registration page",true);
			}
		}
		registerNowbutton.click();
		return new HomePage();
	}

	public HomePage registrationDataProvider() {
		return new HomePage();
	}
	public boolean featuresImageValidation() {
		JsLib.scrollIntoView(condidateHomePageScreenshot);
		return condidateHomePageScreenshot.isDisplayed();
	}
	public String validateHelplinePage() {
		JsLib.scrollPagedown();
		return helplineNumer.getText();
	}
	public String validateTechSupportPage() {
		JsLib.scrollPagedown();
		return techsupport.getText();
	}
	public String validateClientEmailPage() {
		JsLib.scrollPagedown();
		return clientemail.getText();
	}
	public String validateCopyrightContentPage() {
		return copyrightcontent.getText();
	}
	
}
