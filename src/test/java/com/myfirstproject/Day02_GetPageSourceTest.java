package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSourceTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        Test if amazon contains “Registry” on the homepage
        driver.get("https://www.amazon.com/");
        String pageSource = driver.getPageSource();//returns the current source code on the page
        // System.out.println(pageSource);

        // Verification
        if (pageSource.contains("Registry")){//Verification
            System.out.println("PASS");
        }else {
            System.out.println("FAIL Registry is not exists on the page...");
        }

        // Close the browser
        driver.quit();
    }
}