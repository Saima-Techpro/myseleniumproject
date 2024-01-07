package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day07_WebTables extends TestBase {
//    https://the-internet.herokuapp.com/tables
//    Create a class: WebTables
//    Task 1 : Print the entire table
//    Task 2 : Print All Rows
//    Task 3 : Print Last row data only
//    Task 4 : Print column 5 data in the table body

//    HOMEWORK : Task 5 : Write a method that accepts 2 parameters
//    Parameter 1 = row number
//    Parameter 2 = column number
//    printData(2,3);  => prints data in 2nd row 3rd column
    @Test
    public void webTablesTest(){
        driver.get("https://the-internet.herokuapp.com/tables ");

//        Task 1 : Print the entire table
        System.out.println("***Task 1 : Print the entire table***");
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        //String entireTable = driver.findElement(By.xpath("//table//tbody")).getText();
        System.out.println(entireTable);  // This returns the entire table data as one element (You can't use this for assertion of the individual data
        System.out.println("=======================================");
//        ALTERNATIVELY
        int dataNum=1;
        List<WebElement> elementsList = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement eachElement : elementsList){
            System.out.println("Data "+dataNum+" => "+eachElement.getText()); // This returns the entire table data but every data is an individual unit
            dataNum++;
        }
//        Assert if the last element in the table 1 is "edit delete"
        Assertions.assertTrue(elementsList.get(elementsList.size()-1 ).getText().equals("edit delete"));
        Assertions.assertTrue(elementsList.get(1).getText().equals("John"));// to check any other element on the webtable, provide that index
        Assertions.assertTrue(elementsList.get(18).getText().equals("Conway"));// to check any other element on the webtable, provide that index

        System.out.println("================ALTERNATIVELY====================");
        //Assertions.assertTrue(elementsList.indexOf("John").equals("John")); // this doesn't work as indexOf() returns int, but for assertion, both data types should be same
        WebElement givenElement = elementsList.get(1);
        System.out.println("givenElement = " + givenElement.getText());
        Assertions.assertTrue(givenElement.getText().equals("John"));
        System.out.println("=======================================");

        WebElement givenElement2 = elementsList.get(8);
        System.out.println("givenElement2 = " + givenElement2.getText());
        Assertions.assertTrue(givenElement2.getText().equals("fbach@yahoo.com"));
        System.out.println("=======================================");

//        Task 2 : Print All Rows
        System.out.println("***Task 2 : Print All Rows***");
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        int rowNum = 1;
        for (WebElement eachRow : allRows){
            System.out.println("Row "+rowNum+" => "+eachRow.getText());
            rowNum++;
        }
        System.out.println("=======================================");

//        Task 3 : Print Last row data only

        System.out.println("***Task 3 : Print Last row data only***");
        System.out.println("Last row data: "+allRows.get(allRows.size()-1).getText());

//        Print 2nd row data only
        System.out.println("2nd row data: "+allRows.get(1).getText());
        System.out.println("=======================================");

//        Task 4 : Print column 5 data in the table body

        System.out.println("***Task 4 : Print column 5 data in the table body***");
        List<WebElement> col5 = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        int colNum=1;
        for (WebElement each : col5){
            System.out.println("Row "+colNum+" Column 5 data => "+each.getText());
            colNum++;
        }

        System.out.println("=======================================");

//        Task 5 : Write a method that accepts 2 parameters
        //Call printData method to test
        printData(2,3);//fbach@yahoo.com

    }


    //    HOMEWORK : Task 5 : Write a method that accepts 2 parameters
//    Parameter 1 = row number
//    Parameter 2 = column number
//    printData(2,3);  => prints data in 2nd row 3rd column
    public void printData(int rowNum,int colNum){
//        COMPLETE THE CODE
        // //table[@id='table1']//tr["+rowNum+"]//td["+colNumber+"]
        WebElement webElement = driver.findElement(By.xpath("//table[@id='table1']//tr["+rowNum+"]//td["+colNum+"]"));
        System.out.println(webElement.getText());
    }

}
