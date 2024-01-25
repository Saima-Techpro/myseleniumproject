package com.myfirstproject.practices.practice05;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q01_FillFormUploadFile extends TestBase {
    /*
    Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    Fill the username, password and textArea comment:
    Choose a file and upload it
    Select all checkboxes, first radio item and first dropdown
    Click on submit
    Verify that uploaded file name is on the Form Details.
*/

    @Test
    public void test() {
//        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

//        Fill the username, password and textArea comment:
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement textAreaInput = driver.findElement(By.xpath("//textarea[@name='comments']"));

        usernameInput.sendKeys("john_doe");
        passwordInput.sendKeys("John.123");
        textAreaInput.clear();//This will clear the default text
        textAreaInput.sendKeys("Hello World");

//        Choose a file and upload it
        //Click on choose file button
        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@type='file']"));
        String pathOfTheFile = System.getProperty("user.home") + "/Desktop/flower.jpeg";
        //If robot class does not work, use: chooseFileButton.sendKeys(pathOfTheFile);
        clickByJS(chooseFileButton);
        uploadFile(pathOfTheFile);
        waitFor(2);

//        Select all checkboxes, first radio item and first dropdown
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='cb1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@value='cb2']"));
        WebElement checkbox3 = driver.findElement(By.xpath("//input[@value='cb3']"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        if (!checkbox3.isSelected()) {
            checkbox3.click();
        }

        //click on first radio button
        driver.findElement(By.xpath("//input[@value='rd1']")).click();

        //select first dropdown
        WebElement dropDown = driver.findElement(By.name("dropdown"));
        new Select(dropDown).selectByIndex(0);

//        Click on submit
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//        Verify that uploaded file name is on the Form Details.
        String fileName = driver.findElement(By.id("_valuefilename")).getText();
        waitFor(2);
        assertEquals("image.png", fileName);

    }
}
