package com.myfirstproject.homework;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HW04_GoogleSearch extends TestBase {
    //    Create a new class  
//    Create Test method and complete the following task. 
//    When user goes to https://www.google.com/
//    Search for “porcelain teapot”
//    And print how many related results displayed on Google
    @Test
    public void searchTest() throws InterruptedException {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);//search then click Enter
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("result-stats")).getText());

    }
}
