package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q01_AddRemoveButtons extends TestBase {
     /*
    Given
        Go to http://the-internet.herokuapp.com/add_remove_elements/
    When
        Click on the "Add Element" button 100 times
    And
        Click on the "Delete" button 20 times
    Then
        Assert that 20 buttons were deleted.
      */

    @Test
    public void test() {
//        Go to http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

//        Click on the "Add Element" button 100 times
        WebElement addButton = driver.findElement(By.xpath("//button[.='Add Element']"));

        for (int i = 0; i < 100; i++) {
            addButton.click();
        }

//        Click on the "Delete" button 20 times
        List<WebElement> deleteButtonsBeforeDelete = driver.findElements(By.xpath("//button[.='Delete']"));//[Delete, Delete, ... ]
        System.out.println("NumOfDeleteButtonsBeforeDelete = " + deleteButtonsBeforeDelete.size());//100
        for (int i = 0; i < 20; i++) {
            deleteButtonsBeforeDelete.get(i).click();
        }

//        Assert that 20 buttons were deleted.
//        List<WebElement> deleteButtonsAfterDelete = driver.findElements(By.xpath("//button[.='Delete']"));//[Delete, Delete, ... ]
        List<WebElement> deleteButtonsAfterDelete = driver.findElements(By.className("added-manually"));//[Delete, Delete, ... ]
        System.out.println("NumOfDeleteButtonsAfterDelete = " + deleteButtonsAfterDelete.size());//80
        assertEquals(deleteButtonsBeforeDelete.size() - 20, deleteButtonsAfterDelete.size());
    }
}
