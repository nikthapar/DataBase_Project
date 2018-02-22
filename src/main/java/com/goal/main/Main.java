package com.goal.main;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
    	 QuerySplit goal1 = new QuerySplit();
         String query=goal1.getString();
         String arr[]=goal1.getSplit(query);
         QueryParameter para = new QueryParameter(arr);
         para.addCol();
         para.addFile();
         para.addGroup();
         para.addWhere();
         para.addOrder();
         Test read = new Test();
         LinkedHashMap<String,ArrayList<Object>> map = read.FileRead();
         int row=read.getHeader();
         ExeQuery test1 = new ExeQuery(QueryParameter.myList , map, row, para.cond1, para.logic, para.cond3, para.fun1,para.cond2);
         test1.Matrix();
         if(para.cond1.size() !=0 && para.cond3.size() !=0) {
        	 test1.exwhere();
        	 test1.orderBy();
        	 if(para.cond2.size() !=0)
                 test1.group();
        	 else
        	    test1.colfeild();
         }
         else if(para.cond1.size() !=0 || para.cond3.size() !=0) {
        	 if(para.cond1.size() !=0) {
        		 test1.exwhere();
        		 if(para.cond2.size() !=0)
                     test1.group();
        		 else
        		     test1.colfeild();
        	 }
        	 else {
        		 test1.orderBy();
        		 if(para.cond2.size() !=0)
                     test1.group();
        		 else
        		      test1.colfeild();
        	 }
         }
         else if(para.cond2.size()==0 && para.fun1.size()!=0)
            test1.aggregate();
         else if(para.cond2.size() !=0)
             test1.group();
         else
        	 test1.colfeild();
         
    }
    
}


