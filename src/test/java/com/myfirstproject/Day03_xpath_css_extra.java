package com.myfirstproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_xpath_css_extra {
    WebDriver driver;
    @BeforeEach//runs before each test method
    public void setUp(){
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
    }
    @Test
    public void xpath_css(){
        //log in the application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //locate username
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        //locate password
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("admin123");
        //submit button xpath : //button[@type='submit']  ----- css : button[type='submit']
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        //Assert login is successful
        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));

        driver.findElement(By.xpath("(//a)[3]")).click();
        //driver.findElement(By.xpath("(//span[text()='PIM']")).click();
    }
//    @AfterEach
//    public void tearDown(){
//        driver.quit();
//    }

}
