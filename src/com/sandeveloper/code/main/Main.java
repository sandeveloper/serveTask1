package com.sandeveloper.code.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import com.sandeveloper.code.DataBase.DataBaseOptions;
import com.sandeveloper.code.DataBase.Database;
import com.sandeveloper.code.io.IOXML;
import com.sandeveloper.code.io.StudentFileIO;
import com.sandeveloper.code.io.TXTFileIO;
import com.sandeveloper.code.io.XMLRoot;
import com.sandeveloper.code.student.Student;

public class Main {
	
	public final static void main(String[] args)throws IOException, ClassNotFoundException, JAXBException, SQLException{
		
		ArrayList<Student> studentsList = new ArrayList<Student>();
		
		Student Mary = new Student();
		Mary.setAvGrade(5);
		Mary.setCourseId(1);
		Mary.setFirstName("Mary");
		Mary.setLastName("Pack");
		
		Student Jack = new Student();
		Jack.setAvGrade(3.75);
		Jack.setCourseId(1);
		Jack.setFirstName("Jack");
		Jack.setLastName("Sparrow");
		
		Student Nikky = new Student();
		Nikky.setAvGrade(4.0);
		Nikky.setCourseId(2);
		Nikky.setFirstName("Nikky");
		Nikky.setLastName("Sanders");
		
		Student Naomi = new Student();
		Naomi.setAvGrade(4.22);
		Naomi.setCourseId(2);
		Naomi.setFirstName("Naomi");
		Naomi.setLastName("Harrison");
		
		Student Peter = new Student();
		Peter.setAvGrade(4.75);
		Peter.setCourseId(3);
		Peter.setFirstName("Peter");
		Peter.setLastName("Ras");
		
		 //Студенти
		studentsList.add(Mary);
		studentsList.add(Jack);
		studentsList.add(Nikky);
		studentsList.add(Naomi);
		studentsList.add(Peter);
		
		/*IOXML xml = new IOXML();
		XMLRoot root = new XMLRoot();
		root.setStudentList(studentsList);
		xml.writeXmlFile("testNewFiedls", root);*/
		
		
		/*try {
			Database.createTables();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		ArrayList<Student> students = new ArrayList<Student>();
		DataBaseOptions dbO = new DataBaseOptions();
		/*dbO.addNewRecord(Mary);
		dbO.addNewStudent(Naomi);
		dbO.addNewStudent(Nikky);
		dbO.addNewStudent(Peter);
		dbO.addNewStudent(Jack);*/
		
		/*students = dbO.getAllStudents();
		dbO.addNewDepartment("Math");
		dbO.addNewDepartment("Computer Science");
		dbO.addNewDepartment("Phys");*/
		
		//dbO.updateStudentsGPA("Mary", "Pack", 1, 3.75);
		//dbO.deleteStudent("Mary", "Pack", 1);
		//dbO.addNewDepartment("Phys");
		
		//dbO.updateStudentCourse("Peter", "Ras", 4);
		
		//students = dbO.getStudentFullInformation();
		
		for (Student student : students) {
		//	System.out.println(student.toString());
		}
		
		dbO.searchByDepartment("Computer Science");
		
	}
	
	
}
