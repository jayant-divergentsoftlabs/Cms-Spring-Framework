package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;

import com.divergentsl.clinicmanagementsystem.dto.PatientDto;

public class PatientDao {
	IDatabaseManager DatabaseManager;

	public PatientDao(IDatabaseManager Databasemanager) {
		this.DatabaseManager = Databasemanager;
	}

	public void create(String id, String name, int age, char gender, String contactnumber, int weight)
			throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		stmt.executeUpdate("insert into patient values ( '" + id + "' , '" + name + "' , " + age + " , '" + gender
				+ "' , '" + contactnumber + "' , " + weight + " )");

	}

	public List<PatientDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from patient");
		List<PatientDto> patientDtos = new ArrayList<>();
		while (rs.next()) {
			PatientDto patientDto = new PatientDto();
			patientDto.setId(rs.getString(1));
			patientDto.setName(rs.getString(2));
			patientDto.setAge(rs.getInt(3));
			patientDto.setGender(rs.getCharacterStream(4));
			patientDto.setContactnumber(rs.getString(5));
			patientDto.setWeight(rs.getInt(6));
			patientDtos.add(patientDto);
		}
		return patientDtos;

	}

	public void update(String id, String name, int age, char gender, String contactnumber, int weight)
			throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		String updateQuery = "UPDATE patient SET P_name  ='" + name + "', P_age= " + age + ", P_Gender= '" + gender
				+ "', P_contactnumber ='" + contactnumber + "', P_weight =" + weight + " WHERE P_id='" + id + "'";
		System.out.println(updateQuery);
		stmt.executeUpdate(updateQuery);
	}

	public void delete(String id) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM patient WHERE P_id='" + id + "'");

	}

}
