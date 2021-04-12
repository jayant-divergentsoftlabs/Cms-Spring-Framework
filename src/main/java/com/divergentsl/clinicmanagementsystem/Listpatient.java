package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

/**
 * By this class Doctor can see the list of all the patients which have visited yet.
 * @author Jayant
 *
 */
import java.util.List;
import java.util.logging.Logger;

import com.divergentsl.clinicmanagementsystem.dao.PatientDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.PatientDto;

public class Listpatient {static final Logger myLogger = Logger
.getLogger("Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/ListPatient.java");

	public static void listPatient() {
		myLogger.info(
				"--------------------------------------Patient List---------------------------------------------");

		try {
			PatientDao patient = new PatientDao(new DatabaseManager());
			List<PatientDto> dtos = patient.read();
			//System.out.printf("id          name \t        age      gender\t  contactnumber\t  weight\n");

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
}
