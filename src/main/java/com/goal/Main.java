package com.goal;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
    	 try {
			QuerySplit goal1 = new QuerySplit();
			 String query=goal1.getString();
			 if(query.equals(""))
				 throw new StringNotFound("Hint : Enter the String Before press Enter");
			 String arr[]=goal1.getSplit(query);
			 QueryParameter para = new QueryParameter(arr);
			 int x = para.addCol();
			 if(x == 0 )
				 throw new QueryNotCorrect("Query Not correct,Check select and from keywords in query");
			 para.addFile();
			 x=para.addGroup();
			 if(x==0) {
				 throw new QueryNotCorrect("Query Not Correct,Check group by statement");
			 }
			 x=para.addWhere();
			 if(x==0) {
				 throw new QueryNotCorrect("Query Not Correct,Check where conditions");
			 }
			 x=para.addOrder();
			 if(x==0) {
				 throw new QueryNotCorrect("Query Not Correct,Check Order by statement");
			 }
			 Test1 read = new Test1();
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
		}catch(QueryNotCorrect e) {
			System.out.println(e.getMessage());
		}
    	 catch(StringNotFound e) {
			System.out.println(e.getMessage());
		}
    	 catch (IOException e) {
			System.out.println("File Not Found , Please add the correct file name or path");
		}
         
    }
    
}


