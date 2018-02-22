package com.goal.main;

import java.util.*;

public class QueryParameter {
	static int i;
	String [] str;
	static List<String> myList = new ArrayList<String>();//select column conditions
    String FileName;
    ArrayList<ArrayList<String>> cond1 = new ArrayList<>();//where condition
    ArrayList<String> fun1 = new ArrayList<>();// function contains
    ArrayList<String> logic = new ArrayList<>();//logic operator
    ArrayList<String> cond2 = new ArrayList<String>();//group
    ArrayList<String> cond3 = new ArrayList<String>();//order
    public QueryParameter() {
    	super();
    }
	public QueryParameter(String [] name) {
	   str=name;
	}
	int addCol() {
		if(! str[0].equals("select"))
			return 0;
		for(i =1;i<str.length;i++) {
			if(str[i].equals("from"))
				break;
			String s = str[i];
			if(s.indexOf("(") == -1)
				myList.add(str[i]);
			else
				fun1.add(str[i]);
		}
		i=i+1;
		return 1;
	}
	int addFile() {
		String[] arr=str[i].split("\\.");
		if( ! arr[1].equals("csv"))
			return 0;
		FileName = str[i];
		return 1;
	}
	int addWhere() {
		int temp;
		int flag=0;
		for(temp=i+1;temp<str.length;temp++) {
			if(str[temp].equals("where")){
				flag=1;
				break;
			}
		}
		if(flag==1) {
			int prev = temp+1;
			int curr=prev;
			for(temp=prev;;temp++) {
				if( temp == str.length || str[temp].equals("order") || str[temp].equals("group")) {
					ArrayList<String> arr1=new ArrayList<>();
					arr1.add(str[prev]);
					arr1.add(str[prev+1]);
					String s = "";
					for(int j = prev+2;j<=curr;j++)
						s=s+str[j];
					arr1.add(s);
					cond1.add(arr1);
					break;
				}
				if(str[temp].equals("and") || str[temp].equals("or") ) {
					ArrayList<String> arr1=new ArrayList<>();
					arr1.add(str[prev]);
					arr1.add(str[prev+1]);
					String s = "";
					for(int j = prev+2;j<=curr;j++)
						s=s+str[j];
					arr1.add(s);
					cond1.add(arr1);
					if(str[temp].equals("or"))
						logic.add("or");
					else if(str[temp].equals("and"))
						logic.add("and");
					prev=temp+1;
				}
				else {
					curr=temp;
				}
				
			}
		}
		return 1;
	}
	int addOrder() {
		int temp;
		int flag=0;
		for(temp=i+1;temp<str.length;temp++) {
			if(str[temp].equals("order")){
				flag=1;
				break;
			}
		}
		if(flag==1) {
			for(temp=temp+2;temp<str.length;temp++) {
				if((str[temp].equals("where") || str[temp].equals("group")))
					break;
				cond3.add(str[temp]);
			}
		}
		return 1;
		
	}
	int addGroup() {
		int temp;
		int flag=0;
		for(temp=i+1;temp<str.length;temp++) {
			if(str[temp].equals("group")){
				flag=1;
				break;
			}
		}
		if(flag==1) {
			for(temp=temp+2;temp<str.length;temp++) {
				if((str[temp].equals("group")))
					break;
				if(str[temp].equals("where"))
					return 0;
				cond2.add(str[temp]);
			}
		}
		return 1;
	}
	void get() {
		for(String temp : cond2)
			System.out.print(temp+" ");
		
			
	}
  /*  void  get() {
    	System.out.println("Column :");
    	for(String temp : myList) {
    		System.out.println(temp);
    	}
    	
    	System.out.println("File Name:");
    	System.out.println(FileName);
    	
    	System.out.println("Where :-");
    	for(String temp : cond1) {
    		System.out.println(temp);
    	}
    	
    	System.out.println("Group :-");
    	for(String temp : cond2) {
    		System.out.println(temp);
    	}
    	
    	System.out.println("Order :-");
    	for(String temp : cond3) {
    		System.out.println(temp);
    	}
    }*/
}
