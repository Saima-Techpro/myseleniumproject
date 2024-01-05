package com.myfirstproject.homework;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HW05_GoogleElements extends TestBase {
    /*
Create a new class and create 3 different test methods using the following names. And Go to google. 
titleTest =>Verify if google title = “Google” 
imageTest => Verify if google image displays or not 
gmailLinkTest => Verify if the Gmail link is displayed or not
     */
    @Test
    public void titleTest(){
        driver.get("https://www.google.com");
        Assertions.assertEquals("Google",driver.getTitle());
    }
    @Test
    public void imageTest(){
        driver.get("https://www.google.com");
        Assertions.assertTrue(driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed());
    }
    @Test
    public void gmailLinkTest(){
        driver.get("https://www.google.com");
        Assertions.assertTrue(driver.findElement(By.linkText("Gmail")).isDisplayed());
    }

}
