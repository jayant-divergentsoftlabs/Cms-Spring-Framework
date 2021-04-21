package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.divergentsl.clinicmanagementsystem.dao.LabtestDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.LabtestDto;

/**
 * This class is accessible only by the admin and in this class admin can
 * Create,Read,Update and Delete the Lab Tests.
 * 
 * @author Jayant
 *
 */
public class CRUDLabtest {
	static final Logger myLogger = Logger.getLogger(
			"Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/CRUDLabTest.java");
	private static LabtestDao dao;

	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("Confi.xml");
		dao = context.getBean("labtestdao", LabtestDao.class);
	}

	/**
	 * This method i.e. CRUDtest is accessible by admin where admin can operate CRUD
	 * on test which are in Lab.
	 */
	public static void CRUDLab() {
		myLogger.setLevel(Level.FINE);
		Scanner sc = new Scanner(System.in);
		while (true) {
			myLogger.info("--------CRUD LabTest--------");
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
		try {
			dao.create(id, name, price);
			myLogger.info("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			myLogger.info("\n--------Unsuccesful ----------");
		}
	}

	public static void read() {
		myLogger.info("--------------------------------------Test List---------------------------------------------");

		try {
			List<LabtestDto> dtos = dao.read();
			// System.out.printf("%s %20s %20s",id,name,price\n);

			for (LabtestDto labDto : dtos) {

				System.out.printf("%s %20s %20s ", labDto.getId(), labDto.getName(), labDto.getPrice());
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.err.println(e);
			myLogger.info("----------Can't read---------");
		}
	}

	public static void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Test ID of test  you want to edit");
		int id = sc.nextInt();
		System.out.println("Enter a name you want to update");
		String name = sc.next();
		System.out.println("Enter a price you want to update");
		int price = sc.nextInt();

		try {
			dao.update(id, name, price);
			myLogger.info("\n-------Value  Updated-------");

		} catch (SQLException e) {

			e.printStackTrace();
			myLogger.info("\n-------Can't  Update-------");
		}
	}

	public static void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Test ID of Test you want to Delete");
		String Test_id = sc.next();

		try {
			dao.delete(Test_id);
			myLogger.info("---------------Deleted successfully-----------------");
		} catch (SQLException e) {

			e.printStackTrace();
			myLogger.info("---------------Can't Delete-----------------");
		}
	}
}
