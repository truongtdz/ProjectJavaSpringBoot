package com.projectbuilding.util;

import java.sql.Connection;
import java.sql.DriverManager;
<<<<<<< HEAD
=======
import java.sql.SQLException;
>>>>>>> AddAndTest

public class ConnectionDataBase {
	static final String URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String UserName = "root";
	static final String Password = "123456";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, UserName, Password);
<<<<<<< HEAD
		} catch(Exception ex) {
=======
		} catch(SQLException ex) {
>>>>>>> AddAndTest
			ex.printStackTrace();
		}
		return con;
	}
}
