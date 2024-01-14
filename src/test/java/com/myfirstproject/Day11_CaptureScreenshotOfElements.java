package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day11_CaptureScreenshotOfElements extends TestBase {
    @Test
    public void captureScreenshotOfElementsTest(){

//        When user goes to google homepage
        driver.get("https://www.google.com/");
        waitFor(1);
        WebElement image = driver.findElement(By.xpath("//img[@alt='Google']"));
        waitFor(1);
        captureScreenshotOfElement(image);
//        captureScreenshotOfElement(driver.findElement(By.xpath("//img[@alt='Google']")));  // OR DIRECTLY IN THE REUSABLE METHOD


//        Then verify the logo is displayed
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iphone 15 prices");
        waitFor(1);
        captureScreenshotOfElement(searchBox);


    }

    @Test
    public void captureScreenshotOfElementsTest2(){

//        When user goes to techproeducation homepage
        driver.get("https://techproeducation.com/");
        waitFor(1);
        WebElement image = driver.findElement(By.xpath("//img[@alt='TechPro Education']"));
        waitFor(1);
        captureScreenshotOfElement(image);


//        Then verify the logo is displayed
        WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));
        searchBox.sendKeys("testing");
        waitFor(1);
        captureScreenshotOfElement(searchBox);


    }
}
