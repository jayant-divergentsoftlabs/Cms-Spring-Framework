package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;
import java.util.List;

import com.divergentsl.clinicmanagementsystem.dao.AppointmentDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.databaseconnection.IDatabaseManager;
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
		   AppointmentDao appointment = new AppointmentDao(new DatabaseManager());
			List<AppointmentDto> dtos = appointment.read();
			System.out.println("\n");
			System.out.printf("Id                              Name               DoctorId                   Problem               DateofAppointment        Time\n");
			
			for (AppointmentDto appointmentDto : dtos) {
				System.out.printf(" %s %30s %20s  %28s %20s %25s ", appointmentDto.getAppointmentId(),
						appointmentDto.getPatientname(), appointmentDto.getDrId(), appointmentDto.getProblem(),
						appointmentDto.getAppointmentDate(), appointmentDto.getAppointmentTime());
				System.out.println("\n");
				
			}
			System.out.println("-----------------------------------*---Appointment List---*--------------------------------------------------- ");
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("----------Can't read---------");
		}
	}

	
	}

