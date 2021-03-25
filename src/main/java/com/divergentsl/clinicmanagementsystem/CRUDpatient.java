package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

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
	static Scanner sc = new Scanner(System.in);

	/**
	 * This method i.e. CRUDp is accessible by admin where admin can operate CRUD on
	 * Patient.
	 */
	public static void CRUDp() {

		while (true) {
			System.out.println("--------CRUD Patient--------");
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
				System.out.println("------------------Exit Successfully-----------------------");
				break;
			default:
				System.out.println("-------------------Enter Valid Input--------------------");
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

		PatientDao patient = new PatientDao(new DatabaseManager());
		try {
			patient.create(id, name, age, gender, contactnumber, weight);
			System.out.println("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("\n--------Unsuccesful ----------");
		}

	}

	public static void read() {
		System.out.println(
				"--------------------------------------Patient List---------------------------------------------");

		try {
			PatientDao patient = new PatientDao(new DatabaseManager());
			List<PatientDto> dtos = patient.read();
			System.out.printf("id          name \t        age      gender\t  contactnumber\t  weight\n");

			for (PatientDto patientDto : dtos) {
				System.out.printf(" %s %30s %15s  %20s %20s %20d ", patientDto.getId(), patientDto.getName(), patientDto.getAge(),
						patientDto.getGender(), patientDto.getContactnumber(), patientDto.getWeight());
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("----------Can't read---------");
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
			PatientDao patient = new PatientDao(new DatabaseManager());
			patient.update(id, name, age, gender, contactnumber, weight);
			System.out.println("\n-------Value  Updated-------");

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("\n-------Can't  Update-------");
		}
	}

	public static void delete() {

		System.out.println("Enter Patient ID you want to Delete");
		String P_Id = sc.next();

		try {
			PatientDao patient = new PatientDao(new DatabaseManager());
			patient.delete(P_Id);
			System.out.println("---------------Deleted successfully-----------------");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("---------------Can't Delete-----------------");
		}
	}
}
