package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static Connection connection;
	public static Connection getConnection() {
		try	{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/internet-provider-app", "root", "password");
		} catch	(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
