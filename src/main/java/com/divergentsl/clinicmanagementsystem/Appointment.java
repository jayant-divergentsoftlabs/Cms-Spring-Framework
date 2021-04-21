package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.divergentsl.clinicmanagementsystem.dao.AppointmentDao;

import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;

/**
 * \ This class i.e. Appointment will accessed by admin where admin can book
 * appointment for the patient and can see the doctor list.
 * 
 * @author Jayant
 *
 */
public class Appointment {
	static final Logger myLog = Logger.getLogger(
			"Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/Appointment.java");
    private static AppointmentDao dao;

    
    static {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Confi.xml");
    	dao = context.getBean("appointmentdao", AppointmentDao.class);
    }

	/**
	 * By the help of this method i.e. appointmentList admin can Create appointment
	 * and can see doctor list.
	 */

	public static void appointmentList() {
		try (Scanner sc = new Scanner(System.in)) {
			myLog.setLevel(Level.FINE);
			myLog.info("-------------Appointment-------------");
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
			case 3:
				ClinicManagementSystem.show();
			}
		}
	}

	public static void create() {
		Scanner sc = new Scanner(System.in);
		myLog.setLevel(Level.FINE);
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

		try {
			dao.create(appointmentId, patientName, drId, problem, appointmentDate, appointmentTime);
			
			myLog.info("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			myLog.info("\n--------Unsuccesful ----------");
		}

	}

}
