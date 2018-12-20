
package com.thinkexam.util;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.thinkexam.base.TestBase;

public class JsLib extends TestBase  {
	static JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public static void scrollPagedown() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void scrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void drawBorder(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

}
