package com.thinkexam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.thinkexam.base.TestBase;

public class ProfilePage extends TestBase {
 
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//strong[contains(text(),'Personal Information')]")
	private WebElement personalinformationleel;
	
	@FindBy(xpath="//strong[contains(text(),'Security')]")
	private WebElement securityleel;
	
	@FindBy(xpath="//strong[contains(text(),'Enrollment Information ')]")
	private WebElement enrollmentinformation;
	
	@FindBy(xpath="//a[@class='package']")
	private WebElement buypackagemenu;
	
	@FindBy(xpath="//a[contains(text(),'Report')]")
	private WebElement reportPage;
	
	public String validatePersonalInformationLebelPage() {
		return personalinformationleel.getText();
	}
	public String validateSecurityLebelPage() {
		return securityleel.getText();
	}
	public String validateEnrollmentInformationLebelPage() {
		return enrollmentinformation.getText();
	}
	public BuyPackagePage clickOnBuyPackageLink() {
		buypackagemenu.click();
		return new BuyPackagePage();
	}
	public ReportPage clickOnReportLink() {
		reportPage.click();
		return new ReportPage();
	}
  
	
	
}
