package com.myfirstproject.practices.practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01_Navigate {
    /*
         Set Driver Path
         Create chrome driver object
         Maximize the window
         Open google home page https://www.google.com/
         Navigate to techproeducation home page https://techproeducation.com/
         Navigate back to google
         Navigate forward to techproeducation
         Refresh the page
         Close/Quit the browser
         And last step : print "ALL OK" on console
    */
    public static void main(String[] args) throws InterruptedException {

//        Set Driver Path
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

//        Create chrome driver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Open google home page https://www.google.com/
        Thread.sleep(2000);
        driver.get("https://google.com/");

//        Navigate to techproeducation home page https://techproeducation.com/
        Thread.sleep(2000);
        driver.get("https://techproeducation.com/");

//        Navigate back to google
        Thread.sleep(2000);
        driver.navigate().back();

//        Navigate forward to techproeducation
        Thread.sleep(2000);
        driver.navigate().forward();

//        Refresh the page
        Thread.sleep(2000);
        driver.navigate().refresh();

//        Close/Quit the browser
        Thread.sleep(2000);
        //driver.close();//close() method closes only one current window
        driver.quit();//quit() method closes all windows that was opened in one single driver in a session

//        And last step : print "ALL OK" on console
        System.out.println("ALL OK");

    }
}
