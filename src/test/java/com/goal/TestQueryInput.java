package com.goal;
import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TestQueryInput {
	QuerySplit obj = null;
   @BeforeAll
   public static void init() {
	   System.out.println("All hello");
   }
   @BeforeEach
   public void setup() {
	   obj = new QuerySplit();
	   System.out.println("Hello");
   }
   @Test
   public void testQuery() {
	  String arr[]=obj.getSplit("Select colm,com2 from nik.csv");
	  String[] expected=new String[]{"Select","colm","com2","from","nik.csv"};
	  double flag = 1;
	  if(arr.length !=expected.length)
		  flag=0;
	  for(int i=0;i<arr.length;i++) {
		  if(! arr[i].equals(expected[i])) {
			  flag=0;
			  break;
		  }
			  
	  }
	  Assertions.assertEquals(1,flag,0.1);
   }
   
   @AfterEach
   public void tearDown() {
	   obj= null;
	   System.out.println("Hello");
   }
   @AfterAll
   public static void clean() {
	   System.out.println("Bye-Bye");
   }
}
