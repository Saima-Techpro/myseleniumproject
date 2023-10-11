package com.myfirstproject;

import com.myfirstproject.utilitles.LoggerUtils;
import org.junit.jupiter.api.Test;

public class Day12_Log4j2 {

    @Test
    public void log4j2Test(){
        System.out.println("This is how I print info on the console");

        LoggerUtils.info("This is how SDET or Developer print the info on the console or in a file... ");
    }
}
