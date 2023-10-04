package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_JSExecutor extends TestBase {
    @Test
    public void jsExecutorTest1() throws InterruptedException {
//        Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
//        When use click on “Account” link
        WebElement accountListTab = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountListTab).perform();

       //  actionsHoverOnElement(accountListTab); // using Reusable Method from TestBase
        Thread.sleep(1000);
        // Click on account link
        WebElement accountLink = driver.findElement(By.linkText("Account"));
//        accountLink.click();//normal click
//        actions.click(accountLink);//actions click

//        If these 2 clicks do not work, we can js click that is stronger
//        1.  create javascript reference
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        2. use executeScript to execute js code
        js.executeScript("arguments[0].click();",accountLink);//clicking accountLink using js executor
        Thread.sleep(1000);
//        Then verify the page title contains “Your Account”
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));
//        Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        js.executeScript("arguments[0].scrollIntoView(true);",amazonMusic);//scrolling into amazonMusic element using js executor
        Thread.sleep(1000);
//        And click on it
        js.executeScript("arguments[0].click();",amazonMusic);
        Thread.sleep(1000);
//        Then verify Amazon Music page is displayed
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
//        Scroll the page up and down
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");//Scroll all the way down
        Thread.sleep(3000);
       // js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");//Scroll all the way up
        scrollAllDownJS();//with reusable method
        waitFor(2);
//        LOCATE THE SEARCH BOX USING JS EXECUTOR
        WebElement searchBox = locateElementByJS("navbarSearchInput");
//        TYPE POP MUSIC
//        First choice is sendKeys() method... but we also type in thr input box using JSExecutor method
        setValueByJS(searchBox,"POP MUSIC");
//        GET AND PRINT THE VALUE OF THAT INPUT
        waitFor(2);
        String inputValue = getValueByJS("navbarSearchInput");
        System.out.println(inputValue);
/*
Javascript executor is a selenium class that is used to run javascript codes
We should prefer normal selenium methods, but sometimes they may not work(element.click() may not click)
Then we can try javascript executor methods
Popular js executor methods ->  click(), scroll into view,
Less popular js executor methods -> get elements values, locating the elements javascript wait
 */
    }
}
