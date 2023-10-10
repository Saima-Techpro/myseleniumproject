package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day11_CaptureScreenshot extends TestBase {
    /*
Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
When User search for ‘uni’ in the search box
And select the ‘United Kingdom’ from the suggestions
Add click on submit button
Then verify the result contains united Kingdom

     */
    @Test
    public void captureScreenshotTest(){
//        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        captureScreenshotEntirePage();
//        When user search for 'uni' in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        waitFor(1);
        captureScreenshotEntirePage();
//        And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
        waitFor(1);
        captureScreenshotEntirePage();
//        And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();

//        Then verify the result contains ‘United Kingdom’
        waitFor(1);
        Assertions.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));
        captureScreenshotEntirePage();
    }

}
