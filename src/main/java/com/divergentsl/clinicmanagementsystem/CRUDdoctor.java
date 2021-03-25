package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

import java.util.*;

import com.divergentsl.clinicmanagementsystem.dao.DoctorDao;
import com.divergentsl.clinicmanagementsystem.dto.DoctorDto;

/**
 * This class is accessible only by the admin and in this class admin can
 * Create,Read,Update and Delete the doctor.
 * 
 * @author Jayant
 *
 */
public class CRUDdoctor {
	static Scanner sc = new Scanner(System.in);

	/**
	 * This method i.e. CRUDdr is accessible by admin where admin can operate CRUD
	 * on doctor.
	 */
	public void CRUDdr() {

		while (true) {

			System.out.println("----------CRUD Operation for Doctor----------");
			System.out.println("Press:- " + "\n1.Create Doctor" + "\n2.See doctor list" + "\n3.Edit Doctor"
					+ "\n4.Delete Doctor" + "\n5.EXIT");
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

				break;
			default:
				System.out.println("-------------------Enter Valid Input--------------------");
				break;
			}
		}
	}

	public static void create() {

		System.out.println("Enter Doctor ID");
		String id = sc.next();
		System.out.println("Enter Doctor Name");
		String name = sc.next().trim();
		System.out.println("Enter Doctor Speciality");
		String speciality = sc.next().trim();
		System.out.println("Enter Doctor Fee");
		String fee = sc.next();

		DoctorDao doc = new DoctorDao(new DatabaseManager());
		try {
			doc.create(id, name, speciality, fee);
			System.out.println("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("\n--------Unsuccesful ----------");
		}

	}

	public static void read() {
		System.out.println(
				"--------------------------------------Doctor List---------------------------------------------");

		try {
			DoctorDao doa = new DoctorDao(new DatabaseManager());
			List<DoctorDto> dtos = doa.read();
//			System.out.printf("id          name \t        speciality      fee\n");

			for (DoctorDto doctorDto : dtos) {
				System.out.printf(" %s %30s %15s  %20s ", doctorDto.getId(), doctorDto.getName(),doctorDto.getSpeciality(), doctorDto.getFee());
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("----------Can't read---------");
		}

	}

	public static void update() {

		System.out.println("Enter Doctor ID of doctor you want to edit");
		String id = sc.next();
		System.out.println("Enter a name you want to update");
		String name = sc.next();
		System.out.println("Enter a speciality you want to update");
		String speciality = sc.next();
		System.out.println("Enter a fee you want to update");
		String fee = sc.next();

		try {
			DoctorDao doc = new DoctorDao(new DatabaseManager());
			doc.update(id, name, speciality, fee);
			System.out.println("\n-------Value  Updated-------");

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("\n-------Can't  Update-------");
		}
	}

	public static void delete() {

		try {
			DoctorDao doc = new DoctorDao(new DatabaseManager());
			System.out.println("Enter Doctor ID of doctor you want to Delete");
			String D_Id = sc.next();
			doc.delete(D_Id);
			System.out.println("---------------Deleted successfully-----------------");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("---------------Can't Delete-----------------");
		}
	}

}
