package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.DoctorDto;
import com.divergentsl.clinicmanagementsystem.dto.PatientDto;

public class PatientDao {
	IDatabaseManager DatabaseManager;

	public PatientDao(IDatabaseManager Databasemanager) {
		this.DatabaseManager = Databasemanager;
	}

	public int create(String id, String name, int age, char gender, String contactnumber, int weight)
			throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate("insert into patient values ( '" + id + "' , '" + name + "' , " + age + " , '"
				+ gender + "' , '" + contactnumber + "' , " + weight + " )");

	}

	public List<PatientDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from patient");
		List<PatientDto> patientDtos = new ArrayList<>();
		while (rs.next()) {
			
			PatientDto dto = new PatientDto();
			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setAge(rs.getInt(3));
			dto.setGender(rs.getCharacterStream(4));
			dto.setContactnumber(rs.getString(5));
			dto.setWeight(rs.getInt(6));
			patientDtos.add(dto);
		}
		return patientDtos;

	}

	public int update(String id, String name, int age, char gender, String contactnumber, int weight)
			throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		String updateQuery = "UPDATE patient SET P_name  ='" + name + "', P_age= " + age + ", P_Gender= '" + gender
				+ "', P_contactnumber ='" + contactnumber + "', P_weight =" + weight + " WHERE P_id='" + id + "'";
		System.out.println(updateQuery);
		return stmt.executeUpdate(updateQuery);
	}

	public int delete(String id) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate("DELETE FROM patient WHERE P_id='" + id + "'");

	}

}
