package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_RadioButton2 extends TestBase {

    /*
remove @Before and @After from this class. And extend it to TestBase
now this class is shorter and cleaner
 */
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

}
