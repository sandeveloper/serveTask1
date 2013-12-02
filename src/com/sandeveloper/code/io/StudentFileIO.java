package com.sandeveloper.code.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.sandeveloper.code.student.Student;

public class StudentFileIO {
	
	private ArrayList<Student> fileStudents;
	
	public void setFileStudents(ArrayList<Student> fileStudents){
		this.fileStudents = fileStudents;
	}
	
	public ArrayList<Student> getFileStudents() {
		return fileStudents;
	}
	
	public ArrayList<Student> readFile(String fileName) throws IOException, ClassNotFoundException {
	
		FileInputStream f = new FileInputStream(new File(fileName));
		ObjectInputStream s = new ObjectInputStream(f);
		fileStudents = (ArrayList<Student>) s.readObject();
		s.close();
		
		return fileStudents;
	}

	
	public void writeToFile(String fileName) throws IOException, ClassNotFoundException {

		FileOutputStream f = new FileOutputStream(new File(fileName));
		ObjectOutputStream s = new ObjectOutputStream(f);
		s.writeObject(fileStudents);
		s.close();
	
	}
	
}
