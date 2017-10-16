package com.test.mavenframework.uiAutomation.homePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.mavenframework.uiAutomation.testBase.TestBase;
import com.test.mavenframework.uiAutomation.uiActions.HomePage;

public class VerifyValidLogin extends TestBase{
	
	
	HomePage homepage;
	public static final Logger log = Logger.getLogger(VerifyValidLogin.class.getName());
	@BeforeTest
	public void setUp() throws IOException
	{
		init();
	}
	
	@Test
	public void verifyLoginWithValidCredentials() throws IOException
	{
		
			
				log.info("*******************Starting VerifyValidLogin Test****************");
				loadData();
				homepage = new HomePage(d);
				Reporter.log("Driver: "+d,true);
				//credentials passed through property file
				homepage.loginToAppication(OR.getProperty("username"), OR.getProperty("password"));
				log.info("*******************Finished VerifyValidLogin Test****************");
			
		
	}
	
	@AfterClass
	public void endTest()
	{
		d.close();
	}

}
