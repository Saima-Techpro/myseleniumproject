package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class Day05_Windows extends TestBase {
    @Test
    public void windowsTest() throws InterruptedException {
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
        String window1Handle = driver.getWindowHandle();
        System.out.println("Window 1: "+window1Handle);
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("All Windows: "+allWindowHandles);

        for (String eachHandle : allWindowHandles){
            if (!eachHandle.equals(window1Handle)){
                driver.switchTo().window(eachHandle);
                break;
            }
        }
//        NOW DRIVER IS ON THE WINDOW 2
        Thread.sleep(3000);
        Assertions.assertTrue(driver.getTitle().equals("New Window"));
        String window2Handle = driver.getWindowHandle();
//        Switch back to window 1 title and assert if URL contains “windows”
        driver.switchTo().window(window1Handle);
        Assertions.assertTrue(driver.getCurrentUrl().contains("windows"));
//        And assert if the URL doesn’t contain ‘new’
        Assertions.assertFalse(driver.getCurrentUrl().contains("new"));

//        Switch back to window 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(3000);
//        switch back to window 1
        driver.switchTo().window(window1Handle);
        Thread.sleep(3000);
        //        Switch back to window 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(3000);

    }
}
