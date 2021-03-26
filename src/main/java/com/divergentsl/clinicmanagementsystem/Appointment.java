package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.divergentsl.clinicmanagementsystem.dao.AppointmentDao;
import com.divergentsl.clinicmanagementsystem.dao.DoctorDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.DoctorDto;

/**
 * \ This class i.e. Appointment will accessed by admin where admin can book
 * appointment for the patient and can see the doctor list.
 * 
 * @author Jayant
 *
 */
public class Appointment {
	/**
	 * By the help of this method i.e. appointmentList admin can Create appointment
	 * and can see doctor list.
	 */

	public static void appointmentList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------Appointment-------------");
		System.out.println("Press:- " + "\n1.Create  Appointment" + "\n2.See Doctor list" + "\n3.EXIT");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			create();
			System.out.println("----------Appointment Created Successfully----------");
			break;
		case 2:
		CRUDdoctor.read();
			System.out.println("----------This is a List of Doctors----------");
			break;

		}
	}
	public static void create() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Appointment ID");
		String appointmentId = sc.next();
		System.out.println("Enter Patient Name");
		String patientName = sc.next().trim();
		System.out.println("Enter Doctor Id ");
		String drId = sc.next().trim();
		System.out.println("Enter Problem");
		String problem = sc.next().trim();
		System.out.println("Enter Date of Appointment");
		String appointmentDate = sc.next().trim();
		System.out.println("Enter Time of Appointment");
		String appointmentTime = sc.next().trim();

		AppointmentDao doc = new AppointmentDao(new DatabaseManager());
		try {
			doc.create(appointmentId, patientName, drId, problem,appointmentDate,appointmentTime);
			System.out.println("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("\n--------Unsuccesful ----------");
		}

	}

}
