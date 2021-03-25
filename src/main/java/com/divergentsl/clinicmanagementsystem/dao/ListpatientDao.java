package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.PatientDto;

public class ListpatientDao {
	IDatabaseManager DatabaseManager;

	public ListpatientDao(IDatabaseManager Databasemanager) {
		this.DatabaseManager = Databasemanager;
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
			patientDto.getWeight();
			patientDtos.add(patientDto);
		}
		return patientDtos;

	}

}
