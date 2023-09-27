package com.myfirstproject.utilitles;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public abstract class TestBase {
    /*
    - TestBase class is used for calling repetitive pre-conditions and post-conditions
    - Make the driver protected because it should be visible in the other classes

    TestBase will be extended to other classes and before and after methods will be executed automatically
     */
    protected static WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
    @AfterEach
    public void tearDown() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // if needed
        Thread.sleep(2000);
        driver.quit();
    }
}
