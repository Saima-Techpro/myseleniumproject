package com.myfirstproject.homework;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsHW extends TestBase {

    /*
     //Given user is on the
    //https://practice-automation.com/
    // When user scrolls down to Hover button and click it
    // And hover over Mouse over me button
    // Then Verify it is hovered over
    // And user navigates back to https://practice-automation.com/
    //And click Pop ups button
    // And selects Prompt Popup
    //And writes your name with capitalized letters
    //And accept the alert
    // Then verify your name is displayed as capitalized letters
    //And user navigates back to https://practice-automation.com/
    // And click Gestures button
    // And drag automateNow image to the right box
    // Then verify the element is dragged
     */

    @Test
    public void HW1 () throws InterruptedException {

        // ØGiven user is on the https://practice-automation.com/
        driver.get("https://practice-automation.com/");
        String handleOfHomePage = driver.getWindowHandle();
        System.out.println(handleOfHomePage);

        //        ØWhen user scrolls down to Hover button and click it
        Actions actions = new Actions(driver);
        WebElement hoverButton = driver.findElement(By.xpath("//a[.='Hover']"));
        actions.scrollToElement(hoverButton).perform();
        hoverButton.click();

        //        ØAnd hover over Mouse over me button
        WebElement mouseOver = driver.findElement(By.id("mouse_over"));
        actions.moveToElement(mouseOver).perform();
        Thread.sleep(3000);

        //        ØThen Verify it is hovered over
        String iDidIt = mouseOver.getText();
        Assertions.assertTrue(iDidIt.contains("You did it!"));

        //        ØAnd user navigates back to https://practice-automation.com/
        driver.navigate().back();
        Thread.sleep(3000);

        //        ØAnd click Pop ups button
        WebElement popups = driver.findElement(By.linkText("Popups"));
        actions.moveToElement(popups).click().perform();

        //        ØAnd selects Prompt Popup
        WebElement promptButton = driver.findElement(By.id("prompt"));
        promptButton.click();

        //        ØAnd writes your name with capitalized letters

        driver.switchTo().alert().sendKeys("MERVE");
        Thread.sleep(5000);

        driver.switchTo().alert().accept();

        //        Ø Then verify your name is displayed as capitalized letters
        WebElement myName = driver.findElement(By.id("promptResult"));
        Assertions.assertTrue(myName.getText().contains("MERVE"));

        //        ØAnd user navigates back to https://practice-automation.com/
        driver.navigate().back();
        Thread.sleep(3000);

        //        ØAnd click Gestures button
        WebElement gestures = driver.findElement(By.linkText("Gestures"));
        actions.scrollToElement(gestures).perform();

        gestures.click();

        //        ØAnd drag automateNow image to the right box

        WebElement drag = driver.findElement(By.id("dragMe"));
        WebElement drop = driver.findElement(By.id("div2"));
        actions.moveToElement(drag);
        actions.dragAndDrop(drag, drop).perform();
        Thread.sleep(3000);

        //        ØThen verify the element is dragged

        Assertions.assertFalse(drop.getText().equals(drag));


    }
}
