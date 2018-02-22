package com.goal.main;

import java.util.Scanner;

public class QuerySplit {
	QuerySplit(){
		super();
	}
	 String getString(){
		 System.out.println("Enter The query :");
    	Scanner sc;
		String str;
		sc = new Scanner(System.in);
		str = sc.nextLine();
		str=str.toLowerCase();
		sc.close();
        return str;             
        }
	 String[] getSplit(String str){
		 String arr[]=str.split("[\\s,;]+");
		 return arr;
	 }
}
