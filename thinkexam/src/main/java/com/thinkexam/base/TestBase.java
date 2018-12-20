package com.thinkexam.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.thinkexam.util.TestUtil;
import com.thinkexam.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener e_listener;
	public static WebElement element;
	static Logger log= Logger.getLogger(TestBase.class);
	
	public TestBase() {
		try {
	prop=new Properties();
	FileInputStream ip=new FileInputStream("E:/Backup/thinkexam/src/main/java/com/thinkexam/config/config.properties");
	prop.load(ip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initilization() {
		log.info("****************************** Starting test cases execution  *****************************************");
		String browserName = prop.getProperty("browser");
	   if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:/Backup/thinkexam/Driver/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "E:/Backup/thinkexam/Driver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
	    e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
	    e_listener = new WebEventListener();
		e_driver.register(e_listener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
