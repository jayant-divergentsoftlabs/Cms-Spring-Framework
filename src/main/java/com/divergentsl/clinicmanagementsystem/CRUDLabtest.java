package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;
import java.util.*;

import com.divergentsl.clinicmanagementsystem.dao.LabtestDao;
import com.divergentsl.clinicmanagementsystem.dto.LabtestDto;

/**
 * This class is accessible only by the admin and in this class admin can
 * Create,Read,Update and Delete the Lab Tests.
 * 
 * @author Jayant
 *
 */
public class CRUDLabtest {
	/**
	 * This method i.e. CRUDtest is accessible by admin where admin can operate CRUD
	 * on test which are in Lab.
	 */
	public static void CRUDLab() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("--------CRUD LabTest--------");
			System.out.println("Press:- " + "\n1.Create Test" + "\n2.See Test list" + "\n3.Edit Test"
					+ "\n4.Delete Test" + "\n5.EXIT");
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

		System.out.println("Enter Test ID");
		int id = sc.nextInt();
		System.out.println("Enter Test Name");
		String name = sc.next().trim();
		System.out.println("Enter Test Price");
		int price = sc.nextInt();
		LabtestDao labtest = new LabtestDao(new DatabaseManager());
		try {
			labtest.create(id, name, price);
			System.out.println("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("\n--------Unsuccesful ----------");
		}
	}

	public static void read() {
		System.out.println(
				"--------------------------------------Test List---------------------------------------------");

		try {
			LabtestDao labtest = new LabtestDao(new DatabaseManager());
			List<LabtestDto> dtos = labtest.read();
			//System.out.printf("%s %20s %20s",id,name,price\n);

			for (LabtestDto labDto : dtos) {
				
				System.out.printf("%s %20s %20s ", labDto.getId(), labDto.getName(), labDto.getPrice());
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("----------Can't read---------");
		}
	}

	public static void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Test ID of test  you want to edit");
		String id = sc.next();
		System.out.println("Enter a name you want to update");
		String name = sc.next();
		System.out.println("Enter a price you want to update");
		String price = sc.next();

		try {
			LabtestDao labtest = new LabtestDao(new DatabaseManager());
			labtest.update(id, name, price);
			System.out.println("\n-------Value  Updated-------");

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("\n-------Can't  Update-------");
		}
	}

	public static void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Test ID of Test you want to Delete");
		String Test_id = sc.next();

		try {
			LabtestDao labtest = new LabtestDao(new DatabaseManager());
			labtest.delete(Test_id);
			System.out.println("---------------Deleted successfully-----------------");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("---------------Can't Delete-----------------");
		}
	}
}
