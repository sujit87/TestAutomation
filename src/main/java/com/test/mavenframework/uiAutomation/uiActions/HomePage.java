package com.test.mavenframework.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.test.mavenframework.uiAutomation.testBase.TestBase;

public class HomePage extends TestBase{
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());

	@FindBy(xpath="//input[@id='admin_user_username']")
	private WebElement UN;
	@FindBy(xpath="//input[@id='admin_user_password']")
	private WebElement PWD;
	@FindBy(xpath="//button[@class='btn']")
	private WebElement login;
	@FindBy(xpath="//a[@class='logout']")
	private WebElement logout;
	
public HomePage(WebDriver d)//change argument type from WebDriver to EventFiringDriver
	{
		PageFactory.initElements(d, this);
	}
	
	public void loginToAppication(String userName, String password)
	{
		
				
					Reporter.log("=============Entering Data on Login Page=============", true);
					UN.clear();
					UN.sendKeys(userName);
					log.info("Entered User Name "+userName+" and object is "+UN.toString());
					PWD.clear();
					PWD.sendKeys(password);
					log.info("Entered Password "+password+" and object is "+PWD.toString());
					login.submit();
					log.info("Clicked on Login button and object is "+login.toString());
					
			
		
	}
	
	public boolean verifyLogoutDisplayed()
	{
		try {
			logout.isDisplayed();
			log.info("logout is displayed and object is "+logout.toString());
				return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void clickOnLogoutLink()
	{
		logout.click();
		log.info("Clicked on Logout link and object is"+logout.toString());
	}

}
