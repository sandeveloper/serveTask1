package com.sandeveloper.code.student;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sandeveloper.code.main.Department;


@XmlRootElement(name = "student")
@XmlType(propOrder = {"id", "firstName", "lastName", "courseId", "avGrade" })
public class Student implements Serializable {

	private int id;
	private String firstName;
	private String lastName;
	private int courseId;
	private double avGrade;
	
	Department dept;
	
	public Student() {
		dept = new Department();
	}

	public void setId(int id){
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public void setAvGrade(double avGrade) {
		this.avGrade = avGrade;
	}
	
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getCourseId() {
		return courseId;
	}

	public double getAvGrade() {
		return avGrade;
	}

	public String toString() {

		return "id " + id + " FirstName: " + getFirstName() + " LastName: " + getLastName()
				+ " Course: " + getCourseId() + " GPA: " + getAvGrade();

	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Student)) {
			return false;
		}

		if (obj == null) {
			return false;
		}

		Student student = (Student) obj;

		return this.getFirstName().equals(student.getFirstName())
				&& this.getLastName().equals(student.getLastName());
	}

}
