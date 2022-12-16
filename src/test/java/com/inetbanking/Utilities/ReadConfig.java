package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig (){
		
		File file = new File("./src/test/resources/Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	public String getApplicationURL() {
		String url= pro.getProperty("baseURL");
		return url ;
		
	}
	public String getUserName() {
		String uname= pro.getProperty("username");
		return uname;
	}
   public String getPassword() {
	   String pasword = pro.getProperty("password");
	return pasword;
	   
   }
   public String getChromepath() {
	String chrome  = pro.getProperty("chromepath");
	return chrome ;
	   
   }
   public String getEdgePath() {
	   String firefox = pro.getProperty("edgepath");
	return firefox;
   }
}
