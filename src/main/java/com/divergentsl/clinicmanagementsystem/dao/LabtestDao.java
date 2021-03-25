package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;

import com.divergentsl.clinicmanagementsystem.dto.LabtestDto;

public class LabtestDao {
	IDatabaseManager DatabaseManager;

	public LabtestDao(IDatabaseManager Databasemanager) {
		this.DatabaseManager = Databasemanager;
	}

	public void create(int id, String name, int price) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		stmt.executeUpdate("insert into labtest values ('" + id + "', '" + name + "','" + price + "')");

	}

	public List<LabtestDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from labtest");
		List<LabtestDto> labDtos = new ArrayList<>();
		while (rs.next()) {
			LabtestDto labDto = new LabtestDto();
			labDto.setId(rs.getInt(1));
			labDto.setName(rs.getString(2));
			labDto.setPrice(rs.getInt(3));

			labDtos.add(labDto);
		}
		return labDtos;

	}

	public void update(String id, String name, String price) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		String updatQuery=("UPDATE labtest SET Test_name ='" + name + "',Test_price='" + price + "' WHERE Test_id='" + id + "'");
		System.out.println(updatQuery);
		stmt.executeUpdate(updatQuery);
	}

	public void delete(String id) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM labtest WHERE Test_id='" + id + "'");

	}

	
		
	}

