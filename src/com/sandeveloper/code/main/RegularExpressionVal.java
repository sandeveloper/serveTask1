package com.sandeveloper.code.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionVal {

	public boolean checkWithRegExp(String student){
		
		//FirstName: Mary LastName: Pack-Chak Course: 1 GPA: 3.45
		Pattern p = Pattern.compile("^FirstName: [A-Z][A-Za-z-]{2,20} LastName: [A-Z][A-Za-z-]{2,20} Course: [1-3]{1} GPA: [0-9]{1,3}.[0-9]{1,2}$");
		Matcher m = p.matcher(student);
		return m.matches();
	}
}
