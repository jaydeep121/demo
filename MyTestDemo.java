package com.thinkexam.demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTestDemo {
WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test
	public void navigationTest() throws Exception{
		MyScreenRecorder.startRecording("navigationTest");
		driver.get("http://www.google.com");
		driver.navigate().to("http://192.168.0.250/thinkExam/yuwamclasses/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		MyScreenRecorder.stopRecording();
	}
	@Test
	public void navigation_FeatureTest() throws Exception{
		MyScreenRecorder.startRecording("navigation_FeatureTest");
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.navigate().to("http://www.rediff.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		
		MyScreenRecorder.stopRecording();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
