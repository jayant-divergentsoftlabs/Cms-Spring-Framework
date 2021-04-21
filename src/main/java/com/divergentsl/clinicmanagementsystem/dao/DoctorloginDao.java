package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;

public class DoctorloginDao {
	static final Logger myLogger = Logger
			.getLogger("Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/AdminDao.java");
	
	private static IDatabaseManager databaseManager;
	
    public DoctorloginDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public static boolean doctorDao(String username, String password) {
		try {
			myLogger.setLevel(Level.FINE);
			Connection con = null;
			Statement stmt = null;
			con = databaseManager.getConnection();
			stmt = con.createStatement();
			if (con != null) {

				ResultSet rs=stmt.executeQuery("select *from doctorlogin where D_username ='" + username + "' and D_password ='" + password + "'");
				if (rs.next()) {
					myLogger.info("Password is correct..!!");
					myLogger.info("-----Doctor Login Successful-----");
					return true;
				} else {
					myLogger.info("Try again..!!");
				}
			} else {
				myLogger.info("Connection error..!!");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;

	}
	

}
