package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day05_IFrames extends TestBase {
    //    Given Go to https://testpages.herokuapp.com/styled/frames/frames-test.html
//    Then Assert that "Left List Item 29" is the last element in the "Left"
//    And Assert that "Middle List Item 39" is the last element in the "Middle"
    @Test
    public void iframes(){
        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
        //    Then Assert that "Left List Item 29" is the last element in the "Left"
        //"Left List Item 29" IS INSIDE THE IFRAME SO SWITCH TO THAT FRAME FIRST
        /*
        NOTE 1 : there are 3 ways to switch to a frame: index, id/name, webElement
                 index is not safe option to use because if developer adds any frame on webpage later on, it will change the existing indexes
        1. driver.switchTo().frame(1);
        2. driver.switchTo().frame("left");
        3. driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='left']")));

        NOTE 2 : when you want to switch to non-child such as sibling frames, we should go to parent then the child.
        we can not jump directly to siblings
        //li[last()] shows 3 elements on the page when we are inspecting, but assertion doesn't see the other 2 webElements
        // because driver is inside the first frame. It can't see the elements in the other frames

         */
        driver.switchTo().frame("left");
//        NOW WE ARE INSIDE THIS IFRAME
//        //li[@id='left29'] => is hard coded xpath. what if the last element changes/added a new one? 'left29' will not work in that case
//        so either we create a loop or use last() function  .. there's no first() ... but we have last()-2 or last()-5 etc.
//                //li[last()]  => XPATH RETURNS THE LAST list ELEMENT
        String lastElement = driver.findElement(By.xpath("//li[last()]")).getText();
        System.out.println("Last Element : "+lastElement);
        Assertions.assertTrue(lastElement.equals("Left List Item 29"));


//    And Assert that "Middle List Item 39" is the last element in the "Middle"
//        to Go to sibling frames, switch to the parent first, then switch to the child
//        driver.switchTo().parentFrame(); OR
        driver.switchTo().defaultContent();//switching to the main html page
        driver.switchTo().frame("middle");//switching to the middle frame
        String middleFrameLastItem = driver.findElement(By.xpath("//li[last()]")).getText();//driver is in the middle frame and getting the middle frame elements
        System.out.println("Miiddle Frame LastItem = " + middleFrameLastItem);
        Assertions.assertTrue(middleFrameLastItem.equals("Middle List Item 39"));

    }
}
