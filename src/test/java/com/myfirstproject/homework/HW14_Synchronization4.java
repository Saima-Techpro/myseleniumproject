package com.myfirstproject.homework;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HW14_Synchronization4 extends TestBase {
    @Test
    public void test4(){
//        EXPLICIT WAIT MUST BE USED WHEN IMPLICIT WAIT CANNOT HANDLE THE WAITING ISSUE
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    Click enable Button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
//        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled()); //IF FAILS,  EXPLICIT WAIT MUST BE USED
        //    And verify the message is equal to “It's enabled!”
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enabledMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String enabledMessageText=enabledMessage.getText();
        Assertions.assertEquals(enabledMessageText,"It's enabled!");

        //    And verify the textbox is enabled (I can type in the box)
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertTrue(textBox.isEnabled());//isEnables checks if an element is enable. Returns true if enabled, returns false if disabled.

//        click on disable button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isDisplayed());

    }
}
