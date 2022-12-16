package com.inetbanking.testCases;

 

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;



public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
    public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		   if (br.equals("CHROME")) {
			   System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			    driver = new ChromeDriver();
			    driver.manage().window().maximize();
	   }
		   else if(br.equals("Edge")){
			   System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			    driver = new EdgeDriver();
			    driver.manage().window().maximize();
		   }
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   driver.get(baseURL);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
          public void captureScreen(WebDriver driver, String tname ) throws IOException {
        	  TakesScreenshot ts = (TakesScreenshot)driver;
        File source	  = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\abhil\\eclipse-workspace-new\\inetBankingV1\\src\\test\\resources\\Screenshots\\"+tname+".png");
        FileUtils.copyFile(source, dest);
        System.out.println("Screenshot taken");
          }
          public String randomString() {
      		
        		String generatedstring = RandomStringUtils.randomAlphabetic(8);
        			
        			return generatedstring ;
        			
        		}
        		
        		public String randomNum() {
        			String gneratedstring2 =RandomStringUtils.randomNumeric(6);
        			return gneratedstring2;
        			
        			
        		}
          
}
