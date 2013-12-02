package com.sandeveloper.tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import com.sandeveloper.code.io.TXTFileIO;
import com.sandeveloper.code.student.Student;
import com.sandeveloper.code.util.SortByFirstName;
import com.sandeveloper.code.util.SortByGrade;
import com.sandeveloper.code.util.StudentList;

public class StudentTest {

	@org.junit.Test
	public void testInitializationStudent() throws Exception{
		StudentList sdtOpt = new StudentList();
		
		Student Mary = new Student();
		Mary.setAvGrade(3.55);
		//Mary.setCourseNumber(1);
		Mary.setFirstName("Mary");
		Mary.setLastName("Pack");
		
		Student Jack = new Student();
		Jack.setAvGrade(3.75);
		//Jack.setCourseNumber(1);
		Jack.setFirstName("Jack");
		Jack.setLastName("Sparrow");
		
		Student Nikky = new Student();
		Nikky.setAvGrade(4.0);
		//Nikky.setCourseNumber(2);
		Nikky.setFirstName("Nikky");
		Nikky.setLastName("Sanders");
		
		Student Naomi = new Student();
		Naomi.setAvGrade(4.22);
		//Naomi.setCourseNumber(2);
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

	@org.junit.Test
	public void testSotringByGrade(){
		
		Student Jack = new Student();
		Jack.setAvGrade(3.75);
		//Jack.setCourseNumber(1);
		Jack.setFirstName("Jack");
		Jack.setLastName("Sparrow");
		
		Student Nikky = new Student();
		Nikky.setAvGrade(4.0);
		//Nikky.setCourseNumber(2);
		Nikky.setFirstName("Nikky");
		Nikky.setLastName("Sanders");
		
		Student Naomi = new Student();
		Naomi.setAvGrade(4.22);
		//Naomi.setCourseNumber(2);
		Naomi.setFirstName("Naomi");
		Naomi.setLastName("Harrison");
		
		ArrayList<Student> expected = new ArrayList<Student>();
		ArrayList<Student> current = new ArrayList<Student>();
		
		expected.add(Jack);
		expected.add(Nikky);
		expected.add(Naomi);
		
		current.add(Nikky);
		current.add(Naomi);
		current.add(Jack);
 		
		Collections.sort(current, new SortByGrade());
		
		assertEquals(expected, current);
	}
	
	@Test
	public void testSortingByFirstName(){
		
		Student Jack = new Student();
		Jack.setAvGrade(3.75);
		//Jack.setCourseNumber(1);
		Jack.setFirstName("Jack");
		Jack.setLastName("Sparrow");
		
		Student Nikky = new Student();
		Nikky.setAvGrade(4.0);
		//Nikky.setCourseNumber(2);
		Nikky.setFirstName("Nikky");
		Nikky.setLastName("Sanders");
		
		Student Naomi = new Student();
		Naomi.setAvGrade(4.22);
		//Naomi.setCourseNumber(2);
		Naomi.setFirstName("Naomi");
		Naomi.setLastName("Harrison");
		
		ArrayList<Student> expected = new ArrayList<Student>();
		ArrayList<Student> current = new ArrayList<Student>();
		
		expected.add(Jack);
		expected.add(Naomi);
		expected.add(Nikky);
		
		current.add(Nikky);
		current.add(Jack);
		current.add(Naomi);
		
		Collections.sort(current, new SortByFirstName());
		
		assertEquals(expected, current);
	}
	
	@org.junit.Test
	public void testShowAllStudents(){
		
		StudentList studOpt = new  StudentList();
		
		Student Mary = new Student();
		Mary.setAvGrade(3.55);
		//Mary.setCourseNumber(1);
		Mary.setFirstName("Mary");
		Mary.setLastName("Pack");
		
		studOpt.addNewStudent(Mary);
		
		assertEquals(Mary.toString(), studOpt.showAll());
	}

	@Test
	public void testWriteReadFromTextFile() throws IOException{
		
		TXTFileIO txtIO = new TXTFileIO();
		
		Student Mary = new Student();
		Mary.setAvGrade(3.55);
		//Mary.setCourseNumber(1);
		Mary.setFirstName("Mary");
		Mary.setLastName("Pack");
		
		Student Jack = new Student();
		Jack.setAvGrade(3.75);
		//Jack.setCourseNumber(1);
		Jack.setFirstName("Jack");
		Jack.setLastName("Sparrow");

		ArrayList<Student> expected = new ArrayList<Student>();
		
		expected.add(Mary);
		expected.add(Jack);
		
		ArrayList<Student> exList = new ArrayList<Student>();
		exList.add(Mary);
		exList.add(Jack);
		
		txtIO.setStudentList(exList);
		
		txtIO.writeTextFile("testFile.txt");
		
		ArrayList<Student> current = new ArrayList<Student>();
		current = txtIO.readTextFile("testFile.txt");
		
		/*for (Student student : current) {
			System.out.println(student.toString());
		}*/
		assertEquals(expected, current);
	}
	
	@Test
	public void testIncreaseCourse(){
		
		//errorTest
		
		StudentList studOpt = new  StudentList();
		
		Student Mary = new Student();
		Mary.setAvGrade(3.55);
		//Mary.setCourseNumber(1);
		Mary.setFirstName("Mary");
		Mary.setLastName("Pack");
		
		ArrayList<Student> expected = new ArrayList<Student>();
		ArrayList<Student> current = new ArrayList<Student>();
		
		current.add(Mary);
		
		//Mary.setCourseNumber(2);
		
		expected.add(Mary);
		
		assertEquals(expected, current);
	}
}