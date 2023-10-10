package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day11_TimeoutException extends TestBase {
    @Test
    public void timeOutTest(){
        driver.get("https://www.amazon.com");
//        WebElement searchBox = driver.findElement(By.xpath("//input[@id=' twotabsearchtextbox']"));//NoSuchElementException due to the space. wrong locator
//        searchBox.sendKeys("tea pot"+ Keys.ENTER);

        // Maybe this failure is due to a wait problem
        WebElement searchBox = waitForVisibility(By.xpath("//input[@id=' twotabsearchtextbox']"),15);
         searchBox.sendKeys("tea pot"+ Keys.ENTER); //TimeoutException due to the explicit wait + element not found
        /*
        NOTE:
        driver.findElement(By.xpath("//input[@id=' twotabsearchtextbox']")) = waitForVisibility(By.xpath("//input[@id=' twotabsearchtextbox']"),15)
         */
    }
}
