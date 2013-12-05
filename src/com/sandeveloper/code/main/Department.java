package com.sandeveloper.code.main;

import java.io.Serializable;

public class Department implements Serializable{
	
	private int departmentId;
	private String department;
	
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
}
