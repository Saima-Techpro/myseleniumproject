package com.myfirstproject.practices.practice06;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q02_WebTable_RoofHeight extends TestBase {
    //We will make a roof of 5% of the height of the earliest built tower.
    //Find how many meters we will build.
     /*
    Given
        Go to https://www.techlistic.com/p/demo-selenium-practice.html
    When
        Put all built years into a list
    And
        Calculate min year
    And
        Put all heights into a list
    And
        Calculate the height to build
    Then
        Assert that build height is 25.45 meters
     */

    @Test
    public void test() {

//        Go to https://www.techlistic.com/p/demo-selenium-practice.html
        driver.get("https://techlistic.com/p/demo-selenium-practice.html");
        waitFor(3);

//        Put all built years into a list
        List<WebElement> years = driver.findElements(By.xpath("(//tbody)[2]/tr/td[4]"));
        years.forEach(t -> System.out.print(t.getText()+" "));

//        Calculate min year
        int minYear = Integer.MAX_VALUE;
        for (WebElement w : years) {
            if (Integer.parseInt(w.getText()) < minYear) {
                minYear = Integer.parseInt(w.getText());
            }
        }
        System.out.println("minYear = " + minYear);

        //Calculate the index of min year
        int minYearIdx = 0;
        for (int i=0; i<years.size(); i++){

            if(Integer.parseInt(years.get(i).getText()) == minYear){
                minYearIdx = i;
            }

        }

        System.out.println("minYearIdx = " + minYearIdx);


//        Put all heights into a list
        List<WebElement> heights = driver.findElements(By.xpath("(//tbody)[2]/tr/td[3]"));
        //Get the height into the minimum year index
        int buildingHeight = Integer.parseInt(heights.get(minYearIdx).getText().replaceAll("[^0-9]",""));
        System.out.println("buildingHeight = " + buildingHeight);//509

//        Calculate the height to build
        double result = (buildingHeight*0.05);
        System.out.println("result = " + result);
        String resultFormatted = new DecimalFormat("0.00").format(result);

//        Assert that build height is 25.45 meters
        assertEquals("25.45", resultFormatted);


    }
}
