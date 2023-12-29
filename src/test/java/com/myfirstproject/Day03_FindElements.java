package com.myfirstproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Day03_FindElements {

    WebDriver driver;
    @BeforeEach//runs before each test method
    public void setUp(){
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        // Thread.sleep(3000); Hard wait ... will wait for 3 seconds whether needed or not
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//implicit wait.. dynamic wait ... will wait if needed
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
       // driver.get("https://www.amazon.com/");
//        driver.navigate().refresh();
        driver.get("https://www.techproeducation.com/");


        List<WebElement> linkItems = driver.findElements(By.tagName("a"));
        System.out.println("linkItems = " + linkItems.size());

//        for (WebElement w: linkItems){
//            System.out.println(w.getText());
//        }

        // LAMBDA EXPRESSION
        linkItems.forEach(t -> {if (!t.getText().isEmpty()) {
            System.out.println(t.getText());
        }});
        System.out.println("******************************");
        List<WebElement> programList = driver.findElements(By.linkText("Upcoming Programs"));
        for (WebElement w: programList){
            System.out.println(w.getText());
        }


    }

}
