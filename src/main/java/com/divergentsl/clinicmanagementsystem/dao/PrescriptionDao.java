package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;

public class PrescriptionDao {
	IDatabaseManager DatabaseManager;

	public PrescriptionDao(IDatabaseManager Databasemanager) {
		this.DatabaseManager = Databasemanager;
	}
	public void create(String name, String mg, String quantity, String days, String test,String notes)
			throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		stmt.executeUpdate( "INSERT INTO prescription values('" + name + "','" + mg+ "','" + quantity+ "','" + days+ "','" + test+ "','" + notes + "')");
		

}
}
