package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver ldriver;
	
	public EditCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	}
	
	
	
	@FindBy(xpath ="//ul[@class='menusubnav']/li[3]/a")
	WebElement editcustomer;
	
	@FindBy(xpath ="//input[@name='cusid']")
	WebElement txtcustomerid;
	
	@FindBy(xpath ="//input[@name='AccSubmit']")
	WebElement submitbtn;
	
	
	
	@FindBy(xpath ="//textarea[@name='addr']")
	WebElement txtaddress;
	
	@FindBy(xpath ="//input[@name='sub']")
	WebElement submitbtn1;
	
	@FindBy(xpath ="//p[@align='right']/a")
	WebElement homebtn;
	
	
          public void editCustomerdet() {
        	  editcustomer.click();
          }
          public void customerId(String cid) {
        	  txtcustomerid.sendKeys(String.valueOf(cid));
          }

          public void sumbit( ) throws Exception {
        	  submitbtn.click();
        	  Thread.sleep(3000);
       
          }
          public void address(String cadress) throws Exception {
        	  
        	  Actions action = new Actions(ldriver);
        	  action.doubleClick();
        	  txtaddress.clear(); 
        	  Thread.sleep(3000);
       txtaddress.sendKeys(cadress);
          }
          public void sumbit1() {
        	  submitbtn1.click();
        	  
          }
          public void Home() {
        	  homebtn.click();
          }
          
}
