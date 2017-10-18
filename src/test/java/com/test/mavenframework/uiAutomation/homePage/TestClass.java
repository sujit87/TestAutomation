package com.test.mavenframework.uiAutomation.homePage;

import org.testng.annotations.Test;

import com.test.mavenframework.uiAutomation.testBase.TestBase;

public class TestClass extends TestBase 

{
@Test
public void test()
{
	for(int i=0;i<=10;i++)
	{
		System.out.println("***************"+i+"*****************");
	}
}
}
