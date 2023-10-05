package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q02_DragAndDrop extends TestBase {
    /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below
    Then
        Verify they are dropped.
  */

    @Test
    public void test() {

//        Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");

//        Drag orange elements on proper boxes below
        //Locate source elements
        WebElement firstAmount = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement secondAmount = driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement sales = driver.findElement(By.id("credit1"));

        //Locate target elements
        WebElement debitAccount = driver.findElement(By.id("bank"));
        WebElement debitAmount = driver.findElement(By.id("amt7"));
        WebElement creditAccount = driver.findElement(By.id("loan"));
        WebElement creditAmount = driver.findElement(By.id("amt8"));


        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(firstAmount, debitAmount)
                .dragAndDrop(secondAmount, creditAmount)
                .dragAndDrop(bank, debitAccount)
                .dragAndDrop(sales, creditAccount)
                .perform();

//        Verify they are dropped.
        String successMessage = driver.findElement(By.id("equal")).getText();
        waitFor(4);
        System.out.println("successMessage = " + successMessage);
        assertTrue(successMessage.contains("Perfect"));

    }

}
