package com.myfirstproject;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PaintWithRobot {
    @Test
    public void paintDrawing() throws AWTException, InterruptedException {

        Robot robot = new Robot();
        //Pressin windows button and release
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        Thread.sleep(2000);

        //Send PAINT for searching
        robot.keyPress(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_T);
        Thread.sleep(3000);

        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);

        //Drawing on paint
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(500,500);//Starting for moving
        Thread.sleep(3000);
        robot.mouseMove(500,300);//moving down by 200
        Thread.sleep(3000);
        robot.mouseMove(300,300);//moving left by 200
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);



    }
}
