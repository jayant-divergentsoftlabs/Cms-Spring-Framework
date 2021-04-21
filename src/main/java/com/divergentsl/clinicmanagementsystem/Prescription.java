package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.divergentsl.clinicmanagementsystem.dao.PrescriptionDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;

public class Prescription {
	static final Logger myLogger = Logger.getLogger(
			"Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/Prescription.java");
	private static PrescriptionDao prescriptiondao;

	
	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("Confi.xml");
		prescriptiondao = context.getBean("prescriptiondao", PrescriptionDao.class);
	}
	
	public static void prescription() {
		myLogger.setLevel(Level.FINE);
		Scanner sc = new Scanner(System.in);

		Connection con;

		System.out.println("Enter Drug Name");
		String name = sc.nextLine();
		System.out.println("Enter Drug MG");
		int mg = sc.nextInt();
		System.out.println("Enter Drug Quantity");
		int quantity = sc.nextInt();
		System.out.println("Enter Drug Days");
		int days = sc.nextInt();
		System.out.println("Enter Lab test");
		String test = sc.next();
		System.out.println("Enter the Note");
		String notes = sc.next();
		try {
			prescriptiondao.create(name, mg, quantity, days, test, notes);
			myLogger.info("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			myLogger.info("\n--------Unsuccesful ----------");
		}

	}
}
