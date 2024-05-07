package com.myfirstproject.practices.practice05;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q03_DownloadFile extends TestBase {
    /*
    Go to https://testpages.herokuapp.com/
    Click on File Downloads
    Click on Server Download
    Verify that file is downloaded
*/

    @Test
    public void test() {

//        Go to https://testpages.herokuapp.com/
        driver.get("https://testpages.herokuapp.com/");

//        Click on File Downloads
        driver.findElement(By.id("download")).click();

//        Click on Server Download
        driver.findElement(By.id("server-download")).click();

//        Verify that file is downloaded
        String pathOfTheFile = System.getProperty("user.home")+"/Downloads/textfile.txt";
        waitFor(5); //Saving file to the disk might take a little time. This wait is for saving issue.
        boolean isExists = Files.exists(Path.of(pathOfTheFile));
        assertTrue(isExists);
    }

}
