package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;
import java.util.List;

import com.divergentsl.clinicmanagementsystem.dao.BookedAppointmentDao;
import com.divergentsl.clinicmanagementsystem.dto.AppointmentDto;

/**
 * This class will access by doctor where they can see their appointments.
 * 
 * @author Jayant
 *
 */
public class BookedAppointment {
	/**
	 * By this method i.e. bookedAppointment doctor will see the appointment booked
	 * for his/her.
	 */

	public static void bookedAppointment() {

		System.out.println(
				"--------------------------------------Appointment List---------------------------------------------");

		try {
			BookedAppointmentDao appointment = new BookedAppointmentDao(new DatabaseManager());
			List<AppointmentDto> dtos = appointment.read();
			System.out.printf("id          name \t        age      gender\t  contactnumber\t  weight\n");

			for (AppointmentDto appointmentDto : dtos) {
				System.out.printf(" %s %30s %15s  %20s %15s %10s ", appointmentDto.getAppointmentId(),
						appointmentDto.getPatientname(), appointmentDto.getDrId(), appointmentDto.getProblem(),
						appointmentDto.getAppointmentDate(), appointmentDto.getAppointmentTime());
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("----------Can't read---------");
		}
	}
}
