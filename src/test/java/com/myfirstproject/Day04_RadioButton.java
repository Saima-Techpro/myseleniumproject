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
public class Day04_RadioButton {
    WebDriver driver;
    @BeforeEach//runs before each test method
    public void setUp(){
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
    }
    @Test
    public void radioTest(){
//        Go to the url https://testcenter.techproeducation.com/index.php?page=radio-buttons
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
//        Click on Red if not already checked
        WebElement red = driver.findElement(By.cssSelector("#red"));
        if (!red.isSelected()){
            red.click();
        }
//        Click on Football if not already checked
        // WebElement football = driver.findElement(By.cssSelector("football"));  will need # symbol coz it's id
        WebElement football = driver.findElement(By.cssSelector("#football"));

        if (!football.isSelected()){
            football.click();
        }
//        Assertions
        Assertions.assertTrue(red.isSelected());
        Assertions.assertTrue(football.isSelected());

    }
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
