package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.AppointmentDto;
import com.divergentsl.clinicmanagementsystem.dto.DoctorDto;

public class AppointmentDao {
	IDatabaseManager databaseManager;

	public AppointmentDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
	

	public int create(String appointmentId, String patientName, String doctorId, String problem, String appointmentDate,
			String appointmentTime) throws SQLException {

		Connection con = null;
		Statement stmt = null;
		con = databaseManager.getConnection();
		stmt = con.createStatement();
		String updateQuery = ("INSERT INTO appointment values('" + appointmentId + "','" + patientName + "','"
				+ doctorId + "','" + problem + "','" + appointmentDate + "','" + appointmentTime + "')");
		return stmt.executeUpdate(updateQuery);
	}

	public List<AppointmentDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databaseManager.getConnection();
		stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from appointment");
		List<AppointmentDto> appointmentDtos = new ArrayList<>();
		AppointmentDto dto = new AppointmentDto();
		while (rs.next()) {
			dto.setAppointmentId(rs.getString(1));
			dto.setPatientname(rs.getString(2));
			dto.setDrId(rs.getString(3));
			dto.setProblem(rs.getString(4));
			dto.setAppointmentDate(rs.getString(5));
			dto.setAppointmentTime(rs.getString(6));
			appointmentDtos.add(dto);
		}
		return appointmentDtos;
	}

}
