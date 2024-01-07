package com.myfirstproject.homework;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HW09_AutoComplete extends TestBase {
    //    When user goes to https://jqueryui.com/autocomplete/
    //    And type Apple
    //    Then select Applescript
    //    And check if Applescript is selected(you can get value by js to get text of the input)
    @Test
    public void autoCompleteTest(){
        //    When user goes to https://jqueryui.com/autocomplete/
        driver.get("https://jqueryui.com/autocomplete/");
        //    And type Apple
        driver.switchTo().frame(0);
        driver.findElement(By.id("tags")).sendKeys("Apple");
        //    Then select Applescript
        driver.findElement(By.xpath("//ul[@id='ui-id-1']//div[.='AppleScript']")).click();
        //    And check if Applescript is selected(you can get value by js to get text of the input)
        String inputValue = getValueByJS("tags");
        Assertions.assertEquals("AppleScript",inputValue);

    }
}
