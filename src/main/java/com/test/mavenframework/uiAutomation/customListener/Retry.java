package com.test.mavenframework.uiAutomation.customListener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer{
	
	public static final Logger log = Logger.getLogger(Retry.class.getName());

	public boolean retry(ITestResult result) {
		
		int retryCount = 0;
		int maxCount = 2;
		
		if(retryCount<maxCount)
		{
		log("Retrying test "+result.getName()+" with status "+getResultStatusName(result.getStatus())+" for the "+(retryCount+1)+"time(s).");
		retryCount++;
		return true;
		}
		return false;
	}
	
	public String getResultStatusName(int status)
	{
		String statusName = null;
		
		if(status == 1)
			statusName = "SUCCESS";
		if(status == 2)
			statusName = "FAILURE";
		if(status == 3)
			statusName = "SKIP";
		return statusName;
		
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}

}
