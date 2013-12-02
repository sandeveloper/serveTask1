package com.sandeveloper.code.DataBase;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sandeveloper.code.main.Department;
import com.sandeveloper.code.student.Student;

public class DataBaseOptions {
	
	Connection connect;
	Statement statement = null;
	
	public DataBaseOptions(){
		connect = Database.getConnection();
		try {
			statement = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addNewDepartment(String depName){
		String newDept = "INSERT INTO Department " + "(department) VALUES(" + "'" + depName + "');";
		
		try {
			statement.executeUpdate(newDept);
			System.out.println("Added:" + newDept);
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void addNewStudent(Student student){
		
		String[] studentsString = new String[5];
		studentsString[0] = student.getFirstName();
		studentsString[1] = student.getLastName();
		studentsString[2] = String.valueOf(student.getCourseId());
		studentsString[3] = String.valueOf(student.getAvGrade());
		
		//"INSERT INTO user " + "(first, last, age) VALUES('Jack', 'Jack', 10)";
		String newRecord = "INSERT INTO Students " + "(firstName, lastName, course_id, gpa) VALUES("
		                  + "'" + studentsString[0] + "', " + "'" + studentsString[1] + "', " + studentsString[2] + ", " + studentsString[3] + ")";
		System.out.println("Added: " + studentsString[0] + " " + studentsString[1] + " " + studentsString[2] + " " + studentsString[3] );
		
		try {
			statement.executeUpdate(newRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> getAllStudents() throws SQLException{
		ArrayList<Student> studentList = new ArrayList<Student>();
		String selectAllRecords = "SELECT * FROM Students;";
		
		ResultSet rs = statement.executeQuery(selectAllRecords);
		
		while (rs.next()) {
			Student student = new Student();
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			Integer course_id = Integer.valueOf(rs.getString("course_id"));
			Double gpa = Double.valueOf(rs.getString("gpa"));
			
			student.setFirstName(firstName);
			student.setLastName(lastName);
			//student.setCourseNumber(course_id);
			student.setAvGrade(gpa);
			studentList.add(student);
			
		}
		
		return studentList;
	}

	public void updateStudentsGPA(String firstName, String lastName, int course, double newGPA) throws SQLException{
		//String select = "SELECT * FROM Students WHERE firstName = '" + firstName + "' AND lastName = '" + lastName + "'AND course_id = '" + course + "';";
		//ResultSet rs = statement.executeQuery(select);
		
		String update = "UPDATE STUDENTS SET gpa = '" + newGPA + "' WHERE firstName = '" + firstName + "' AND lastName = '" + lastName + "'AND course_id = '" + course + "';" ;
		
		statement.execute(update);
	}
	
	public void updateStudentCourse(String firstName, String lastName, int newCourse) throws SQLException{

		String update = "UPDATE STUDENTS SET course_id = '" + newCourse + "' WHERE firstName = '" + firstName + "' AND lastName = '" + lastName + "';" ;
		
		statement.execute(update);

	}
	
	public void deleteStudent(String firstName, String lastName, int course) throws SQLException{
		String delete = "DELETE Students WHERE firstName = '" + firstName + "' AND lastName = '" + lastName + "' AND course_id = '" + course + ";";
		
		statement.execute(delete);
	}
	
	public void deleteDepartment(String department) throws SQLException{
		String delete = "DELETE FROM Department WHERE department = '" + department + "';";
		statement.execute(delete);
		
	}

	public ArrayList<Student> getStudentFullInformation() throws SQLException{
		ArrayList<Student> returnStudentList = new ArrayList<Student>();
		Department dept = new Department();
		
		String select = "SELECT Students.id, firstName, lastName, department, gpa FROM students, department WHERE students.course_id = department.id";
		ResultSet rs = statement.executeQuery(select);
		
		while (rs.next()) {
			Student student = new Student();
			
			Integer id = Integer.valueOf(rs.getString("id"));
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String department = rs.getString("department");
			Double gpa = Double.valueOf(rs.getString("gpa"));
			
			student.setId(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			dept.setDepartment(department);
			student.setAvGrade(gpa);
			returnStudentList.add(student);
		}
		
		return returnStudentList;
	}
}
