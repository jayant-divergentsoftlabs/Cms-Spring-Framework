package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.LabtestDto;

public class LabtestDao {
	IDatabaseManager databasemanager;

	public LabtestDao(IDatabaseManager Databasemanager) {
		this.databasemanager = Databasemanager;
	}

	public int create(int id, String name, int price) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databasemanager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate("insert into labtest values ('" + id + "', '" + name + "','" + price + "')");

	}

	public List<LabtestDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databasemanager.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from labtest");
		List<LabtestDto> labDtos = new ArrayList<>();
		while (rs.next()) {
			LabtestDto dto = new LabtestDto();
			dto.setId(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setPrice(rs.getInt(3));

			labDtos.add(dto);
		}
		return labDtos;

	}

	public int update(int id, String name, int price) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databasemanager.getConnection();
		stmt = con.createStatement();
		String updatQuery = ("UPDATE labtest SET Test_name ='" + name + "',Test_price='" + price + "' WHERE Test_id='"
				+ id + "'");
		System.out.println(updatQuery);
		return stmt.executeUpdate(updatQuery);
	}

	public int delete(String id) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = databasemanager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate("DELETE FROM labtest WHERE Test_id='" + id + "'");

	}

}
