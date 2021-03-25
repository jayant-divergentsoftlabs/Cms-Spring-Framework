package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * This interface i.e. IDatabaseManager will give a defined username,password  and path of database. 
 * @author Jayant
 *
 */
public interface IDatabaseManager {
	String USERNAME = "root";

	String PASSWORD = "root";

	String URl = "jdbc:mysql://localhost:3306/clinic-management-system";

	public Connection getConnection() throws SQLException ;
	
	}


