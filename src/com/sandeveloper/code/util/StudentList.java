package com.sandeveloper.code.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import com.sandeveloper.code.io.StudentFileIO;
import com.sandeveloper.code.student.Student;

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
			if(s.getCourseId() == course){
				filteredStudentList.add(s); 
				System.out.println(s.getFirstName());
			}
		}
		return filteredStudentList;
	}

	public void increaseCourse(){
		int course = 0;
		for(Student s : studentFile){
			course = s.getCourseId();
			s.setCourseId(course++);
		}
	}
	
	public String showAll(){
		
		String s1 = null;
		for (Student s : studentFile) {
			s1 = s.toString();
			System.out.println(s.toString());
		}
		return s1;
	}
	
	public ArrayList<Student> sortByGrade(){
		
		Collections.sort(studentFile, new SortByGrade());
		
		return studentFile;
	}
	
	public ArrayList<Student> sortByFirtstName(){
		
		Collections.sort(studentFile, new SortByFirstName());
		
		return studentFile;
	}
  }
	

