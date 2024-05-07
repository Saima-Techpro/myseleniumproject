package com.myfirstproject.practices.practice05;

import com.github.javafaker.Faker;
import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Q05_ActionsClass_FacebookLogin extends TestBase {
     /*
    Given
        Go to https://www.facebook.com/
    When
        Click on "Create New Account"
    And
        Fill all the boxes by using keyboard actions class

    Note: Do not use any locator.
     */

    @Test
    public void test() {
//        Go to https://www.facebook.com/
        driver.get("https://facebook.com/");

//        Click on "Create New Account"
//        Fill all the boxes by using keyboard actions class
        Actions actions = new Actions(driver);

        actions
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .pause(2000)
                .sendKeys("John")
                .sendKeys(Keys.TAB)
                .sendKeys("Doe")
                .sendKeys(Keys.TAB)
                .sendKeys("john_doe@gmail.com")
                .sendKeys(Keys.TAB)
                .pause(2000)
                .sendKeys("john_doe@gmail.com")
                .sendKeys(Keys.TAB)
                .pause(2000)
                .sendKeys("John.123")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("25")
                .sendKeys(Keys.TAB)
                .sendKeys("Jul")
                .sendKeys(Keys.TAB)
                .sendKeys("1999")
                .pause(2000)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .pause(2000)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .pause(2000)
                .sendKeys(Keys.ENTER)
                .perform();

    }
    @Test
    public void facebookLoginTest() throws InterruptedException {
        //    Go to https://www.facebook.com/
        driver.get("https://www.facebook.com/");
        waitFor(1);

        //    When
//    Click on "Create New Account"
        Actions actions= new Actions(driver);
        for (int i = 1; i < 5; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }

        Faker faker= new Faker();

        actions.sendKeys(Keys.ENTER).perform();
        waitFor(2);
        actions.sendKeys(faker.name().firstName()).perform();
        waitFor(1);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.name().lastName()).perform();
        waitFor(1);
        actions.sendKeys(Keys.TAB);

        String email = faker.internet().emailAddress();
        actions.sendKeys(email).perform();
        waitFor(1);
        actions.sendKeys(Keys.TAB);

        actions.sendKeys(email).perform();
        waitFor(1);
        actions.sendKeys(Keys.TAB);

        actions.sendKeys(faker.internet().password()).perform();
        waitFor(1);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        waitFor(2);

        actions.sendKeys("8").sendKeys(Keys.TAB).sendKeys("Oct").sendKeys(Keys.TAB).sendKeys("2000").perform();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).perform();

        for (int i = 1; i <6 ; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }
        waitFor(2);
        captureScreenshotEntirePage();
        actions.sendKeys(Keys.ENTER).perform();
        waitFor(2);


    }

}
