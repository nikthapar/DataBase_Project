package com.goal;

import java.io.IOException;

import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TestFile {
	Test1 obj = null;
   @BeforeAll
   public static void init() {
	   System.out.println("All hello");
   }
   @BeforeEach
   public void setup() {
	   obj = new Test1();
	   System.out.println("Hello");
   }
   @Test
   public void testFile() {
	   Assertions.assertThrows(IOException.class,()->{
		   obj.FileRead();
	   });
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
