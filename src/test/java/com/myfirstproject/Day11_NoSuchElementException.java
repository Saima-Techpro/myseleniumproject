package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day11_NoSuchElementException extends TestBase {
    @Test
    public void noSuchElementTest(){
        driver.get("https://www.amazon.com");
//        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")); // correct locator
//        searchBox.sendKeys("tea pot"+ Keys.ENTER);

        WebElement searchBox = driver.findElement(By.xpath("//input[@id=' twotabsearchtextbox']"));//NoSuchElementException due to the space. wrong locator
        searchBox.sendKeys("tea pot"+ Keys.ENTER);
    }
    @Test
    public void noSuchElementTest2(){
        driver.get("https://jqueryui.com/droppable/");
//        switchIframeByIndex(0);
        WebElement source = driver.findElement(By.id("draggable"));//NoSuchElementException.inside iframe.
        WebElement target = driver.findElement(By.id("droppable"));//inside iframe
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release().build().perform();
    }
}
