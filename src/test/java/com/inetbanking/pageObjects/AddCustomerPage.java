package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy (xpath = "//ul[@class='menusubnav']/li[2]/a")
	WebElement newcustomer;
	

	@FindBy (id ="dismiss-button")
	WebElement dismissbtn;

	@FindBy (xpath = "//input[@type='text']")
	WebElement txtcustomername;

	@FindBy (xpath = "//input[@type='radio']")
	WebElement rdgender;
	
	@FindBy (xpath = "//input[@name='dob']")
	WebElement txtdob;
	

	@FindBy ( xpath = "//textarea[@name='addr']")
	WebElement txtadress;
	
	@FindBy ( xpath = "//input[@name=\"city\"]")
	WebElement txtcity;
	

	@FindBy ( xpath = "//input[@name='state']")
	WebElement txtstate;
	
	@FindBy ( xpath = "//input[@name='pinno']")
	WebElement txtpin;
	
	@FindBy ( xpath = "//input[@name='telephoneno']")
	WebElement txtmobilenum;
	
	@FindBy ( xpath = "//input[@name='emailid']")
	WebElement txtemailid;
	
	@FindBy ( xpath = "//input[@name='password']")
	WebElement txtpassword;
	
	@FindBy ( xpath = "//input[@name='sub']")
	WebElement submitbtn;
	
	
	public void dismissbutton() {
		dismissbtn.click();
	}

     public void newCustomer() {
    	 newcustomer.click();
     }
     
     public void AddNewCustomerName( String cname) {
    	 txtcustomername.sendKeys(cname);
     }
     public void gender(String cgender) {
    	 rdgender.click();
     }
     public void custdob(String dd ,String mm,String yy) {
    	 txtdob.sendKeys(String.valueOf(dd));
    	 txtdob.sendKeys(String.valueOf(mm));
    	 txtdob.sendKeys(String.valueOf(yy));
    	 
     }
     public void custAdress(String cadress) {
    	 txtadress.sendKeys(cadress);
     }
     public void custCity(String ccity) {
    	 txtcity.sendKeys(ccity);
     }
     public void custState(String cstate) {
    	 txtstate.sendKeys(cstate);
     }
     public void custPin(String cpin) {
    	 txtpin.sendKeys(String.valueOf(cpin));
     }
     public void custMobileNum(String cmobilenum) {
    	 txtmobilenum.sendKeys(String.valueOf(cmobilenum));
     }
     public void custEmailid(String cemailid) {
    	 txtemailid.sendKeys(cemailid);
     }
     public void custPassword(String cpassword) {
    	 txtpassword.sendKeys(cpassword);
     }
    	 
     public void submit() {
    	 submitbtn.click();
    	      }
     
     
}