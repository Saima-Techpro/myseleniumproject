package com.myfirstproject;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class Day02_JUnitAnnotations {
    /*
    1. @Test : This is used to create TEST CASES.
    This is one of the most common annotation that we will use

    Note that all test methods should be void

    2. @BeforeAll and @AfterAll runs only ONCE before or after each CLASS
    3. @BeforeEach and @AfterEach runs only ONCE before or after each METHOD
    4. @Disabled is used to ignore/skip a test case in JUnit 5
     */
    @BeforeAll
    public static void setUpClass(){
        System.out.println("Before All...");
    }
    @AfterAll
    public static void tearDownClass(){
        System.out.println("After All...");
    }
    @BeforeEach
    public void setUpMethods(){
        System.out.println("Before Each....");
    }
    @AfterEach
    public void tearDownMethods(){
        System.out.println("After Each...");
    }

    @Test
    public void test1(){
        System.out.println("Test Case 1...");
    }
    @Test
    public void test2(){
        System.out.println("Test Case 2...");
    }
    @Test
    public void test3(){
        System.out.println("Test Case 3...");
    }
    @Test @Disabled
    public void test4(){
        System.out.println("Test Case 4...");
    }
    @Test
    public void test5(){
        System.out.println("Test Case 5...");
    }
    @Test @Disabled
    public void test6(){
        System.out.println("Test Case 6...");
    }

}
