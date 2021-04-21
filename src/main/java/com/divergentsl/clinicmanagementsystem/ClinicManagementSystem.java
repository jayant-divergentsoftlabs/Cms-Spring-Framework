package com.divergentsl.clinicmanagementsystem;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * In this class we will input from user that he/she want to login through
 * Doctor or Admin.
 * 
 * @return He/she have admin access then he/she will go to admin and if he/she
 *         is Doctor then then will go to doctor.
 * @author Jayant
 *
 */

public class ClinicManagementSystem {
	static final Logger myLog = Logger.getLogger(
			"Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/ClinicManagementSystem.java");
	private static AdminLogin adminLogin;
	private static DoctorLogin doctorLogin;

	
	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("Confi.xml");
         adminLogin = context.getBean("adminLogin", AdminLogin.class);
         doctorLogin = context.getBean("doctorLogin", DoctorLogin.class);
	}

	public static void show() {

		Scanner sc = new Scanner(System.in);
		while (true) {

			myLog.setLevel(Level.FINE);
			myLog.info("Enter the Login panel");
			System.out.println("1. Admin");
			System.out.println("2. Doctor");
			System.out.println("Exit");
			int Input = sc.nextInt();
			switch (Input) {
			case 1:
				if (adminLogin.adminMethod()) {
					adminLogin.adminpanel();

				} else {
					System.out.println("Wrong password");
				}

				break;
			case 2:
				doctorLogin.doctorMethod();
				int d = doctorLogin.doctor_panel();

				break;
			case 3:
				ClinicManagementSystem.show();
				myLog.info("------------------Exit Successfully-----------------------");
			default:
				myLog.info("Enter valid panel");
			}
		}
	}

}
