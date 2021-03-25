package com.divergentsl.clinicmanagementsystem.dto;

public class AppointmentDto {
	String appointmentId, patientname, DrId, Problem, appointmentDate, appointmentTime;

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getDrId() {
		return DrId;
	}

	public void setDrId(String drId) {
		DrId = drId;
	}

	public String getProblem() {
		return Problem;
	}

	public void setProblem(String problem) {
		Problem = problem;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

}
