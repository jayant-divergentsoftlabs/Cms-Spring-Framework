package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;

public class AdminDao {
	static final Logger myLogger = Logger
			.getLogger("Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/AdminDao.java");
	
	
	IDatabaseManager databaseManager;

	public AdminDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public boolean adminDao(String username, String password) {
		try {
			myLogger.setLevel(Level.FINE);
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			con = databaseManager.getConnection();
			stmt = con.createStatement();
			if (con != null) {

				rs=stmt.executeQuery("select * from admin where A_username ='" + username + "' and A_password ='" + password + "'");
				if (rs.next()) {
					myLogger.info("Password is correct..!!");
					System.out.println("-----Admin Login Successful-----");
					return true;
				} else {
					myLogger.info("Try again..!!");
					return false;
				}
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
