package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day06_Authentication extends TestBase {

    @Test
    public void authTest(){
//        username : admin
//        password : admin
//        url      :  the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");//this authenticates the login
        Assertions.assertTrue(driver.findElement(By.xpath("//p")).getText().contains("Congratulations!"));

        // Click on Elemental Selenium
        driver.findElement(By.xpath("(//a)[2]")).click();
        // Get Window handles
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String windowTitle = driver.getTitle();
        System.out.println("window Title = " + windowTitle);

        Assertions.assertNotEquals("Elemental Selenium", windowTitle);

        //Select 'JAVA' from language dropdown and verify it
        WebElement languageDropdown = driver.findElement(By.xpath("//select"));
        dropdownSelectByVisibleText(languageDropdown, "Java");  // REUSABLE METHOD
    }
}
