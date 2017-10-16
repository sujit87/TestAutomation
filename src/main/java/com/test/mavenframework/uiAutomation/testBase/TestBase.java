package com.test.mavenframework.uiAutomation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.mavenframework.uiAutomation.customListener.WebEventListener;
import com.test.mavenframework.uiAutomation.excelReader.ExcelReader;

public class TestBase 
{
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	//String browser = "firefox";
	//String URL = "http://bvc-qa.herokuapp.com/admin";
	public static WebDriver dr;
	ExcelReader excel;
	public Properties OR = new Properties();
	public WebEventListener eventListener;
	public static EventFiringWebDriver d;
	
	
	public void init() throws IOException
	{
		loadData();
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
		String log4jConfigPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfigPath);
	}
	
	public void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			dr = new FirefoxDriver();
			log.info("Creating object of "+browser);
			d = new EventFiringWebDriver(dr);
			eventListener = new WebEventListener();
			d.register(eventListener);
			
		}
	}
	
	public void getUrl(String url)
	{
		d.get(url);
		log.info("Navigating to "+url);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public String[][] getData(String excelName, String sheetName)
	{
		/*C:\Users\bvc19\workspace\\uiAutomation\\src\\main\java\com\test\mavenframework\\uiAutomation\data\testData.xlsx*/
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\mavenframework\\uiAutomation\\data\\"+excelName;
		excel = new ExcelReader(path);
		String[][] data = excel.getDataFromExcel(sheetName);
		return data;
	}
	
	
	public void loadData() throws IOException
	{
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\mavenframework\\uiAutomation\\config\\config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
	}
	
	public void takeScreenShot()
	{
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		System.out.println("===========Driver==========   "+d.toString());
		File srcFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		
		try {
			String reportDirectory = new File((String)System.getProperty("user.dir")).getAbsolutePath()+"//src//main//java//com//test//mavenframework//uiAutomation//";
			
			File destFile = new File((String)reportDirectory+"//exception_screenshots//"+"Screen_Shoot_"+formatter.format(calendar.getTime())+".png");
			
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
