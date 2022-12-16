package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		
		
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSubmit();
	 WebElement ele  = driver.findElement(By.xpath("//li[@class='orange']/a"));
	         String actualtext = ele.getText();
	         String expectedtext ="Manager";
	         		
	         if(actualtext.equals(expectedtext) ) {
	        	 Assert.assertTrue(true);
	         }
	         else {
	        	 captureScreen(driver,"loginTest");
	        	 Assert.assertTrue(false);
	         }
	}
	
	
}
