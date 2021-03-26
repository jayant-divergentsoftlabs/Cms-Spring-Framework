package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;

public class PrescriptionDao {
	IDatabaseManager DatabaseManager;

	public PrescriptionDao(IDatabaseManager Databasemanager) {
		this.DatabaseManager = Databasemanager;
	}
	public int create(String name, int mg, int quantity, int days, String test,String notes)
			throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate( "INSERT INTO prescription values('" + name + "','" + mg+ "','" + quantity+ "','" + days+ "','" + test+ "','" + notes + "')");
		

}
	
	
}
