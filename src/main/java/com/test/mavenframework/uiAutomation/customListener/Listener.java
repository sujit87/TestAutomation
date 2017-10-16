package com.test.mavenframework.uiAutomation.customListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.mavenframework.uiAutomation.testBase.TestBase;

public class Listener extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.isSuccess())
		{
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			String methodName = result.getName();
			
			Reporter.log("Driver: "+d,true);
			File srcFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"//src//main//java//com//test//mavenframework//uiAutomation//";
				
				File destFile = new File((String)reportDirectory+"//success_screenshots//"+methodName+"_"+formatter.format(calendar.getTime())+".png");
				
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		if(!result.isSuccess())
		{
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			String methodName = result.getName();
			
			File srcFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
			
			///uiAutomation/src/main/java/com/test/mavenframework/uiAutomation/customListener
			
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"//src//main//java//com//test//mavenframework//uiAutomation//";
				
				File destFile = new File((String)reportDirectory+"//failure_screenShots//"+methodName+"_"+formatter.format(calendar.getTime())+".png");
				
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Test is Started:" + context.getName());
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Test is finished:" + context.getName());
	}

}
