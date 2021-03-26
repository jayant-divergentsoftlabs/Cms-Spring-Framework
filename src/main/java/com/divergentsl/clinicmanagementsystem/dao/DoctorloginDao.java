package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;

public class DoctorloginDao {
	IDatabaseManager databaseManager;

	public DoctorloginDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public boolean doctorDao(String username, String password) {
		try {
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			con = databaseManager.getConnection();
			stmt = con.createStatement();
			if (con != null) {

				rs=stmt.executeQuery("select *from doctorlogin where D_username ='" + username + "' and D_password ='" + password + "'");
				if (rs.next()) {
					System.out.println("Password is correct..!!");
					System.out.println("-----Doctor Login Successful-----");
					return true;
				} else {
					System.out.println("Try again..!!");
				}
			} else {
				System.out.println("Connection error..!!");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;

	}
	

}
