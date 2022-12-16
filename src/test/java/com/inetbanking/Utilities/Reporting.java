package com.inetbanking.Utilities;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
    public ExtentSparkReporter sparkreporter;
    public ExtentReports extent ;
    public ExtentTest logger;
    public void onStart(ITestContext context) {
                String repName = "Test-Report-"+"NewSpark.html" ;
        sparkreporter = new ExtentSparkReporter("C:\\Users\\abhil\\eclipse-workspace-new\\inetBankingV1\\" +repName);
        
			try {
				sparkreporter.loadXMLConfig("C:\\Users\\abhil\\eclipse-workspace-new\\inetBankingV1\\src\\test\\resources\\extent-reports-config.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
        sparkreporter.config().setDocumentTitle("inetBankingapp Test");
        sparkreporter.config().setReportName("Functional Testing");
        sparkreporter.config().setTheme(Theme.DARK);
        sparkreporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
                       extent = new ExtentReports();
                      extent.attachReporter(sparkreporter);
                      extent.setSystemInfo("Hostname", "localhost");
                      extent.setSystemInfo("Environment", "QA");
                      extent.setSystemInfo("user", "Ajay");
                      extent.setSystemInfo("OS", "Windows10");
                     
    }
         public void onTestSuccess(ITestResult tr) {
        	 logger = extent.createTest(tr.getName());
        	 logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
         }
         public void onTestFailure(ITestResult tr) {
        	 logger = extent.createTest(tr.getName());
             logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
             
                       String screenshotpath  = System.getProperty("user.dir")+"/src/test/resources/Screenshots/"+tr.getName()+".png";
                     File file = new File(screenshotpath);
                     if (file.exists()) {
                    	 try {
                    		 logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(screenshotpath));
                    	 }catch(Exception e){
                    		e.printStackTrace(); 
                    	 }
                    	  }
                  }
         
              public void  onTestSkipped(ITestResult tr) {
            	  logger = extent.createTest(tr.getName());
            	  logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
} 
              public void onFinish(ITestContext testContext) {
            	  extent.flush();
             }
              }
              
