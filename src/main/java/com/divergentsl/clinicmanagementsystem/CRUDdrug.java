package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.divergentsl.clinicmanagementsystem.dao.DrugDao;
import com.divergentsl.clinicmanagementsystem.dao.PatientDao;
import com.divergentsl.clinicmanagementsystem.dto.DrugDto;
import com.divergentsl.clinicmanagementsystem.dto.PatientDto;

/**
 * This class is accessible only by the admin and in this class admin can
 * Create,Read,Update and Delete the drug.
 * 
 * @author Jayant
 *
 */
public class CRUDdrug {
	/**
	 * This method i.e. CRUDdrug is accessible by admin where admin can operate CRUD
	 * on Drug .
	 */
	public static void CRUDdrug() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("-------------CRUD Drug Operation-------------");
			System.out.println("Press:- " + "\n1.Create Drug" + "\n2.See Drug list" + "\n3.Edit Drug"
					+ "\n4.Delete Drug" + "\n5.EXIT");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				create();
				
				break;
			case 2:
				read();
				
				break;
			case 3:
				update();
				
				break;
			case 4:
				delete();
				
				break;
			case 5:
				AdminLogin.adminpanel();
				
				break;
			default:
				System.out.println("-------------------Enter Valid Input--------------------");
			}
		}
	}

	public static void create() {
		Scanner sc = new Scanner(System.in);

		Connection con;

		System.out.println("Enter Drug ID");
		int id = sc.nextInt();
		System.out.println("Enter Drug Name");
		String name = sc.next().trim();
		System.out.println("Enter Drug Quantity");
		int quantity = sc.nextInt();
		System.out.println("Enter Drug Description");
		String description = sc.next();
		System.out.println("Enter Drug Price");
		int price = sc.nextInt();
		DrugDao drug = new DrugDao(new DatabaseManager());
		try {
			drug.create(id, name, quantity, description, price);
			System.out.println("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("\n--------Unsuccesful ----------");
		}
	}

	public static void read() {
		System.out.println(
				"--------------------------------------Drug List---------------------------------------------");

		try {
			DrugDao drug = new DrugDao(new DatabaseManager());
			List<DrugDto> dtos = drug.read();
			System.out.printf("id          name \t        quantity      description\t  price\n ");

			for (DrugDto drugDto : dtos) {
				System.out.printf(" %d %30s %15s  %20s ", drugDto.getId(), drugDto.getName(), drugDto.getQuantity(),
						drugDto.getDescription(), drugDto.getPrice());
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("----------Can't read---------");
		}
	}

	public static void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Drug ID  you want to edit");
		String id = sc.next();
		System.out.println("Enter a name you want to update");
		String name = sc.next();
		System.out.println("Enter a Quantity you want to update");
		String quantity = sc.next();
		System.out.println("Enter a description you want to update");
		String description = sc.next();
		System.out.println("Enter a price you want to update");
		String price = sc.next();

		try {
			DrugDao drug = new DrugDao(new DatabaseManager());
			drug.update(id, name, quantity, description, price);
			System.out.println("\n-------Value  Updated-------");

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("\n-------Can't  Update-------");
		}
	}

	public static void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter drug ID of drug you want to Delete");
		String Drug_id = sc.next();

		try {
			DrugDao drug = new DrugDao(new DatabaseManager());
			drug.delete(Drug_id);
			System.out.println("---------------Deleted successfully-----------------");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("---------------Can't Delete-----------------");
		}
	}
}
