package com.myfirstproject.homework;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HW07_DatePicker extends TestBase {

    @Test
    public void dateSelect1(){
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).sendKeys("09/10/2023");

    }

    @Test
    public void dateSelect2(){
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//a[@data-date='10']")).click();

    }
}
