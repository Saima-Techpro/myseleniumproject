package com.myfirstproject.practices.practice07;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PO3 extends TestBase {
    //Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    //Click me, to open an ... button
    //Close the resulting alert

    @Test
    void test01() {

        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Click me, to open an ... butonuna basalım
        WebElement button = driver.findElement(By.cssSelector("#alert"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());//Alert görünür olana kadar bekle

        //Çıkan alert'i kapatalım
        driver.switchTo().alert().accept();

    }
}
