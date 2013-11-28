package com.sandeveloper.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import com.sandeveloper.code.student.Student;
import com.sandeveloper.code.util.StudentList;

public class Test {

	@org.junit.Test
	public void testInitializationStudent() throws Exception{
		StudentList sdtOpt = new StudentList();
		
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
		
		sdtOpt.addNewStudent(Naomi);
		sdtOpt.addNewStudent(Jack);
		sdtOpt.addNewStudent(Nikky);
		sdtOpt.addNewStudent(Mary);
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		studentList.add(Naomi);
		studentList.add(Nikky);
		
		assertEquals(studentList, sdtOpt.findStudentsByCourse(2));
	}
}
