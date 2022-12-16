package com.inetbanking.testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;



public class TC_EditCustomerTest_004 extends BaseClass {

	
	@Test
	public void editCustomer() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSubmit();
		Thread.sleep(3000);
		EditCustomerPage editcust = new EditCustomerPage(driver);
		editcust.editCustomerdet();
		editcust.customerId("21906");
		editcust.sumbit();
		driver.switchTo().alert().accept();

		editcust.address("BIBIPET");
		editcust.sumbit1();
		Thread.sleep(2000);
		if(isAlertPresent() == true ) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);

		}
		editcust.Home();
	

		
	}
	
	  public boolean isAlertPresent() {
		   
		  try {
			  driver.switchTo().alert();
			  return true; 
		  }catch(NoAlertPresentException e) {
			  return false; 
		  }
		
		  
		
		  
	  }
	
	
}



