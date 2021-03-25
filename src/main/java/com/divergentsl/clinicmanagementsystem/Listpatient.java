package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;

/**
 * By this class Doctor can see the list of all the patients which have visited yet.
 * @author Jayant
 *
 */
import java.util.List;

import com.divergentsl.clinicmanagementsystem.dao.PatientDao;
import com.divergentsl.clinicmanagementsystem.dto.PatientDto;

public class Listpatient {
	/**
	 * 
	 */

	public static void listPatient() {
		System.out.println(
				"--------------------------------------Patient List---------------------------------------------");

		try {
			PatientDao patient = new PatientDao(new DatabaseManager());
			List<PatientDto> dtos = patient.read();
			System.out.printf("id          name \t        age      gender\t  contactnumber\t  weight\n");

			for (PatientDto patientDto : dtos) {
				System.out.printf(" %s %30s %15s  %20s %20s %20d ", patientDto.getId(), patientDto.getName(),
						patientDto.getAge(), patientDto.getGender(), patientDto.getContactnumber(),
						patientDto.getWeight());
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("----------Can't read---------");
		}

	}
}
