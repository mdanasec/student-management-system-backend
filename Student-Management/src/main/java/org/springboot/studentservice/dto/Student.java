package org.springboot.studentservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String course;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false, unique = true)
	private long mobileNo;
	@Column(nullable = false)
	private String enrollDate;
	@Column(nullable = false)
	private String password;
	
//	no argument constructor
	public Student() {
		super();
	}
//	Parameterize constructor
	public Student(int id, String name, String course, String email, long mobileNo, String enrollDate,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.email = email;
		this.mobileNo = mobileNo;
		this.enrollDate = enrollDate;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	
	
	
}
