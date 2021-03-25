package com.divergentsl.clinicmanagementsystem;

import java.util.*;

/**
 * In this class we will input from user that he/she want to login through Doctor or Admin.
 * @return  He/she have admin access then he/she will go to admin and if he/she is Doctor then then will go to doctor.
 * @author Jayant
 *
 */

public class ClinicManagementSystem {
	public static void main(String[] args) {

		while (true) {
			AdminLogin admin = new AdminLogin();
			DoctorLogin doctor = new DoctorLogin();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Login panel");
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
				System.out.println("------------------Exit Successfully-----------------------");
			default:
				System.out.println("Enter valid panel");
			}

		}

	}

}
