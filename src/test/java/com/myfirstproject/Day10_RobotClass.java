package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Day10_RobotClass extends TestBase {
    @Test
    public void fileUploadTest(){
//        Given user goes to https://www.grammarly.com/plagiarism-checker
        driver.get("https://www.grammarly.com/plagiarism-checker");
//        Then click upload file
        driver.findElement(By.xpath("//div[@id='sectionGrammarCheck_4VB8kepvT7ciShVSz6rHX']//span[@class='iconWrapper_PbRSndwM']")).click();
//        Then selects a document and upload that file
        String path = System.getProperty("user.home")+"/Desktop/sampledoc.docx";//MAC
//        String path = System.getProperty("user.home")+"\\Desktop\\sampledoc.docx";//WINDOWS
        System.out.println("path of the file = " + path);

        try {


            // Use the clipboard to set the file path
            StringSelection stringSelection = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            // Create Robot instance
            Robot robot = new Robot();

            // Paste the file path using Command + V for Mac
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);

            // Press Enter to confirm the file selection
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // Wait for the file to be uploaded (you may need to adjust this delay)
            Thread.sleep(3000);

// Verify if the file is uploaded successfully
//       file upload is done. then click upload button and do assertion
            System.out.println("File is uploaded!!");
            WebElement textArea = driver.findElement(By.xpath("//*[@id='sectionGrammarCheck_4VB8kepvT7ciShVSz6rHX']//textarea"));
            waitFor(3);

            Assertions.assertTrue(textArea.getText().contains("Hello World!!"));

        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }



        // Reusable Method from TestBase
//        uploadFile(path);


    }
}
