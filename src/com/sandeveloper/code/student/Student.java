package com.sandeveloper.code.student;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "student")
@XmlType(propOrder = { "firstName", "lastName", "courseNumber", "avGrade" })
public class Student implements Serializable {

	private String firstName;
	private String lastName;
	private int course;
	private double avGrade;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCourseNumber(int course) {
		this.course = course;
	}

	public void setAvGrade(double avGrade) {
		this.avGrade = avGrade;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getCourseNumber() {
		return course;
	}

	public double getAvGrade() {
		return avGrade;
	}

	public String toString() {

		return "FirstName: " + getFirstName() + " LastName: " + getLastName()
				+ " Course: " + getCourseNumber() + " GPA: " + getAvGrade();

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

	public void emptyMethod() {
	}
}
