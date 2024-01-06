package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Day06_DropDown_WithTestBase extends TestBase {
    /*
    -How to select from a dropdown???
    3 ways to select a dropdown option: index, value, visibleText

    -How to get selected option from a dropdown? (For Verification or other uses)
    getFirstSelectedOption method
    */
    @Test
    public void dropdownTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
//        2000 February 15
//        1. locate the dropdown element
        WebElement year = driver.findElement(By.id("year"));
//        2. create a Select Object
        Select selectYear = new Select(year);
//        3. now that we have select object, we can interact with this dropdown element
        selectYear.selectByVisibleText("2000");//selecting by visible text
//        months
        WebElement months = driver.findElement(By.id("month"));
        Select selectMonths = new Select(months);
//        selectMonths.selectByIndex(1);//selecting by index(index starts at 0)

        // Selecting the months using REUSABLE METHODS  (Use ANY one of the following)
        dropdownSelectByIndex(driver.findElement(By.id("month")), 1); // Webelement, index
        dropdownSelectByIndex(months, 1); // Webelement, index

        dropdownSelectByIndex(driver.findElement(By.id("month")), 0); // locator, index
        dropdownSelectByIndex(driver.findElement(By.xpath("//select[@id='month']")), 0); // locator, index
        dropdownSelectByIndex("//select[@id='month']", 0); // String xpath, index

//        day
        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByValue("15");//selecting by value

//      Assert if 2000 is selected
        WebElement selectedYear = selectYear.getFirstSelectedOption();//getting the selected options
        System.out.println("Selected Year: "+selectedYear.getText());//getting the text of the selected year
        Assertions.assertTrue(selectedYear.getText().equals("2000"));//asserting if selected test is as expected

//      get all the months and assert if April is an option in the month dropdown
        List<WebElement> allMonths = selectMonths.getOptions();
        boolean isMonthExist=false;  // declare it false for assertion purpose
        for (WebElement eachMonth : allMonths){
            System.out.println(eachMonth.getText());
            if (eachMonth.getText().equals("April")){
                isMonthExist=true;
            }
        }
        Assertions.assertTrue(isMonthExist);
    }

}