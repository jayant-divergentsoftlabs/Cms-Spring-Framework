package com.divergentsl.clinicmanagementsystem.dto;

import java.io.Reader;

public class PatientDto {
	String id, name,  contactnumber;
	int weight,age;
	Reader gender;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Reader getGender() {
		return gender;
	}
	public void setGender(Reader reader) {
		this.gender = reader;
	}
	
}
	