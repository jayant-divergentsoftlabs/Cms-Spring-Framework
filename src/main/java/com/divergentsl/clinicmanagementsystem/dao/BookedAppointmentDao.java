package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.AppointmentDto;

public class BookedAppointmentDao {
	IDatabaseManager databaseManager;

	public BookedAppointmentDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public List<AppointmentDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databaseManager.getConnection();
		stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from appointment");
		List<AppointmentDto> appointmentDtos = new ArrayList<>();
		while (rs.next()) {
			AppointmentDto appointment = new AppointmentDto();
			appointment.setAppointmentId(rs.getString(1));
			appointment.setPatientname(rs.getString(2));
			appointment.setDrId(rs.getString(3));
			appointment.setProblem(rs.getString(4));
			appointment.setAppointmentDate(rs.getString(5));
			appointment.setAppointmentTime(rs.getString(6));
			appointmentDtos.add(appointment);
		}
		return appointmentDtos;
	}

}
