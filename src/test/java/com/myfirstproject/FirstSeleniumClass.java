package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumClass {

    public static void main(String[] args) {


        // 1. Set the path of the driver
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver"); // MAC
        // System.setProperty("webdriver.firefox.driver", "./drivers/chromedriver"); // MAC
        // System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe"); // WINDOWS

        // 2. Create the driver
        WebDriver driver = new ChromeDriver();
      //  WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com/");
    }
}


//     command + n ... allows you to add dependency directly from pom.xml file