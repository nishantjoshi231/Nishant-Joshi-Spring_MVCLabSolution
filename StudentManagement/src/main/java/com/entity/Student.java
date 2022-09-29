package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Department")
	private String department;

	@Column(name = "Country")
	private String country;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String department, String country) {
		super();

		this.name = name;
		this.department = department;
		this.country = country;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [sudentId=" + id + ", name=" + name + ", depatrment=" + department + ", country=" + country
				+ "]";
	}

}
