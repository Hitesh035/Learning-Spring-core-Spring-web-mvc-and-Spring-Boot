package com.hitesh.springwebv2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeFormatValidation {
	
	public static boolean isValidTimeFormat(String time) {
		
		String timeFormatRegEx = "([01]?[0-9]|2[0-3]):[0-5][0-9]*";
		Pattern pattern = Pattern.compile(timeFormatRegEx);
		Matcher matcher = pattern.matcher(""+time);
		if(!matcher.matches()) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(TimeFormatValidation.isValidTimeFormat("23:30"));
	}
}
