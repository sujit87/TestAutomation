package com.test.mavenframework.uiAutomation.homePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.mavenframework.uiAutomation.testBase.TestBase;
import com.test.mavenframework.uiAutomation.uiActions.HomePage;

public class VerifyLoginWithDifferentRecords extends TestBase {
	
	HomePage home;
	
	@DataProvider(name="logindata")
	public String[][] getTestData()
	{
		String[][] testRecords = getData("testData.xlsx", "Sheet1");
		return testRecords;
	}
	
	@BeforeClass
	public void setUp() throws IOException
	{
		init();
		home = new HomePage(d);
		Reporter.log("Driver: "+d,true);
	}
	
	@Test(dataProvider="logindata")
	public void verifyloginWithDifferentRecords(String userName, String password, String runMode)
	{
		if(runMode.equalsIgnoreCase("n"))
		{
			Reporter.log("User marked this record as no run",true);
			
		}
		else{
		log.info("============= Strting VerifyLoginWithDifferentRecords Test===========");
		home.loginToAppication(userName, password);
		
		boolean status = home.verifyLogoutDisplayed();
		if(status)
		{
			home.clickOnLogoutLink();
		}
		Assert.assertEquals(status, true);
		
		log.info("============= Finished VerifyLoginWithDifferentRecords Test===========");
	}
	}

}
