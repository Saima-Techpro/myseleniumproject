package com.myfirstproject;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClass_ChatGPT {


    @Test
    public void fileUploadExample(){

        try {
            // Create Robot instance
            Robot robot = new Robot();

            // Delay before starting (adjust as needed)
            robot.delay(2000);

            // Press Enter to open the file dialog
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // Delay to allow the file dialog to open
            robot.delay(1000);

            // Type the file path (replace "C:\\path\\to\\your\\file.txt" with your file path)
            String filePath = "/Users/saima/Desktop/sampledoc.docx ";
            typeString(robot, filePath);

            // Press Enter to confirm the file selection
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    // Helper method to type a string using the Robot class
    private static void typeString(Robot robot, String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // Handle uppercase letters separately
            if (b >= 'A' && b <= 'Z') {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(code);
                robot.keyRelease(code);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            } else {
                robot.keyPress(code);
                robot.keyRelease(code);
            }
            // Introduce a delay between key presses to make it more human-like
            robot.delay(50);
        }
    }

}
