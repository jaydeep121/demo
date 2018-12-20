package com.thinkexam.pages;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.thinkexam.base.TestBase;

public class MyTestPage extends TestBase {
	
	
	@FindBy(xpath="//a[@class='test']")
	private WebElement myTestLink;
	
	@FindBy(xpath="//a[contains(text(),'PositiveTest')]")
	private WebElement 	startPositiveTest;
	
	@FindBy(xpath="//a[contains(text(),'NegativeTest')]")
	private WebElement 	startNegativeTest;
	
	@FindBy(xpath="//div[@id='condition']//label")
	private WebElement startTestInstruction;
	
	@FindBy(xpath="//input[@id='startTest']")
	private WebElement startTestWindow;
	
	@FindBy(xpath="//a[contains(text(),'View Full Screen')]")
	private WebElement viewFullScreenButton;
	
	/*Sinlge Choice Question */

	@FindBy(xpath="//div[@id='formdiv']//div[1]//ul[1]//label[1]//li[1]//input[1]")
	private WebElement singleChoiceOptionA;
	
	@FindBy(xpath="//div[@id='formdiv']//div[3]//ul[1]//label[1]//li[1]//input[1]")
	private WebElement singleChoiceOptionC;
	
	
	/*Multiple Choice Question */
	@FindBy(xpath="//input[@id='mcqMultiple' and @value='a']")
	private WebElement multipleChoiceOptionA;
	
	@FindBy(xpath="//input[@id='mcqMultiple' and @value='b' ]")
	private WebElement multipleChoiceOptionB;
	
	@FindBy(xpath="//input[@id='mcqMultiple' and @value='c' ]")
	private WebElement multipleChoiceOptionC;
	
	@FindBy(xpath="//input[@id='mcqMultiple' and @value='d' ]")
	private WebElement multipleChoiceOptionD;
	
	/*True False Question */
	
	@FindBy(xpath="//li[@onclick='trueFalseCheck(1)']")
	private WebElement trueOption;
	
	@FindBy(xpath="//li[@onclick='trueFalseCheck(0)']")
	private WebElement falseOption;
	
	/*FIB Question */
	
	@FindBy(xpath="//input[@id='mcqFB_1']")
	private WebElement fillInTheBlankOption;
	
	/*MF Question */
	
	@FindBy(xpath="//input[@name='mcqMatchtheFollowing_a' and @value='a-q']")
	private WebElement mFOptionaOfq;
	
	@FindBy(xpath="//input[@name='mcqMatchtheFollowing_b' and @value='b-q']")
	private WebElement mFOptionbOfq;
	
	@FindBy(xpath="//input[@name='mcqMatchtheFollowing_c' and @value='c-q']")
	private WebElement mFOptioncOfq;
	
	@FindBy(xpath="//input[@name='mcqMatchtheFollowing_d' and @value='d-q']")
	private WebElement mFOptiondOfq;
	
	/*MM Question */
	
	@FindBy(xpath="//input[@id='mcqMatchMatrix' and @value='a-p']")
	private WebElement mMOptionaOfp;
	
	@FindBy(xpath="//input[@id='mcqMatchMatrix' and @value='a-q']")
	private WebElement mMOptionaOfq;
	
	@FindBy(xpath="//input[@id='mcqMatchMatrix' and @value='b-p']")
	private WebElement mMOptionbOfp;
	
	@FindBy(xpath="//input[@id='mcqMatchMatrix' and @value='b-q']")
	private WebElement mMOptionbOfq;
	
	@FindBy(xpath="//input[@id='mcqMatchMatrix' and @value='c-p']")
	private WebElement mMOptioncOfp;
	
	@FindBy(xpath="//input[@id='mcqMatchMatrix' and @value='c-q']")
	private WebElement mMOptioncOfq;
	
	@FindBy(xpath="//input[@id='mcqMatchMatrix' and @value='d-p']")
	private WebElement mMOptiondOfp;
	
	@FindBy(xpath="//input[@id='mcqMatchMatrix' and @value='d-q']")
	private WebElement mMOptiondOfq;
	
