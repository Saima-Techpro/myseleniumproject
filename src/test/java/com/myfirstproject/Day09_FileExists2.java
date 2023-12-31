package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day09_FileExists2 extends TestBase {

    @Test
    public void test2() {
         /*
        Given
            Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
        When
           Type "My File" into "Notes about the file" input
        And
            Click "Choose File" button
        And
            Select the file to upload
        And
            Click on "Press" button
        Then
            Assert that "Your notes on the file were" equals "My File"
        And
            Assert that file Content contains "Hello, I am uploaded file"
    */

//        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

//        Type "My File" into "Notes about the file" input
        driver.findElement(By.name("note")).sendKeys("My File");
        waitFor(2);

//        Click "Choose File" button
//        Select the file to upload
        // drag the file on terminal to get it's path   => /Users/saima/Desktop/flower.jpeg
        driver.findElement(By.name("upfile")).sendKeys("/Users/saima/Desktop/flower.jpeg ");
        waitFor(2);

//        Click on "Press" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//        Assert that "Your notes on the file were" equals "My File"
        String note = driver.findElement(By.xpath("//blockquote")).getText();
        System.out.println("note = " + note);
        assertEquals("My File", note);

//        Assert that file Content contains "Hello, I am uploaded file"
        String content = driver.findElement(By.xpath("//pre")).getText();
        System.out.println("content = " + content);
        assertEquals("Hello, I am uploaded file", content);



    }




}
