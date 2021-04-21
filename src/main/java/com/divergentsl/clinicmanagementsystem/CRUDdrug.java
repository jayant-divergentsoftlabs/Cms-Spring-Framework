package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.divergentsl.clinicmanagementsystem.dao.DrugDao;

import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.DrugDto;

/**
 * This class is accessible only by the admin and in this class admin can
 * Create,Read,Update and Delete the drug.
 * 
 * @author Jayant
 *
 */
public class CRUDdrug {
	static final Logger myLogger = Logger
			.getLogger("Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/CRUDdrug.java");
	private static DrugDao dao;
	
	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("Confi.xml");
		dao = context.getBean("drugdao", DrugDao.class);
	}
	

	public static void setDao(DrugDao dao) {
		CRUDdrug.dao = dao;
	}

	/**
	 * This method i.e. CRUDdrug is accessible by admin where admin can operate CRUD
	 * on Drug .
	 */
	public static void CRUDdrug() {
		Scanner sc = new Scanner(System.in);
		myLogger.setLevel(Level.FINE);
		while (true) {
			myLogger.info("-------------CRUD Drug Operation-------------");
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

		try {
			dao.create(id, name, quantity, description, price);
			myLogger.info("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			myLogger.info("\n--------Unsuccesful ----------");
		}
	}

	public static void read() {
		System.out.println(
				"--------------------------------------Drug List---------------------------------------------");

		try {

			List<DrugDto> dtos = dao.read();
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
		int id = sc.nextInt();
		System.out.println("Enter a name you want to update");
		String name = sc.next();
		System.out.println("Enter a Quantity you want to update");
		int quantity = sc.nextInt();
		System.out.println("Enter a description you want to update");
		String description = sc.next();
		System.out.println("Enter a price you want to update");
		int price = sc.nextInt();

		try {

			dao.update(id, name, quantity, description, price);

			myLogger.info("\n-------Value  Updated-------");

		} catch (SQLException e) {

			e.printStackTrace();
			myLogger.info("\n-------Can't  Update-------");
		}
	}

	public static void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter drug ID of drug you want to Delete");
		String Drug_id = sc.next();

		try {

			dao.delete(Drug_id);
			myLogger.info("---------------Deleted successfully-----------------");
		} catch (SQLException e) {

			e.printStackTrace();
			myLogger.info("---------------Can't Delete-----------------");
		}
	}
}