	@FindBy(xpath="//a[contains(text(),'Save & Next')]")
	private WebElement saveAndNextButton;
	
	@FindBy(xpath="//td[@colspan='2']")
	private WebElement submitTest;
	
	@FindBy(xpath="//div[@id='end-test-popup']//h1[contains(text(),'End Test')]")
	private WebElement endTestPopUp;
	
	@FindBy(xpath="//div[@id='end-test-popup']//div[contains(text(),'Ok')]")
	private WebElement endTestPopUpOkButton;
	
	@FindBy(xpath="//div[@id='end-test-popup']//div[contains(text(),'Cancel')]")
	private WebElement endTestPopUpCancelButton;
	
	@FindBy(xpath="//a[@href='#'][contains(text(),'Close')]")
	private WebElement giveFeedbackClose;
	
	@FindBy(xpath="//tbody//tr[2]//td[11]")
	private WebElement totalMarks;
	
	@FindBy(xpath="//a[@onclick='summaryClose()']")
	private WebElement testSummaryClose;
	
	public MyTestPage(){
		PageFactory.initElements(driver, this);
	}
	public String positiveTestAttemptValidation() {
		myTestLink.click();
		startPositiveTest.click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
	    String parentWindowId = it.next();
	    Reporter.log("parent window id: "+ parentWindowId,true);
		String childWindowId = it.next();
		Reporter.log("Child window id: "+childWindowId,true);
		driver.switchTo().window(childWindowId);
		startTestInstruction.click();
		startTestWindow.click();
		try {
			Thread.sleep(2000);
			//viewFullScreenButton.click();
			//Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		singleChoiceOptionA.click();
		
		saveAndNextButton.click();
		multipleChoiceOptionA.click();
		multipleChoiceOptionB.click();
		saveAndNextButton.click();
		trueOption.click();
		saveAndNextButton.click();
		fillInTheBlankOption.sendKeys("isSelected()");
		saveAndNextButton.click();
		mFOptionaOfq.click();
		mFOptionbOfq.click();
		mFOptioncOfq.click();
		mFOptiondOfq.click();
		saveAndNextButton.click();
		mMOptionaOfp.click();
		mMOptionaOfq.click();
		mMOptionbOfp.click();
		mMOptioncOfq.click();
		mMOptiondOfp.click();
		submitTest.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		endTestPopUpOkButton.click();
		giveFeedbackClose.click();
		String data=totalMarks.getText();
		testSummaryClose.click();
		driver.switchTo().window(parentWindowId);
		
		return data;
	}
	public String  negativeTestAttemptValidation() {
		//myTestLink.click();
		startNegativeTest.click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
	    String parentWindowId = it.next();
	    Reporter.log("parent window id: "+ parentWindowId,true);
		String childWindowId = it.next();
		Reporter.log("Child window id: "+childWindowId,true);
		driver.switchTo().window(childWindowId);
		startTestInstruction.click();
		startTestWindow.click();
		try {
			Thread.sleep(2000);
			//viewFullScreenButton.click();
			//Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		singleChoiceOptionC.click();
		saveAndNextButton.click();
		multipleChoiceOptionA.click();
		multipleChoiceOptionD.click();
		saveAndNextButton.click();
		falseOption.click();
		saveAndNextButton.click();
		fillInTheBlankOption.sendKeys("isSelected()132");
		saveAndNextButton.click();
		mFOptionaOfq.click();
		mFOptionbOfq.click();
		mFOptioncOfq.click();
		//mFOptiondOfq.click();
		saveAndNextButton.click();
		//mMOptionaOfp.click();
		//mMOptionaOfq.click();
		mMOptionbOfp.click();
		mMOptioncOfq.click();
		mMOptiondOfp.click();
		submitTest.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		endTestPopUpOkButton.click();
		giveFeedbackClose.click();
		String data=totalMarks.getText();
		testSummaryClose.click();
		driver.switchTo().window(parentWindowId);
		
		
		return data;
	}
	public String validateSingleChoise() {
		return null;
	}
}
