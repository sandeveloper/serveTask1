package com.sandeveloper.code.util;

import java.util.Comparator;

import com.sandeveloper.code.student.Student;

public class SortByFirstName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		String str1 = o1.getFirstName();
		String str2 = o2.getFirstName();
		
		return str1.compareTo(str2);
	}

}
