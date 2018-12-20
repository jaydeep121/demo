package com.thinkexam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.thinkexam.base.TestBase;

public class ReportPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Report')]")
	private WebElement reportPageLink;
	
	@FindBy(xpath="//li[@class='coupon-top' and text()='Report']")
	private WebElement reportPage;
	
	@FindBy(xpath="//a[contains(text(),'PositiveTest')]")
	private WebElement positiveTest;
	
	@FindBy(xpath="//a[contains(text(),'NegativeTest')]")
	private WebElement negativeTest;
	
	@FindBy(xpath="//div[@id='testAnalysis']//div[1]//div[2]//div[1]//div[2]")
	private WebElement myMarks;
	
	public ReportPage () {
		PageFactory.initElements(driver, this);
	}
	public String validateReportPage() {
		reportPageLink.click();
		return reportPage.getText();
	}
	public String postiveMarksValidation() {
		positiveTest.click();
		return myMarks.getText();
	}
	public String negativeMarksValidation() {
		negativeTest.click();
		return myMarks.getText();
	}

}
