package com.divergentsl.clinicmanagementsystem;

import java.util.*;

import com.divergentsl.clinicmanagementsystem.dao.DoctorDao;
import com.divergentsl.clinicmanagementsystem.dao.DoctorloginDao;

/**
 * This class is for Doctors,only doctor who have a doctor access can access it
 * by doctor's username and password.
 * 
 * @author Jayant
 *
 */
public class DoctorLogin {
	static Scanner sc = new Scanner(System.in);

	/**
	 * In this method i.e. DoctorMethod it will check the doctor's username and
	 * password if it is correct then the user can access doctor's functionalities.
	 */

	public static boolean doctorMethod() {

		try {
			System.out.println("-------------------Doctor Panel------------------");

			System.out.println("\n-----Doctor Login------");
			System.out.print("\nEnter Username: ");
			String username = sc.nextLine();

			System.out.print("\nEnter Password: ");
			String password = sc.nextLine();
			DoctorloginDao doctorDao=new DoctorloginDao(new DatabaseManager());
			return doctorDao.doctorDao(username,password);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * This method will perform all the operations which will access by Doctor.
	 * Doctor will give input for specific operation.
	 */

	public int doctor_panel() {

		System.out.println("Select: " + "\n1.List of patient" + "\n2.Add prescription and notes for a patient"
				+ "\n3.See booked appointments" + "\n4.Check patient history and his prescription" + "\n5.Exit");
		int a = sc.nextInt();
		
		switch (a) {
		case 1:
			Listpatient.listPatient();
			
			break;
		case 2:
			Prescription.prescription();
			
			break;
		case 3:
			BookedAppointment.bookedAppointment();
			
			break;
		case 4:
//			Prescription.prescription();
			break;
		case 5:
			ClinicManagementSystem.main(null);
			System.out.println("------------------Exit Successfully-----------------------");
			break;

		}
		return a;
	}

}
