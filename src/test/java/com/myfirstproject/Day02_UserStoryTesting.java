package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_UserStoryTesting {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

//        //When user goes to walmart
//        driver.get("https://www.walmart.com");
//        Thread.sleep(2000);
//        //Then goes to amazon
//        driver.navigate().to("https://amazon.com");
//        Thread.sleep(2000);
//        //Navigate back to Walmart
//        driver.navigate().back();
//        Thread.sleep(2000);
//        //Navigate forward to amazon
//        driver.navigate().forward();
//        Thread.sleep(2000);
//        //Refresh the page
//        driver.navigate().refresh();
//        Thread.sleep(2000);
//        //Close/Quit the browser
//        driver.quit();

//---------------------------------------------------------------------
//        2nd User Story
//        Navigate to  amazon homepage
        driver.get("https://www.amazon.com");
//        Verify if page title is Amazon.com
        String title = driver.getTitle();
        if(title.equalsIgnoreCase("Amazon.com")) {
            System.out.println("The title is displayed correctly!");
        } else {
            System.out.println("The title is not seen as expected!");
        }
//        Close the window
        driver.quit();

    }
}
