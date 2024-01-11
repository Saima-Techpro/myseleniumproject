package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Q03_ClickWithJavaScriptExecutor extends TestBase {
    /*
    Go to https://testcenter.techproeducation.com/
    Click on 'Back to top' at the bottom
  */
    @Test
    public void test(){

//        Go to https://testcenter.techproeducation.com/
        driver.get("https://testcenter.techproeducation.com/");

//        Click on 'Back to top' at the bottom
        WebElement backToTopButton = driver.findElement(By.linkText("Back to top"));
        backToTopButton.click();

        try {
            backToTopButton.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Selenium click did not work. We use JS Executor
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click()",backToTopButton);

    }
}
