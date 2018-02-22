package com.goal;
import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TestQueryFormat {
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
	   String arr[]= new String[] {"select","from","nik.csv"};
	   obj = new QueryParameter(arr);
	   double flag = obj.addCol();
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
