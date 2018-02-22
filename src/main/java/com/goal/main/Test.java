package com.goal.main;

import java.io.*;
import java.util.*;
public class Test {
        static String []header=null;
        int row=0;
        LinkedHashMap<String,ArrayList<Object>> FileRead()throws IOException {
		LinkedHashMap<String,ArrayList<Object>> obj = new LinkedHashMap<>();
		File f=new File("src\\main\\java\\com\\goal\\main\\ipl.csv");
		BufferedReader br = new BufferedReader(new FileReader(f));
        String head=br.readLine();
        header=head.split(",");
      /*  for(String temp : he
       * ader) {
        	System.out.println(temp);
        }*/
        for(int i=0;i<header.length;i++) {
        	ArrayList<Object> temp = new ArrayList<>();//value
        	obj.put(header[i], temp);//compleate map
        }
        
        head=br.readLine();
        while(head != null) {
        	String temp[]=head.split(",");
        	for(int i=0;i<header.length;i++) {
        		ArrayList<Object> p= obj.get(header[i]);
        	    p.add(temp[i]);
        	    obj.put(header[i], p);
        	}
        	head=br.readLine();
        }
       
        	
        br.close();
        row = (obj.get(header[0])).size();
        return obj;
	}
        int getHeader() {
        	return row;
        }

}
