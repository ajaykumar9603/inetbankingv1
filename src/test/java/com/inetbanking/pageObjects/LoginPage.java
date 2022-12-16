package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class LoginPage {
	
	  WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	  {
		  ldriver = rdriver;
		  PageFactory.initElements(rdriver,this);
		  
	  }
	   
	  
	  @FindBy(xpath = "//input[@type='text']")
	  WebElement txtusername ;
	  
	  @FindBy(xpath= "//input[@type='password']")
	  WebElement txtpassword;
	  
	  
	  
	  @FindBy(xpath = "//input[@type='submit']")
	  WebElement signbtn;
	  
	  @FindBy(xpath = "//ul[@class='menusubnav']/li[15]/a")
	  WebElement logout;
	 
	  public void enterUserName(String uname) {
		  
		  txtusername.sendKeys(uname);
	  }
	  
	  public void enterPassword (String pwd) {
		  txtpassword.sendKeys(pwd);
	  }
	  public void clickSubmit() {
		  signbtn.click();
	  }
	  public void clicklogout() {
		  logout.click();
	  }
}
