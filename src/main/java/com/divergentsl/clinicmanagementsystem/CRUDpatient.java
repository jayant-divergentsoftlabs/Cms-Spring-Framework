package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.divergentsl.clinicmanagementsystem.dao.PatientDao;
import com.divergentsl.clinicmanagementsystem.dto.PatientDto;

/**
 * This class is accessible only by the admin and in this class admin can
 * Create,Read,Update and Delete the Patient.
 * 
 * @author Jayant
 *
 */
public class CRUDpatient {
	static final Logger myLogger = Logger.getLogger(
			"Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/CRUDpatient.java");
	static Scanner sc = new Scanner(System.in);
	
	
	private static PatientDao dao;

	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("Confi.xml");
		dao = context.getBean("patientdao", PatientDao.class);
		
	}
	
	public static void setDao(PatientDao dao) {
		CRUDpatient.dao = dao;
	}

	
	/**
	 * This method i.e. CRUDp is accessible by admin where admin can operate CRUD on
	 * Patient.
	 */
	public static void CRUDp() {
		myLogger.setLevel(Level.FINE);
		while (true) {
			myLogger.info("--------CRUD Patient--------");
			System.out.println("Press:- " + "\n1.Create Patient" + "\n2.See Patient list" + "\n3.Edit Patient"
					+ "\n4.Delete Patient" + "\n5.EXIT");
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
				myLogger.info("------------------Exit Successfully-----------------------");
				break;
			default:
				myLogger.info("-------------------Enter Valid Input--------------------");
			}
		}
	}

	public static void create() {

		System.out.println("Enter patient ID");
		String id = sc.next();
		System.out.println("Enter patient Name");
		String name = sc.next().trim();
		System.out.println("Enter patient Age");
		int age = sc.nextInt();
		System.out.println("Enter patient Gender");
		char gender = sc.next().charAt(0);
		System.out.println("Enter patient Contact Number");
		String contactnumber = sc.next();
		System.out.println("Enter patient Weight");
		int weight = sc.nextInt();

		try {
			dao.create(id, name, age, gender, contactnumber, weight);
			myLogger.info("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			myLogger.info("\n--------Unsuccesful ----------");
		}

	}

	public static void read() {
		myLogger.info(
				"--------------------------------------Patient List---------------------------------------------");

		try {
			List<PatientDto> dtos = dao.read();
			System.out.printf("id          name \t        age      gender\t  contactnumber\t  weight\n");

			for (PatientDto patientDto : dtos) {
				System.out.printf(" %s %30s %15s  %20s %20s %20d ", patientDto.getId(), patientDto.getName(),
						patientDto.getAge(), patientDto.getGender(), patientDto.getContactnumber(),
						patientDto.getWeight());
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.err.println(e);
			myLogger.info("----------Can't read---------");
		}

	}

	public static void update() {

		System.out.println("Enter Patient ID of doctor you want to edit");
		String id = sc.next();
		System.out.println("Enter a name you want to update");
		String name = sc.next();
		System.out.println("Enter a age you want to update");
		int age = sc.nextInt();
		System.out.println("Enter a gender you want to update");
		char gender = sc.next().charAt(0);
		System.out.println("Enter a contactnumber you want to update");
		String contactnumber = sc.next();
		System.out.println("Enter a Weight you want to update");
		int weight = sc.nextInt();
		try {
			dao.update(id, name, age, gender, contactnumber, weight);
			myLogger.info("\n-------Value  Updated-------");

		} catch (SQLException e) {

			e.printStackTrace();
			myLogger.info("\n-------Can't  Update-------");
		}
	}

	public static void delete() {

		System.out.println("Enter Patient ID you want to Delete");
		String P_Id = sc.next();

		try {
			dao.delete(P_Id);
			myLogger.info("---------------Deleted successfully-----------------");
		} catch (SQLException e) {

			e.printStackTrace();
			myLogger.info("---------------Can't Delete-----------------");
		}
	}
}
