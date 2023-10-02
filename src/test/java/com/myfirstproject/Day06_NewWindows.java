package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

public class Day06_NewWindows extends TestBase {
    @Test
    public void newTabTest(){
//        Open the pages in 2 new windows and verify their TITLES
//        Linkedin
        driver.get("https://www.linkedin.com/");
        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkedinHandle = driver.getWindowHandle();
//        Ebay
//        I would like to open ebay page in a new TAB
        driver.switchTo().newWindow(WindowType.TAB);//CREATES A NEW TAB AND SWITCH TO NEW TAB
//        driver is on the new TAB at this point
        driver.get("https://www.ebay.com/");
        Assertions.assertTrue(driver.getTitle().contains("eBay"));
        String ebayHandle = driver.getWindowHandle();
//        Switch back to the linkedin page
        driver.switchTo().window(linkedinHandle);
        System.out.println("LINKEDIN URL "+driver.getCurrentUrl());
//        Switch back to ebay page
        driver.switchTo().window(ebayHandle);
        System.out.println("EBAY URL "+driver.getCurrentUrl());
    }

    @Test
    public void newWindowTest() throws InterruptedException {
        //        Open the pages in 2 new windows and verify their TITLES
//        Linkedin
        driver.get("https://www.linkedin.com/");
        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkedinHandle = driver.getWindowHandle();
//        Ebay
//        I would like to open ebay page in a new TAB
        driver.switchTo().newWindow(WindowType.WINDOW);//CREATES A NEW TAB AND SWITCH TO NEW WINDOW
//        driver is on the new TAB at this point
        driver.get("https://www.ebay.com/");
        Assertions.assertTrue(driver.getTitle().contains("eBay"));
        String ebayHandle = driver.getWindowHandle();
        Thread.sleep(3000);
//        Switch back to the linkedin page
        driver.switchTo().window(linkedinHandle);
        System.out.println("LINKEDIN URL "+driver.getCurrentUrl());
        Thread.sleep(3000);
//        Switch back to ebay page
        driver.switchTo().window(ebayHandle);
        System.out.println("EBAY URL "+driver.getCurrentUrl());
    }
}
