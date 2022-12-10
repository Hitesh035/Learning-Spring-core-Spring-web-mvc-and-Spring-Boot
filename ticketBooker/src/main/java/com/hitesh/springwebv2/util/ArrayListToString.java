package com.hitesh.springwebv2.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayListToString {
	
	public static String parseToString(List<String> list) {
		
		String movieTimes="";
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			movieTimes += itr.next();
			movieTimes+=",";
		}
		
		return movieTimes;
	}
	
	public static List<String> parseToArrayList(String string){
		
		List<String> list = new ArrayList<>();
		String movieTimesRegEx="[0-9]+:[0-9]+";
		Pattern pattern = Pattern.compile(movieTimesRegEx);
		Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
			String group = matcher.group();
			
			list.add(group);
		}
		return list;
	}
	
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("123:34");
		arrayList.add("123:34");
		arrayList.add("123:34");
		arrayList.add("123:34");
		
		String string = parseToString(arrayList);
		
		List<String> arrayList2 = parseToArrayList(string);
		
		Iterator<String> itr = arrayList2.iterator();
		while(itr.hasNext()) {
			
			System.out.println(itr.next());
		}
		
	}
}
