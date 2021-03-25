package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.DrugDto;

public class DrugDao {
	IDatabaseManager DatabaseManager;

	public DrugDao(IDatabaseManager Databasemanager) {
		this.DatabaseManager = Databasemanager;
	}

	public void create(int id, String name, int quantity, String description, int price) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		stmt.executeUpdate("insert into drug values (" + id + ", '" + name + "'," + quantity + ",'" + description+ "'," + price + ")");

	}

	public List<DrugDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from drug");
		List<DrugDto> drugDtos = new ArrayList<>();
		while (rs.next()) {
			DrugDto drugDto = new DrugDto();
			drugDto.setId(rs.getInt(1));
			drugDto.setName(rs.getString(2));
			drugDto.setQuantity(rs.getInt(3));
			drugDto.setDescription(rs.getString(4));
			drugDto.setPrice(rs.getString(5));

			drugDtos.add(drugDto);
		}
		return drugDtos;

	}

	public void update(String id, String name, String quantity, String description, String price) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		String updateQuery = "UPDATE drug SET Drug_name ='" + name + "', Drug_quantity='" + quantity + "', Drug_description='" + description + "', Drug_price='" + price + "'WHERE Drug_id='" + id + "'";
		System.out.println(updateQuery);
		stmt.executeUpdate(updateQuery);
	}

	public void delete(String id) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM drug WHERE Drug_id='" + id + "'");

	}

}
