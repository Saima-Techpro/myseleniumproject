package com.myfirstproject.practices.practice05;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q06_WaitForClickability extends TestBase {
    /*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click on Ajax Loader
    And
        Click on "Click Me!" button
    Then
        Assert that button is clicked
    And
        Take screenshot after each step
 */

    @Test
    public void test(){
//        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        captureScreenshotEntirePage();

//        Click on Ajax Loader
        driver.findElement(By.linkText("CLICK ME!")).click();
        captureScreenshotEntirePage();

//        Click on "Click Me!" button
        WebElement button1 = driver.findElement(By.id("button1"));
//        button1.click();  // traditional way ... if implicit wait is enough, it wil work otherwise it will fail
        waitForClickablility(button1,10).click();
        captureScreenshotEntirePage();

//        Assert that button is clicked
        WebElement successMessage = driver.findElement(By.xpath("//h4"));
        String successMessageText = waitForVisibility(successMessage,5).getText();//For the synchronization issue
        assertTrue(successMessageText.contains("Well Done"));
        captureScreenshotEntirePage();

//        Take screenshot after each step


    }
}
