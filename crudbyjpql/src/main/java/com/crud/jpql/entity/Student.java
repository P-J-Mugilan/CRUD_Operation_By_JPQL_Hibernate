package com.crud.jpql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name = "student_id")
	private long studentId;
	
	@Column(name = "student_name", nullable = false, length = 45)
	private String studentName;
	
	@Column(name = "student_mobile", nullable = false, unique = true, length = 10)
	private String studentMobile;
	
	@Column(name = "student_email_id", nullable = false, unique = true, length = 45)
	private String studentEmailId;
	
	@Column(name= "department", nullable = false, length = 45)
	private String department;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
