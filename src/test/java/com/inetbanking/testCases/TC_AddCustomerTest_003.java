package com.inetbanking.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;


public class TC_AddCustomerTest_003 extends BaseClass{

	
	@Test
	public void addNewCustomer() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addCustpage = new AddCustomerPage(driver);
		
		addCustpage.newCustomer();
		addCustpage.AddNewCustomerName("Ajay");
		addCustpage.gender("male");
		addCustpage.custdob("03","01","1998" );
		Thread.sleep(5000);
		addCustpage.custAdress("INDIA");
		addCustpage.custCity("HYD");
		addCustpage.custState("Telangana");
		addCustpage.custPin("503125");
		addCustpage.custMobileNum("960300347");
		String email = randomString()+"@gmail.com";

		addCustpage.custEmailid(email);
		           String paswrd   =  randomNum();
		           addCustpage.custPassword(paswrd);
		addCustpage.submit();
		
		 
		boolean result =  driver.getPageSource().contains("Customer Registered Successfully!!!");
		 		
		if (result == true) {
		Assert.assertTrue(true);
		}else {
			captureScreen( driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
			
			
		 
		
	}
	
	
	
}
