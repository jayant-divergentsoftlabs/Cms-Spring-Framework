package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.clinicmanagementsystem.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.IDatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.AppointmentDto;
import com.divergentsl.clinicmanagementsystem.dto.DoctorDto;

public class AppointmentDao {
	IDatabaseManager databaseManager;
	
	public AppointmentDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
      public  void create(String appointmentId,String patientName,String doctorId,String problem,String appointmentDate,String appointmentTime )throws SQLException {
		
		Connection con=null;
		Statement stmt = null;
		con=databaseManager.getConnection();
		stmt = con.createStatement();
		String updateQuery=("INSERT INTO appointment values('" + appointmentId + "','" + patientName + "','"+ doctorId + "','" + problem + "','" + appointmentDate + "','" + appointmentTime +  "')");
	     stmt.executeUpdate(updateQuery);
	} 
	
	
	}

