package com.sandeveloper.io;

import java.awt.print.Book;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sandeveloper.code.student.Student;

@XmlRootElement(namespace = "com.sandeveloper.code")

public class XMLRoot {

	@XmlElement(name = "student")

	ArrayList<Student> studentList = new ArrayList<Student>();
	
	public void setStudentList(ArrayList<Student> studentList){
		this.studentList = studentList;
	}
	
	public ArrayList<Student> getList(){
		return studentList;
	}
}

