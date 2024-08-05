package com.projectbuilding.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDataBase {
	static final String URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String UserName = "root";
	static final String Password = "123456";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, UserName, Password);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
}
