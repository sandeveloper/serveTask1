package com.sandeveloper.code.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.sandeveloper.code.student.Student;
import com.sandeveloper.io.StudentFileIO;

public class StudentList {
	
	private ArrayList<Student> studentFile;
	
	public StudentList(){
		studentFile = new ArrayList<Student>();
	}
	
	public void setStudentFile(ArrayList<Student> studentFile){
		this.studentFile = studentFile;
	}
	
	public void addNewStudent(Student std){
		studentFile.add(std);
	}
	
	public ArrayList<Student> findStudentsByCourse(int course){
		ArrayList<Student> filteredStudentList = new ArrayList<Student>();
		for(Student s : studentFile){
			if(s.getCourseNumber() == course){
				filteredStudentList.add(s); 
				System.out.println(s.getFirstName());
			}
		}
		return filteredStudentList;
	}

	public void increaseCourse(){
		int course = 0;
		for(Student s : studentFile){
			course = s.getCourseNumber();
			s.setCourseNumber(course++);
		}
	}
	
	public void showAll(){
		for (Student s : studentFile) {
			System.out.println(s.toString());
		}
	}
  }
	

