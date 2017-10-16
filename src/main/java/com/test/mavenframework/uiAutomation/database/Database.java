package com.test.mavenframework.uiAutomation.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public Connection con;
	public Statement stmt;
	
	public Statement getStatement() throws ClassNotFoundException, SQLException
	{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String connection = "jdbc:mysql://us-cdbr-east-03.cleardb.com:3306/heroku_bbf783928275ece";
			String username = "bc0b09778eea5d";
			String password = "a1f3cdd2";
			Class.forName(driver);
			con = DriverManager.getConnection(connection, username, password);
			stmt = con.createStatement();
			return stmt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
		
	}
	
	
	public void insertData(String query) throws ClassNotFoundException, SQLException
	{
		getStatement().executeUpdate(query);
	}
	
	public ResultSet getData(String query) throws ClassNotFoundException, SQLException
	{
		ResultSet data = getStatement().executeQuery(query);
		
		return data;
	}
	
	public void updateData(String query) throws ClassNotFoundException, SQLException
	{
		getStatement().executeUpdate(query);
		
	}
}
