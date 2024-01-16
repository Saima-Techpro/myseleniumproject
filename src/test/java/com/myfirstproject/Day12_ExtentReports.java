package com.myfirstproject;

import com.myfirstproject.utilitles.LoggerUtils;
import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class Day12_ExtentReports extends TestBase {
    @Test
    public void extentReportTest(){
//        Examples how to use different extentTest methods
        extentTest.info("Login should be active after registration");
        extentTest.warning("Pay attention to Login Button");
        extentTest.fail("Login button is not interactive");
        extentTest.skip("Registration is skipped for this test");
        extentTest.pass("Login is successful!");
//       NOTE: extentTest.pass() or other methods just log the messages; works just like System.out.println();
//       THEY DO NOT WORK AS HARD ASSERTION



//      For Testing, we use extentTest in conditions like below
//        Assertions.assertTrue("Amazon title".contains("Amazon"), "Amazon title test failed");
        if ("Amazon title".contains("amazon")){
            extentTest.pass("Amazon Title test PASSED");
        }else {
            extentTest.fail("Amazon Title test FAILED");
        }



    }
    @Test
    public void extentReportsTest2() throws IOException {

        LoggerUtils.info("Starting the test case about auto complete functionality");

        extentTest
                .pass("Navigating to the application home page") //marking test step as pass
                .assignAuthor("John","Sam","Nancy") // optional : adding authors
                .assignDevice("Mac","Windows") // optional : adding devices
                .assignCategory("Smoke","Regression","Integration") // optional : adding test categories
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString()); // optional : adding screenshot at this point
//        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        extentTest
                .pass("User is on the home page")  //marking test step as pass
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString(),"Home Page" ); // adding screenshot at this point


//        When user type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        waitFor(1);
        extentTest
                .pass("Typed 'uni' in the search box")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());  // adding screenshot at this point
//        And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
        waitFor(1);
        extentTest
                .pass("Selected 'United Kingdom' Option")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString()); // adding screenshot at this point


//        And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
//        Then verify the result contains ‘United Kingdom’
        waitFor(1);
        Assertions.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));
        extentTest
                .pass("Result contains United Kingdom")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString()); // adding screenshot at this point

        LoggerUtils.info("Test is complete successfully....");
    }
}
