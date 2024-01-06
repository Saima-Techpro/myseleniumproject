package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day06_Windows_WithTestBase extends TestBase {

    /*
    This test is the same as in Day04_DropDown
    But we are using REUSABLE METHODS in TestBase
    It is RECOMMENDED to use REUSABLE METHODS whenever possible.
     */

    @Test
    public void windowsTestWithReusableMethods() throws InterruptedException {
        //        Given Go to https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
//        Assert if the window 1 title equals “The Internet”
        Assertions.assertTrue(driver.getTitle().equals("The Internet"));
//        Click on the link
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
//        Assert if the window 2 title equals “New Window”
        /*
        NOTE: we must switch window 2 to get window to tile
         */
//        String window1Handle = driver.getWindowHandle();
//        System.out.println(window1Handle);
//
//        Set<String> allWindowHandles = driver.getWindowHandles();
//        System.out.println(allWindowHandles);
//
//        for (String eachHandle : allWindowHandles){
//            if (!eachHandle.equals(window1Handle)){
//                driver.switchTo().window(eachHandle);
//                break;
//            }
//        }
//        NOTE: no need to do above code because we have a reusable method to switch to window
        switchNewWindowByIndex(1);//switching window 2(index = 1)  using REUSABLE METHOD FROM TestBase
//        ALTERNATIVELY WE CAN SWITCH BY TITLE
//        switchNewWindowByTitle("New Window");
//        NOW DRIVER IS ON THE WINDOW 2
        Thread.sleep(3000);
        Assertions.assertTrue(driver.getTitle().equals("New Window"));
        String window2Handle = driver.getWindowHandle();
//        Switch back to window 1 title and assert if URL contains “windows”
//        driver.switchTo().window(window1Handle);
        switchNewWindowByIndex(0);//switching window 1(index = 0) using REUSABLE METHOD FROM TestBase
//        switchNewWindowByTitle("The Internet");
        Assertions.assertTrue(driver.getCurrentUrl().contains("windows"));
//        And assert if the URL doesn’t contains ‘new’
        Assertions.assertFalse(driver.getCurrentUrl().contains("new"));
//        Switch back to window 2
//        driver.switchTo().window(window2Handle);
        switchNewWindowByIndex(1);//switching window 2(index = 1) using REUSABLE METHOD FROM TestBase
        Thread.sleep(3000);
//        switch back to window 1
//        driver.switchTo().window(window1Handle);
        switchNewWindowByIndex(0);//switching window 1(index = 0)  using REUSABLE METHOD FROM TestBase
        Thread.sleep(3000);
//        Switch back to window 2
//        driver.switchTo().window(window2Handle);
        switchNewWindowByIndex(1);//switching window 2(index = 1)  using REUSABLE METHOD FROM TestBase
        Thread.sleep(3000);
    }

}
