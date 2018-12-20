package com.thinkexam.pages;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import com.thinkexam.base.TestBase;

public class BuyPackagePage extends TestBase{
	
	public BuyPackagePage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[contains(text(),'Buy Package')]")
	private WebElement buyPackageLebel;
	
	@FindBy(xpath="(//a[@class='table-td'])[1]")
	private WebElement viewsyllabousbutton;
	
	@FindBy(xpath="//div[contains(text(),'Schedule for')]")
	private WebElement packageschedule;
	
	@FindBy(xpath="(//div[@class='newA'])[1]")
	private WebElement buypackagebutton;
	
	@FindBy(xpath="//div[@class='ord_smry_cntr']//input[@id='couponCode']")
	private WebElement couponcodeinputbox;
	
	@FindBy(xpath="//div[@class='ord_smry_cntr']//input[@value='Apply']")
	private WebElement applybutton;
	
	@FindBy(xpath="//input[@value='Make Payment']")
	private WebElement makepaymentbuttpn;
	
	@FindBy(xpath="//p[contains(text(),'Thank you. Your coupon')]")
	private WebElement transactionAcknowledge;
	
	@FindBy(xpath="//a[contains(text(),'VIEW YOUR TEST')]")
	private WebElement viewyourTestButton;
	
	
	@FindBy(xpath="//li[contains(text(),'My Test')]")
	private WebElement mytestlebel;
	
	public String validateBuyPackagePage() {
		return buyPackageLebel.getText();
	}
	public void validateViewSyllabusPage() {
		viewsyllabousbutton.click();
        Set<String> handler = driver.getWindowHandles();
	    Iterator<String> it = handler.iterator();
		String parentWindowId = it.next();
		//Reporter.log("parent window id: "+ parentWindowId,true);
		String childWindowId = it.next();
		//Reporter.log("Child window id: " +childWindowId,true);
		driver.switchTo().window(childWindowId);
		Reporter.log("child window pop up title : "+driver.getTitle(),true);
		Assert.assertTrue(packageschedule.isDisplayed(),"Package schedule page not verified");
		driver.close();
		driver.switchTo().window(parentWindowId);
		Reporter.log("parent window title is : "+driver.getTitle(),true);
	}
    public String buyNowPackage() {
    	if(buypackagebutton.isDisplayed()) {
		buypackagebutton.click();
		couponcodeinputbox.sendKeys(prop.getProperty("promocode"));
		applybutton.click();
		makepaymentbuttpn.click();
		if(transactionAcknowledge.getText().contains("Thank you.")) {
			Reporter.log("Package Bought Successfully",true);
		}
		else {
			Reporter.log("Buy Package Failed",true);
		}
    	}
    	else {
    		Reporter.log("Buy Package Button Not Display",true);
    	}
		
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
		
		
		/*viewyourTestButton.click();
		if(mytestlebel.getText().contains("My Test")) {
			Reporter.log("Test Page Displayed",true);
		}
		else {
			Reporter.log("Test Page Not Displayed",true);
		}	*/
	
		return null;
	}
   /* public TestPage clickOnViewYourTest() {
    	viewyourtestbutton.click();
    	return new TestPage();
    }*/
    public String TransactionAcknowledgementPage() {
    	return transactionAcknowledge.getText();
    }
    

	
}
