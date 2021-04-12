package com.divergentsl.clinicmanagementsystem;

import java.util.*;
import java.util.logging.*;

import com.divergentsl.clinicmanagementsystem.dao.AdminDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;

/**
 * This class is for admin,only admin accessor can access it by admin's username
 * and password.
 * 
 * @author Jayant
 *
 */
public class AdminLogin {
	static final Logger myLogger = Logger.getLogger(
			"Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/AdminLogin.java");

	/**
	 * The adminMethod will check the username and password of the admin and if it
	 * is correct then it will login successfully otherwise give the another chance
	 * and will give try again.
	 * 
	 * @return
	 */

	public boolean adminMethod() {
		Scanner sc = new Scanner(System.in);

		try {
			myLogger.setLevel(Level.FINE);
            myLogger.log(Level.INFO, "-------------------Admin Panel------------------");
			
//				System.out.println("-------------------Admin Panel------------------");

			myLogger.log(Level.FINE,"\n-----Admin Login------");
			System.out.print("\nEnter Username: ");
			String username = sc.next();

			System.out.print("\nEnter Password: ");
			String password = sc.next();
			AdminDao adminDao = new AdminDao(new DatabaseManager());
			return adminDao.adminDao(username, password);

		} catch (Exception e) {
			System.out.print(e);
		}

		return true;
	}

	/**
	 * This method will perform all the operations which will access by admin. Admin
	 * will give input for specific operation.
	 */
	public static int adminpanel() {
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {

				System.out.println(
						"Select: " + "\n1.CRUD Doctor" + "\n2.CRUD Patient" + "\n3.CRUD Drugs" + "\n4.CRUD Lab Test"
								+ "\n5.Book appointment for a patient by selecting Doctor and Date/time" + "\n6.Exit");
				int a;
				a = sc.nextInt();
				switch (a) {
				case 1:

					CRUDdoctor.CRUDdr();

					break;
				case 2:
					CRUDpatient.CRUDp();
					break;
				case 3:
					CRUDdrug.CRUDdrug();
					break;
				case 4:
					CRUDLabtest.CRUDLab();
					break;
				case 5:
					Appointment.appointmentList();
					break;
				case 6:
					ClinicManagementSystem.main(null);
					myLogger.info("------------------Exit Successfully-----------------------");
					break;

				default:
					System.out.println("Please Enter valid input");
				}

			}
		}
	}
}
