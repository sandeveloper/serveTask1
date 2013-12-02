package com.sandeveloper.code.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.DatabaseMetaData;


public class Database {

	public static Connection getConnection() {
		Connection dbConnection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Driver not found");
		}
		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dekanat","root", "1111");
			System.out.println("Connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No Connection");
		}
		
		return dbConnection;
	}
	
	public static void createTables() throws SQLException{
		Connection dbConnection = null;
		Statement statement = null;
		
		String tableStudents = "CREATE TABLE Students" +
								"(id INT NOT NULL AUTO_INCREMENT, " +
								" firstName VARCHAR(255), "			+
								" lastName VARCHAR(255), " 			+
								" course_id INTEGER, " 				+
								" gpa FLOAT, " 					+
								" PRIMARY KEY ( id ))"				;

		String tableDepartments = "CREATE TABLE Department" + 
								   "(id INT NOT NULL AUTO_INCREMENT, " +
								   " department VARCHAR(255), " 	   +
								   " PRIMARY KEY ( id ))"			   ;
		
		try {
			dbConnection = getConnection();
			statement = dbConnection.createStatement();
			DatabaseMetaData metaData = (DatabaseMetaData) dbConnection.getMetaData();
			ResultSet resSet = metaData.getTables(null, null, "Students", null);
			if (resSet.next()){
				System.out.println("Table Students already exists");
				return;
			}else {
				statement.execute(tableStudents);
			}
			
			if (resSet.next()){
				System.out.println("Table Departments already exists");
				return;
			}else {
				statement.execute(tableDepartments);
			}
			
			System.out.println("Tables Students and Departments have been created!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if (statement != null) {
				statement.close();
			}
			
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
	}
}
