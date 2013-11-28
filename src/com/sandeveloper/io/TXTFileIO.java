package com.sandeveloper.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.sandeveloper.code.main.RegularExpressionVal;
import com.sandeveloper.code.student.Student;

public class TXTFileIO {

	private String currentLine;
	private ArrayList<Student> studentList = new ArrayList<Student>();
 	
	public void setStudentList(ArrayList<Student> student) {
		this.studentList = student;
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	public void writeTextFile(String filename) throws FileNotFoundException{
		PrintWriter out = new PrintWriter(filename);
		
		for (Student s : studentList) {
			out.println(s.toString());
		}
		
		out.close();
	}
	
	public ArrayList<Student> readTextFile(String fileName) throws IOException{
		ArrayList<String> stringStudentList = new ArrayList<String>();
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		RegularExpressionVal rge = new RegularExpressionVal();
		

		while ((currentLine = bf.readLine()) != null) {
			System.out.println(rge.checkWithRegExp(currentLine));
			if (rge.checkWithRegExp(currentLine)) {
				stringStudentList.add(currentLine);
				System.out.println(currentLine);
			}
		}

		System.out.println("~~~~~~~~~");
		
		for (int i = 0; i < stringStudentList.size(); i++) {
			String[] stringArray = new String[10];
			String line = stringStudentList.get(i).toString();
			stringArray = line.split(" ");
			
			Student studentTxt = new Student();
			studentTxt.setFirstName(stringArray[1]);
			studentTxt.setLastName(stringArray[3]);
			studentTxt.setCourseNumber(Integer.parseInt(stringArray[5]));
			studentTxt.setAvGrade(Double.parseDouble(stringArray[7]));
			studentList.add(studentTxt);
		}
		
		return studentList;
	}
}
