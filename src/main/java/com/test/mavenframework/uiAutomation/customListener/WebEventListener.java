package com.test.mavenframework.uiAutomation.customListener;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.test.mavenframework.uiAutomation.testBase.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener  
{

	public static final Logger log = Logger.getLogger(WebEventListener.class.getName());
	
	
	public void afterChangeValueOf(WebElement arg0, WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement arg0, WebDriver d) {
		// TODO Auto-generated method stub
		log.info("Clicked on: "+arg0.toString());
		
	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver d) {
		// TODO Auto-generated method stub
		
		
	}

	public void afterNavigateBack(WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String arg0, WebDriver d) {
		
		
	}

	public void afterScript(String arg0, WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver d) {
		// TODO Auto-generated method stub
		log.info("Trying to find Element by: "+arg0.toString());
		
	}

	public void beforeNavigateBack(WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String arg0, WebDriver d) {
		// TODO Auto-generated method stub
		System.out.println("++++++++++++++++++++++++++++++++++");
		log.info("navigated ot: "+ arg0);
		System.out.println("++++++++++++++++++++++++++++++++++");
	}

	public void beforeScript(String arg0, WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver d) {
		// TODO Auto-generated method stub
		
	}

}
