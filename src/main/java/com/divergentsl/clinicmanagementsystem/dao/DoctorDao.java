package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.DoctorDto;

public class DoctorDao {
	IDatabaseManager DatabaseManager;

	public DoctorDao(IDatabaseManager Databasemanager) {
		this.DatabaseManager = Databasemanager;
	}

	public int create(String id, String name, String speciality, String fee) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate(
				"insert into doctor values (" + id + ", '" + name + "','" + speciality + "'," + fee + ")");

	}

	public List<DoctorDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from doctor");
		List<DoctorDto> doctorDtos = new ArrayList<>();
		while (rs.next()) {
			DoctorDto doctorDto = new DoctorDto();
			doctorDto.setId(rs.getString(1));
			doctorDto.setName(rs.getString(2));
			doctorDto.setSpeciality(rs.getString(3));
			doctorDto.setFee(rs.getString(4));
			doctorDtos.add(doctorDto);
		}
		return doctorDtos;

	}

	public int update(String id, String name, String speciality, String fee) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		String updateQuery = "UPDATE doctor SET D_name ='" + name + "', D_Speciality='" + speciality + "', D_fee='"
				+ fee + "' WHERE D_id='" + id + "'";
		System.out.println(updateQuery);
		return stmt.executeUpdate(updateQuery);

	}

	public int delete(String id) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate("DELETE FROM doctor WHERE D_id='" + id + "'");

	}

}
