package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.divergentsl.clinicmanagementsystem.dao.DoctorDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.DoctorDto;

/**
 * This class is accessible only by the admin and in this class admin can
 * Create,Read,Update and Delete the doctor.
 * 
 * @author Jayant
 *
 */
public class CRUDdoctor {
	static final Logger myLogger = Logger.getLogger(
			"Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/CRUDdoctor.java");
	static Scanner sc = new Scanner(System.in);
	
	private static DoctorDao dao;

	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("Confi.xml");
		dao = context.getBean("doctordao", DoctorDao.class);
	}
	

	/**
	 * This method i.e. CRUDdr is accessible by admin where admin can operate CRUD
	 * on doctor.
	 */
	public static void CRUDdr() {

		while (true) {
			myLogger.setLevel(Level.FINE);
			myLogger.info("----------CRUD Operation for Doctor----------");
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
				myLogger.info("-------------------Enter Valid Input--------------------");
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

		try {
			dao.create(id, name, speciality, fee);
			myLogger.info("\n-------Insertion is Successful-------");
		} catch (SQLException e) {
			System.err.println(e);
			myLogger.info("\n--------Unsuccesful ----------");
		}

	}

	public static void read() {
		myLogger.info("--------------------------------------Doctor List---------------------------------------------");

		try {

			List<DoctorDto> dtos = dao.read();
//			System.out.printf("id          name \t        speciality      fee\n");

			for (DoctorDto doctorDto : dtos) {
				System.out.printf(" %s %30s %15s  %20s ", doctorDto.getId(), doctorDto.getName(),
						doctorDto.getSpeciality(), doctorDto.getFee());
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.err.println(e);
			myLogger.info("----------Can't read---------");
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

			dao.update(id, name, speciality, fee);
			myLogger.info("\n-------Value  Updated-------");

		} catch (SQLException e) {

			e.printStackTrace();
			myLogger.info("\n-------Can't  Update-------");
		}
	}

	public static void delete() {

		try {

			System.out.println("Enter Doctor ID of doctor you want to Delete");
			String D_Id = sc.next();
			dao.delete(D_Id);
			myLogger.info("---------------Deleted successfully-----------------");
		} catch (SQLException e) {

			e.printStackTrace();
			myLogger.info("---------------Can't Delete-----------------");
		}
	}

}
