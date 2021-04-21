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
import com.divergentsl.clinicmanagementsystem.dto.DrugDto;

public class DrugDao {
	IDatabaseManager DatabaseManager;

	public DrugDao(IDatabaseManager Databasemanager) {
		this.DatabaseManager = Databasemanager;
	}

	public int create(int id, String name, int quantity, String description, int price) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate("insert into drug values (" + id + ", '" + name + "'," + quantity + ",'" + description
				+ "'," + price + ")");

	}

	public List<DrugDto> read() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from drug");
		List<DrugDto> drugDtos = new ArrayList<>();
		while (rs.next()) {
			DrugDto dto = new DrugDto();
			dto.setId(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setQuantity(rs.getInt(3));
			dto.setDescription(rs.getString(4));
			dto.setPrice(rs.getString(5));

			drugDtos.add(dto);
		}
		return drugDtos;

	}

	public int update(int id, String name, int quantity, String description, int price) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		String updateQuery = "UPDATE drug SET Drug_name ='" + name + "', Drug_quantity='" + quantity
				+ "', Drug_description='" + description + "', Drug_price='" + price + "'WHERE Drug_id='" + id + "'";
		System.out.println(updateQuery);
		return stmt.executeUpdate(updateQuery);
	}

	public int delete(String id) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		con = DatabaseManager.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate("DELETE FROM drug WHERE Drug_id='" + id + "'");

	}

}
