package com.test.mavenframework.uiAutomation.homePage;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.test.mavenframework.uiAutomation.database.Database;

public class DBTest {
	
	
	@Test
	public void selectDBData() throws ClassNotFoundException, SQLException
	{
		String query = "SELECT * FROM clubs";
		Database database = new Database();
		ResultSet data = database.getData(query);
		System.out.println("*******"+data+"*******");
		while(data.next())
		{
			System.out.println(data.getInt(1)+" "+data.getString(2));
		}
	}

}
