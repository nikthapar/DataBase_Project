package com.goal;
import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class tsetaddOrder {
	QueryParameter obj = null;
   @BeforeAll
   public static void init() {
	   System.out.println("All hello");
   }
   @BeforeEach
   public void setup() {
	   System.out.println("Hello");
   }
  
   @Test
   public void testFile() {
	   String name[]= new String[] {"select","*","from","nik.csv","order","by","city"};
	   obj=new QueryParameter(name);
	   obj.i=0;
	   double flag = obj.addOrder();
	   Assertions.assertEquals(1,flag);
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
