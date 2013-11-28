package com.sandeveloper.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sandeveloper.code.student.Student;

public class IOXML {
	
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void writeXmlFile(String fileName ) throws JAXBException{
	
		JAXBContext context = JAXBContext.newInstance(XMLRoot.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		m.marshal(studentList, System.out);
		
		m.marshal(studentList, new File(fileName));
	}
	
	public ArrayList<Student> readXmlFile(String fileName)throws JAXBException, FileNotFoundException{
		
		JAXBContext context = JAXBContext.newInstance(XMLRoot.class);
		Unmarshaller um = context.createUnmarshaller();
		XMLRoot studentlist2 = (XMLRoot) um.unmarshal(new FileReader(fileName));
		ArrayList<Student> list = studentlist2.getList();
		return list;
	}
}