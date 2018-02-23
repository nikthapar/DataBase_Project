package com.goal;

import java.util.*;
import java.util.regex.Pattern;

public class ExeQuery {
     List<String> col= new ArrayList<String> ();
     LinkedHashMap<String,ArrayList<Object>> map = null;
     int row;
 	 ArrayList<Integer> id_2 =null;
     Set<String> key= null;
     String arr[][]=null;
     ArrayList<ArrayList<String>> cond1=null;
	 ArrayList<String> logic = null;
	 ArrayList<String> cond3=null;
	 ArrayList<String> fun1 = null;
	 ArrayList<String> cond2 = null;
	 HashMap<String,Integer> index= new HashMap<>();
     ExeQuery(List<String> myList , LinkedHashMap<String,ArrayList<Object>> map,int row,ArrayList<ArrayList<String>> cond12, ArrayList<String> logic2, ArrayList<String> cond3, ArrayList<String> fun1,ArrayList<String> cond2){
    	 super();
    	 this.col=myList;
    	 this.map=map;
    	 this.row=row;
    	 key = map.keySet();
    	 arr= new String[row+1][key.size()];
    	 cond1=cond12;
    	 logic = logic2;
    	 this.cond3=cond3;
    	 id_2 = new ArrayList<>();
    	 this.fun1=fun1;
    	 this.cond2=cond2;
    	 for(int i=1;i<=69;i++)
    		 id_2.add((Integer)i);
     }
	void Matrix() {
    		    arr=new String[row+1][key.size()];
    		    int count1=1;
    		    int count2=0;
    		    int ind = 0;
    		    for(String each : key) {
    		    	index.put(each, ind);
    		    	ind++;
    		    	arr[0][count2]=each;
    		    	ArrayList<Object> obj=map.get(each);
    		    	for(Object ele : obj) {
    		    		String s =(String)ele;
    		    		String s1[]=s.split(" ");
    		    		s="";
    		    		for(String s2 : s1) {
    		    			s=s+s2;
    		    		}
    		    		arr[count1][count2]=s;
    		    		count1++;
    		    	}
    		    	count1=1;
    		    	count2++;
    		    }
    }
     int  exwhere() {
    	ArrayList<ArrayList<Integer>> id = new ArrayList<>();
    	for(ArrayList<String> cond : cond1) {
    		int col=-1;
    		for(int i=0 ; i< key.size();i++) {
    			if(arr[0][i].equals(cond.get(0))) {
    				col=i;
    				break;
    				
    			}
    		}
    		if(cond.size()!=3)
    			return 0;
    		if(col == -1)
    			return 0;
    	 ArrayList<Integer> id_1=new ArrayList<>();
   		 for(int i=1;i<row+1;i++) {
   			 if(cond.get(1).equals("=")) {
   				 if(Pattern.matches( "[0-9]*",arr[i][col])) {
   					 int a=Integer.parseInt(arr[i][col]);
   					 int b=Integer.parseInt(cond.get(2));
   					 if(a == b)
   						 id_1.add(i);
   				 }
   				 else {
   					 String a = arr[i][col].toLowerCase();
   					 String b = cond.get(2).toLowerCase();
   					 if(a.equals(b)) {
   						 id_1.add(i);
   						 //System.out.println("helo");
   					 }
   				 }
   			 }
   			 else if(cond.get(1).equals("!=")) {
   				 if(Pattern.matches( "[0-9]*",arr[i][col])) {
   					 int a=Integer.parseInt(arr[i][col]);
   					 int b=Integer.parseInt(cond.get(2));
   					 if(a != b)
   						 id_1.add(i);
   				 }
   				 else {
   					 String a = arr[i][col].toLowerCase();
   					 String b = cond.get(2).toLowerCase();
   					 if( ! a.equals(b)) {
   						 id_1.add(i);
   						 //System.out.println("helo");
   					 }
   				 }
   			 }
   			 else if(cond.get(1).equals(">")) {
   				 if(Pattern.matches( "[0-9]*",arr[i][col])) {
   					 int a=Integer.parseInt(arr[i][col]);
   					 int b=Integer.parseInt(cond.get(2));
   					 if(a > b)
   						 id_1.add(i);
   				 }
   				 else {
   					 if(arr[i][col].compareTo(cond.get(2)) > 0) {
   						 id_1.add(i);
   					 }
   				 }
   				 
   			 }
   			 else if(cond.get(1).equals("<")) {
   				if(Pattern.matches( "[0-9]*",arr[i][col])) {
  					 int a=Integer.parseInt(arr[i][col]);
  					 int b=Integer.parseInt(cond.get(2));
  					 if(a < b)
  						 id_1.add(i);
  				 }
  				 else {
  					 if(arr[i][col].compareTo(cond.get(2)) < 0) {
  						 id_1.add(i);
  					 }
  				 }
   			 }
   			 else
   				 return 0;
   		 }
   		 id.add(id_1);

    		
    	}
    	
    	/* for(ArrayList<Integer> temp1 : id) {
    		 for(Integer temp2 : temp1) {
    			 System.out.print(temp2 + " ");
    		 }
    		 System.out.println();
    		 
    	 }*/
         id_2 = new ArrayList<>(id.get(0));
    	 int get1 = 1;
    	 for(String log : logic) {
    		 if(log.equals("and")) {
    			 id_2.retainAll(id.get(get1));
    			 //System.out.println(id_2.size());
    		 }
    		 else if(log.equals("or")){
    			 for(Integer temp1 : id.get(get1)) {
    				 int flag=0;
    				 for(Integer temp2 : id_2) {
    					 if(temp1.equals(temp2)) {
    						 flag=1;
    						 break;
    					 }
    				 }
    				 if(flag==0)
    					 id_2.add(temp1);
    			 }
    		 }
    		// System.out.println("hello");
    		 get1++;
    	 }
    	/* for(Integer temp : id_2) {
    		 System.out.print(temp+" ");
    	 }
    	 System.out.println();
    	 for(Integer temp : id_2) {
    		 for(int j=0;j<key.size();j++) {
    			 System.out.print(arr[temp][j]+" ");
    		 }
    		 System.out.println();
    	 }*/
    	 return 1;
    	
   }
     void orderBy() {
    	 String column = cond3.get(0);
    	 int val =0;
    	 for(int j=0;j<key.size();j++) {
    		 String a= column.toLowerCase();
 			 String b = arr[0][j].toLowerCase();
 			 if(a.equals(b)) {
 				 val=j;
 				 break;
 			 }
    	 }
    	 
	     final int val1=val;
	     if( ! Pattern.matches("[0-9]*", arr[1][val])) {
	    	 Collections.sort(id_2, (a1,a2)->{
	    		 return arr[a1][val1].compareTo(arr[a2][val1]);
	    	 });
	     }
	     else {
	    	 Collections.sort(id_2, (a1,a2)->{
	    		 int a=Integer.parseInt(arr[(int) a1][val1]);
	    		 int b=Integer.parseInt(arr[(int)a2][val1]);
	    		 return a-b;
	    	 });
	     }
    	
    	 
     }
    int colfeild() {
    	List<String> col = QueryParameter.myList;
    	List<Integer> val = new ArrayList<>();
    	for(String temp : col) {
    		int flag=0;
    		for(int j=0;j<key.size();j++) {
    			String a= temp.toLowerCase();
    			String b = arr[0][j].toLowerCase();
    		    if(a.equals(b)) {
    				val.add(j);
    				flag=1;
    				break;
    			}
    		}
    		/*if(flag == 0)
    			return 0;*/
    	}
    	if(col.get(0).equals("*")) {
    		if(col.size() > 1)
    			return 0;
    		for(Integer temp : id_2) {
    			for(int j=0;j<key.size();j++) {
    				System.out.print(arr[temp][j] +" ");
    			}
    			System.out.println();
    		}
    	}
    	else {
    		for(Integer i : id_2) {
    			for(Integer j : val) {
    				System.out.print(arr[i][j] + " ");
    			}
    			System.out.println();
    		}
    	}
    	return 1;
    }
    void aggregate() {
    	for(String s : fun1) {
    		int p = s.indexOf("(");
    		int q = s.indexOf(")");
    		String s1 = s.substring(0,p);
    		String s2 = s.substring(p+1,q);
    		if(s1.toLowerCase().equals("sum")) {
    			ArrayList<Object> arr = map.get(s2);
     		    int count =0;
     		    for(Object temp : arr) {
     			int p1 = Integer.parseInt((String)temp);
     			count=count+p1;
     		   }
     		    System.out.println("SUM "+count);
    		}
    		else if(s1.toLowerCase().equals("max")) {
    			ArrayList<Object> arr = map.get(s2);
     		    int max1 =0;
     		    for(Object temp : arr) {
     			int p1 = Integer.parseInt((String)temp);
     			if(max1 < p1)
     				max1=p1;
     		   }
     		    System.out.println("MAX "+max1);
    		}
    		else if(s1.toLowerCase().equals("min")) {
    			ArrayList<Object> arr = map.get(s2);
     		    int min1 =9999999;
     		    for(Object temp : arr) {
     			int p1 = Integer.parseInt((String)temp);
     			if(min1 > p1)
     				min1=p1;
     		   }
     		    System.out.println("MIN "+min1);
    		}
    		else if(s1.toLowerCase().equals("count")) {
    			ArrayList<Object> arr = map.get(s2);
     		    System.out.println("Count "+arr.size());
    		}
    	}
    }
    void group() {
    	LinkedHashMap<String,Integer> m = new LinkedHashMap<>();
    	String s = fun1.get(0);
        int p = s.indexOf("(");
 		int q = s.indexOf(")");
 		String s1 = s.substring(0,p);
 		String s2 = s.substring(p+1,q);
        for(Integer i : id_2) {
        	String p1 = "";
        	for(String co : cond2) {
        		p1=p1+arr[i][index.get(co)]+",";
        	}
    		//int col=index.get(cond2.get(0));
        	if(! m.containsKey(p1)) {
        		if(s1.toLowerCase().equals("sum")){
        			int val = Integer.parseInt(arr[i][index.get(s2)]);
        			m.put(p1,val);
        		}
        		else if(s1.toLowerCase().equals("max")){
        			int val = Integer.parseInt(arr[i][index.get(s2)]);
        			m.put(p1,val);
        		}
        		else if(s1.toLowerCase().equals("min")){
        			int val = Integer.parseInt(arr[i][index.get(s2)]);
        			m.put(p1,val);
        		}
        		else if(s1.toLowerCase().equals("count")){
        			//int val = Integer.parseInt(arr[i][index.get(s2)]);
        			m.put(p1,1);
        		}
        	}
        	else {
        		int a = m.get(p1);
        		if(s1.toLowerCase().equals("sum")){
        			int val = Integer.parseInt(arr[i][index.get(s2)]);
        			m.put(p1,val+a);
        		}
        		else if(s1.toLowerCase().equals("max")){
        			int val = Integer.parseInt(arr[i][index.get(s2)]);
        			if(val > a)
        				a=val;
        			m.put(p1,a);
        		}
        		else if(s1.toLowerCase().equals("min")){
        			int val = Integer.parseInt(arr[i][index.get(s2)]);
        			if(val < a)
        				a=val;
        			m.put(p1,a);
        		}
        		else if(s1.toLowerCase().equals("count")){
        			//int val = Integer.parseInt(arr[i][index.get(s2)]);
        			m.put(p1,1+a);
        		}
        	}
        }
        Set<String> key=m.keySet();
        for(String temp : key) {
        	String str[]=temp.split(",");
        	for(int i=0;i<str.length;i++)
        		System.out.print(str[i]+" ");
        	System.out.println(m.get(temp));
        }
    }
    
     
}
