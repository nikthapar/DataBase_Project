package com.goal;

import java.io.*;
import java.util.*;
public class Test1 {
        static String []header=null;
        int row=0;
        LinkedHashMap<String,ArrayList<Object>> FileRead()throws IOException {
		LinkedHashMap<String,ArrayList<Object>> obj = new LinkedHashMap<>();
		String filename = QueryParameter.FileName;
		String temp1="src/main/java/com/goal/";
		temp1=temp1+filename;
		File f=new File(temp1);
		BufferedReader br = new BufferedReader(new FileReader(f));
        String head=br.readLine();
        header=head.split(",");
        for(int i=0;i<header.length;i++) {
        	ArrayList<Object> temp = new ArrayList<>();//value
        	obj.put(header[i], temp); //compleate map
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
