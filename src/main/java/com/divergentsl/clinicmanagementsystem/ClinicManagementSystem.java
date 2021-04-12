package com.divergentsl.clinicmanagementsystem;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * In this class we will input from user that he/she want to login through Doctor or Admin.
 * @return  He/she have admin access then he/she will go to admin and if he/she is Doctor then then will go to doctor.
 * @author Jayant
 *
 */

public class ClinicManagementSystem {
	static final Logger myLog = Logger.getLogger(
			"Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/ClinicManagementSystem.java");
	public static void main(String[] args) {

		while (true) {
			AdminLogin admin = new AdminLogin();
			DoctorLogin doctor = new DoctorLogin();
			Scanner sc = new Scanner(System.in);
		    myLog.setLevel(Level.FINE);
			myLog.info("Enter the Login panel");
			System.out.println("1. Admin");
			System.out.println("2. Doctor");
			System.out.println("Exit");
			int Input = sc.nextInt();
			switch (Input) {
			case 1:
				if (admin.adminMethod()) {
					AdminLogin.adminpanel();

				} else {
					System.out.println("Wrong password");
				}

				break;
			case 2:
                DoctorLogin.doctorMethod();
				int d=doctor.doctor_panel();

				break;
			case 3:
				ClinicManagementSystem.main(null);
				myLog.info("------------------Exit Successfully-----------------------");
			default:
				myLog.info("Enter valid panel");
			}
		}
		}

	

}
