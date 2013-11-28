package com.sandeveloper.code.util;

import java.util.Comparator;

import com.sandeveloper.code.student.Student;

public class SortByGrade implements Comparator<Student>{

	@Override
	public int compare(Student arg0, Student arg1) {
		
		double grade0 = arg0.getAvGrade();
		double grade1 = arg1.getAvGrade();
		//return (int)(grade0-grade1);
		
		if(grade0 > grade1){
			return 1;

		}else if(grade0 < grade1){
			return -1;
		
		}else {
			return 0;
		}
		
	}

}
