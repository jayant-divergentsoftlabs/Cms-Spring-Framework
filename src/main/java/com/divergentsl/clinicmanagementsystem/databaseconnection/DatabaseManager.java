package com.divergentsl.clinicmanagementsystem.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class DatabaseManager implements IDatabaseManager interface and
 * establish connection for database.
 * 
 * @author Jayant
 *
 */

public class DatabaseManager implements IDatabaseManager {

	

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.exit(100);
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(IDatabaseManager.URl, IDatabaseManager.USERNAME, IDatabaseManager.PASSWORD);

	}
}
