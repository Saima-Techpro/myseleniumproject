package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileExists extends TestBase {

    @Test
    public void fileExistTest() {
//        Class: FileExistTest
//        Method: isExist
//        Pick a file on your desktop
        String pathOfFlower = System.getProperty("user.home") + "/Desktop/flower.jpeg";
        System.out.println(pathOfFlower);
//        And verify if that file exist on your computer or not
        boolean isFlowerExist = Files.exists(Paths.get(pathOfFlower));//checking is the path exist
        Assertions.assertTrue(isFlowerExist);
    }
}