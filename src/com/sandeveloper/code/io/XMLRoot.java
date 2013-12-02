package com.sandeveloper.code.io;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sandeveloper.code.student.Student;

@XmlRootElement(namespace = "com.sandeveloper.code")

public class XMLRoot {

	@XmlElement(name = "student")

	ArrayList<Student> studentList;
	IOXML io = new IOXML();
	
	public void setStudentList(ArrayList<Student> studentList){
		this.studentList = studentList;
		io.setStudentList(studentList);
	}
	
	public ArrayList<Student> getList(){
		return studentList;
	}
}

