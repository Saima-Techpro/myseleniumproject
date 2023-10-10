package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
        uploadFile(path);  // Reusable Method from TestBase
    }
}
