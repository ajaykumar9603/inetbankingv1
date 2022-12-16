package com.inetbanking.testCases;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.Utilities.ReadXlUtil;
import com.inetbanking.pageObjects.LoginPage;





public class TC_LoginTest_002 extends BaseClass {
	
	@Test(dataProvider ="Logindata")
	public void loginDDT(String user,String pwd) throws Exception {
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUserName(user);
		loginpage.enterPassword(pwd);
		loginpage.clickSubmit();
		
		Thread.sleep(3000);
		
		if(IsAlertPresent()== true) {
			driver.switchTo().alert().accept();  //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);

		}
		else {
			Assert.assertTrue(true);
			loginpage.clicklogout();
			Thread.sleep(5000);
			driver.switchTo().alert().accept(); //close the logout alert
			driver.switchTo().defaultContent() ; //focus on the login
			
		}
		
	
	}
	
	public boolean IsAlertPresent() {  // user define method created  to check alert is present or not 
		try {
			driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e){
			return false;
		}
		
		
	}
	
	@DataProvider(name="Logindata")
	    String[][] getData() throws Exception{
		
		String path = "C:\\Users\\abhil\\eclipse-workspace-new\\inetBankingV1\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx";
		int rownum  = ReadXlUtil.getRowCount(path, "Sheet1");
		int cellnum = ReadXlUtil.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String [rownum][cellnum];
		
		for (int i = 1; i<=rownum;i++) {
			for (int j=0;j<cellnum;j++) {
				logindata[i-1][j]= ReadXlUtil.getcellData(path,"Sheet1" , i, j);
			}
		}
		return logindata;
	}
	 
	
	
	
        	
        
      
        
	
}
