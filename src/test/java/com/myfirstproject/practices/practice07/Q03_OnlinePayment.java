package com.myfirstproject.practices.practice07;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Q03_OnlinePayment extends TestBase {

//Go to http://zero.webappsecurity.com
//Click the Sign in button
//Write “username” in the login field
//Write "password" in the password field
//Click the Sign in button
//Go to the Pay Bills page under Online Banking
//Write any amount you want to deposit in the amount section
//write “2020-09-10” in the date field
//Click the Share button
//Check if the message “The payment was successfully submitted.”  appears
//close the page



    @Test
    void test01() {

        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //Click the Sign in button
        driver.findElement(By.cssSelector("#signin_button")).click();

        //Write “username” in the login field
        //Write "password" in the password field
        WebElement login = driver.findElement(By.cssSelector("#user_login"));
        login.sendKeys("username", Keys.TAB,
                "password" );

        //Click the Sign in button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        waitFor(2);

        driver.navigate().back();//To bypass the warning that comes in the page

        //Go to the Pay Bills page under Online Banking
        driver.findElement(By.id("onlineBankingMenu")).click();
        waitFor(2);
        driver.findElement(By.id("pay_bills_link")).click();

        //Write any amount you want to deposit in the amount section
        //write “2020-09-10” in the date field
        WebElement amount = driver.findElement(By.id("sp_amount"));
        amount.sendKeys("3000",Keys.TAB,"2020-09-10");

        //Click the Share button
        driver.findElement(By.id("pay_saved_payees")).submit();

        //Check if the message “The payment was successfully submitted.”  appears
        WebElement resultMessage = driver.findElement(By.xpath("//*[.='The payment was successfully submitted.']"));
        Assertions.assertEquals("The payment was successfully submitted.",resultMessage.getText());


    }
}
