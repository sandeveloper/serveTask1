package com.sandeveloper.code.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import com.sandeveloper.code.student.Student;
import com.sandeveloper.io.IOXML;
import com.sandeveloper.io.StudentFileIO;
import com.sandeveloper.io.TXTFileIO;
import com.sandeveloper.io.XMLRoot;

public class Main {
	
	
	public final static void main(String[] args)throws IOException, ClassNotFoundException, JAXBException{
		
		ArrayList<Student> studentsList = new ArrayList<Student>();
		
		Student Mary = new Student();
		Mary.setAvGrade(3.55);
		Mary.setCourseNumber(1);
		Mary.setFirstName("Mary");
		Mary.setLastName("Pack");
		
		Student Jack = new Student();
		Jack.setAvGrade(3.75);
		Jack.setCourseNumber(1);
		Jack.setFirstName("Jack");
		Jack.setLastName("Sparrow");
		
		Student Nikky = new Student();
		Nikky.setAvGrade(4.0);
		Nikky.setCourseNumber(2);
		Nikky.setFirstName("Nikky");
		Nikky.setLastName("Sanders");
		
		Student Naomi = new Student();
		Naomi.setAvGrade(4.22);
		Naomi.setCourseNumber(2);
		Naomi.setFirstName("Naomi");
		Naomi.setLastName("Harrison");
		
		Student Peter = new Student();
		Peter.setAvGrade(4.75);
		Peter.setCourseNumber(3);
		Peter.setFirstName("Peter");
		Peter.setLastName("Ras");
		
		 //Студенти
		studentsList.add(Mary);
		studentsList.add(Jack);
		studentsList.add(Nikky);
		studentsList.add(Naomi);
		studentsList.add(Peter);
		//
		StudentFileIO io = new StudentFileIO();
		Student std = new Student();
		
		ArrayList<Student> studentsList1 = new ArrayList<Student>();
		XMLRoot sl = new XMLRoot();
		sl.setStudentList(studentsList);
		
		/*Begin. Check String 
		
		String mary = Mary.toString();
		
		System.out.println(mary);
		
		//End. Check string*/
		
		TXTFileIO txtio = new TXTFileIO();
		//txtio.setStudentList(studentsList);
		//txtio.writeTextFile("txtfileNew.txt");
		studentsList1 = txtio.readTextFile("txtfileNew.txt");
		
		for (Student student : studentsList1) {
			System.out.println(student.toString());
		}
		
		/*String[] stringArray = new String[10];
		String line = studentsList1.get(1).toString();
		System.out.println("~~~~~~");
		System.out.println(line);
		
		stringArray = line.split(" ");
		
		for (int i = 1; i < stringArray.length; i= i+2) {
			System.out.println(stringArray[i]);
			
		}
		
		Student studentTxt = new Student();
		studentTxt.setFirstName(stringArray[1]);
		studentTxt.setLastName(stringArray[3]);
		studentTxt.setCourseNumber(Integer.parseInt(stringArray[5]));
		studentTxt.setAvGrade(Double.parseDouble(stringArray[7]));
		
		System.out.println("~~~~~~");
		System.out.println(studentTxt.toString());*/
	}
	
	
}
