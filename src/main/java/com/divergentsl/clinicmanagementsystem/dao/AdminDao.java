package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;

public class AdminDao {
	IDatabaseManager databaseManager;

	public AdminDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public boolean adminDao(String username, String password) {
		try {
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			con = databaseManager.getConnection();
			stmt = con.createStatement();
			if (con != null) {

				rs=stmt.executeQuery("select * from admin where A_username ='" + username + "' and A_password ='" + password + "'");
				if (rs.next()) {
					System.out.println("Password is correct..!!");
					System.out.println("-----Admin Login Successful-----");
					return true;
				} else {
					System.out.println("Try again..!!");
					return false;
				}
			} else {
				System.out.println("Connection error..!!");
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
