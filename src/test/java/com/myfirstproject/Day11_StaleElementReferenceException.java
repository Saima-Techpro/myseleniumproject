package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day11_StaleElementReferenceException extends TestBase {
    @Test
    public void staleReferenceTest(){
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("tea pot"+ Keys.ENTER);
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();//back on amazon

        searchBox.sendKeys("tea pot"+ Keys.ENTER);//StaleElementReferenceException due to the searchBox reference is old
    }
    @Test
    public void staleReferenceSolutionTest(){
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("tea pot"+ Keys.ENTER);
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();//amazon
        // SOLUTION
        //REFRESHING THE REFERENCE SO THAT WE DO NOT GET STALE REFERENCE EXCEPTION
        searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("tea pot"+ Keys.ENTER);
//        OR ALTERNATIVELY
//        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("tea pot"+ Keys.ENTER);//StaleElementReferenceException due to the reference is old
    }
}
