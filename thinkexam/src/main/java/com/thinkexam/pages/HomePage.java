package com.thinkexam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.thinkexam.base.TestBase;

public class HomePage extends TestBase {
	//Home page library 
	
	@FindBy(id="fblogout")
	private WebElement logoutbutton;
	
	@FindBy(xpath="//td[@id='userName']//a")
	private WebElement userName;
	
	@FindBy(xpath="//img[@id='logo_img']")
	private WebElement homepagelogo;
	
	@FindBy(xpath="//a[@id='btnModalPopup']")
	private WebElement signInButton;
	
	@FindBy(xpath="//a[@class='profile']")
	private WebElement profilemenu;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public String validateTitle() {
		return driver.getTitle();
	}
	public boolean validateHomeLageLogo() {
		return homepagelogo.isDisplayed();
	}
	public String validateUserName() {
		return userName.getText();
	}
	public boolean logoutHomePage() {
		logoutbutton.click();
		return  signInButton.isDisplayed();
	}
	public ProfilePage clickOnProfileMenu() {
		profilemenu.click();
		return new ProfilePage();
	}
	
}
