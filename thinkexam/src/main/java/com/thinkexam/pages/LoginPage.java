package com.thinkexam.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.thinkexam.base.TestBase;
import com.thinkexam.util.TestUtil;


public class LoginPage extends TestBase {
	TestUtil testUtil=new TestUtil();
	//TestUtil testutil=new TestUtil();
	
	@FindBy(xpath="//div[@id='target']//ul//li[1]//a[1]")
	private WebElement loginPopUpHomeButton;

	@FindBy(xpath="//a[@id='btnModalPopup']")
	private WebElement signinbutton;
	
	@FindBy(xpath="//a[@class='forgot_pwd']")
	private WebElement 	forgotyourpasswordLink;
	
	@FindBy(xpath="//input[@id='forgotPasswordEmail']")
	private WebElement forgetPasswordInputBox;
	
	@FindBy(xpath="//input[@id='submit_forgot']")
	private WebElement forgotpasswordSubmitButton;
	
	@FindBy(xpath="//form[@id='forgotPassword']//div[contains(text(),'Your User Id')]")
	private WebElement passwordsentalerttext;
	
	@FindBy(id="loginemail")
	private WebElement useridtextbox;
	
	@FindBy(id="password")
	private WebElement passwordtextbox;
	
	@FindBy(xpath="//input[@name='lo']")
	private WebElement loginbutton;

	@FindBy(xpath="//img[@src='document/company/logo_outer.png']")
	private WebElement thinkexamlogo;
	
	public LoginPage(){
	PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateLoginPageLogo() {
		return thinkexamlogo.isDisplayed();
	}
	public  String validatePasswordRecovery(){
		signinbutton.click();
		forgotyourpasswordLink.click();
		forgetPasswordInputBox.sendKeys(prop.getProperty("PasswordRecovery"));
		forgotpasswordSubmitButton.click();
		return passwordsentalerttext.getText();		
	}
	public HomePage login(String un,String pw) {
		signinbutton.click();
		useridtextbox.sendKeys(un);
		passwordtextbox.sendKeys(pw);
		loginbutton.click();
		//When admin add Student and Login with this the same(Welcome pop up message)
		/*	String title=driver.getTitle();
		String loginPopUpClientName=title.toLowerCase();
		String beforeLoginPopUpXpath="//h1[contains(text(),'Welcome to ";
		String afterLoginPopUpXpath=" classes !')]";
		WebElement loginPopUpText=driver.findElement(By.xpath(beforeLoginPopUpXpath+loginPopUpClientName+afterLoginPopUpXpath));
		try{
			loginPopUpText.isDisplayed();
			loginPopUpHomeButton.click();
			Reporter.log("loginPopUp  Displayed ",true);
		}
		catch(Exception e) {
		Reporter.log("loginPopUp  Not Displayed ",true);
		}*/
		
		return new HomePage();
	}
	
	
}
