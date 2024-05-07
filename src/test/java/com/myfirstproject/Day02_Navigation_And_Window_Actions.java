package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_Navigation_And_Window_Actions {

    public static void main(String[] arg) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //Getting the page title
        System.out.println(driver.getTitle());


        //Getting page URL
        String url = driver.getCurrentUrl();
        System.out.println(url);

        //Getting page source
        String source = driver.getPageSource();
        //System.out.println(source);

        //Getting window handle -> is the unique ID for each window and it is the string value
        String handle = driver.getWindowHandle();
        System.out.println("The handle is " + handle);

        //Navigation actions
        driver.navigate().to("https://amazon.com"); //->visiting to amazon
        Thread.sleep(2000);
        driver.navigate().back(); //->visiting back to google
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);// -> visit to forward page
        driver.navigate().refresh();
        Thread.sleep(2000);//-> refreshes the current page


        //Note: When we use navigate, the system does not wait for running the codes until the page is loaded. When we use get, the system waits until the page is loaded before running the next codes.
        //        When we use navigate, we can go back or forward pages. When we use get, it is like the current and only the page you visit.

        //------------------------------------------------------------------------------------------------------------------------------------
        //Windows maximizing
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //driver.manage().window().minimize();
        Thread.sleep(2000);

        //-------------------------------------------------------------------------------------------------------------------------------------
        //When we use driver.quit(), it will close all the opened tab pages. When we use driver.close(), it will close only the coding active page.
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(5000);
        driver.quit();
    }
}
