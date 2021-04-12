package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.divergentsl.clinicmanagementsystem.dao.AppointmentDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;

import com.divergentsl.clinicmanagementsystem.dto.AppointmentDto;

/**
 * This class will access by doctor where they can see their appointments.
 * 
 * @author Jayant
 *
 */
public class BookedAppointment {
	static final Logger myLog = Logger.getLogger(
			"Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/BookedAppointment.java");

	/**
	 * By this method i.e. bookedAppointment doctor will see the appointment booked
	 * for his/her.
	 */

	public static void bookedAppointment() {

		myLog.setLevel(Level.FINE);
		myLog.info(
				"--------------------------------------Appointment List---------------------------------------------");

		try {
			AppointmentDao appointment = new AppointmentDao(new DatabaseManager());
			List<AppointmentDto> dtos = appointment.read();
			System.out.println("\n");
			System.out.printf(
					"Id                              Name               DoctorId                   Problem               DateofAppointment        Time\n");

			for (AppointmentDto appointmentDto : dtos) {
				System.out.printf(" %s %30s %20s  %28s %20s %25s ", appointmentDto.getAppointmentId(),
						appointmentDto.getPatientname(), appointmentDto.getDrId(), appointmentDto.getProblem(),
						appointmentDto.getAppointmentDate(), appointmentDto.getAppointmentTime());
				System.out.println("\n");

			}
			myLog.info(
					"-----------------------------------*---Appointment List---*--------------------------------------------------- ");
		} catch (SQLException e) {
			System.err.println(e);
			myLog.info("----------Can't read---------");
		}
	}

}
