package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day07_ReadExcel {
    @Test
    public void readExcelTest(){

//        Store the path of the  file in a string
        String path = "resources/Capitals.xlsx";

//        Open the file
//            workbook > worksheet > row > cell
        try {
//        Open the workbook using fileinputstream
            FileInputStream fileInputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fileInputStream);  // to open the excel sheet

//        Open the first worksheet
            Sheet sheet1 = workbook.getSheetAt(0);//get first sheet by index. index starts at 0
//            workbook.getSheet("Sheet1"); // OR  get first sheet by name
//        Go to first row
            Row row1 = sheet1.getRow(0);//index stars at 0
            System.out.println("sheet1.getLastRowNum() = " + sheet1.getLastRowNum());
//        Go to first cell on that first row and print
            Cell r1c1 = row1.getCell(0);//index starts at 0
            System.out.println("First Row, first cell: "+r1c1);
//        Go to second cell on that first row and print
//            Cell r1c2 = row1.getCell(1);
            String r1c2 = row1.getCell(1).toString();
            System.out.println("First Row, second cell: "+r1c2);
            Assertions.assertEquals("CAPITAL", r1c2);
//        Go to 2nd row first cell  and assert if the data equal to USA
            String r2c1 = sheet1.getRow(1).getCell(0).toString();
            System.out.println("Second Row, first cell: "+r2c1);
//        Go to 3rd row 2nd cell-chain the row and cell
            String r3c2 = sheet1.getRow(2).getCell(1).toString();
            System.out.println("Third Row, second cell: "+r3c2);
//        Find the number of row
            int totalRowNum = sheet1.getLastRowNum()+1;//coz index starts at 0
            System.out.println("totalRowNum = " + totalRowNum);
//        Find the number of used row
            int totalUsedRowNum = sheet1.getPhysicalNumberOfRows();//index starts at 1
            System.out.println("totalUsedRowNum = " + totalUsedRowNum);

            System.out.println("=========country-capital format=========");
//        Print data in country-capital format
            for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
                for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getLastCellNum(); j++) {
                    System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");  // +"\t" => to create gap between the columns
                }
                System.out.println();
            }

            System.out.println("===========HOMEWORK===========");
//            HOMEWORK : Print country, capital key value pairs as map object()

            Map<String , String > countryCapitalMap = new HashMap<>();  // Create an empty map

           int rowCount = sheet1.getPhysicalNumberOfRows();

            for (int i = 1; i <rowCount ; i++) {
                Row row = sheet1.getRow(i);

            String countries = row.getCell(0).toString();  //OR
//            String countries = row.getCell(0).getStringCellValue().trim();
//            System.out.println("countries = " + countries);
            String capitals = row.getCell(1).toString();   //OR
//            String capitals = row.getCell(1).getStringCellValue().trim();
//            System.out.println("capitals = " + capitals);

                countryCapitalMap.put(countries,capitals);
            }
            System.out.println("===========Country- Capital Map===========");
            System.out.println(countryCapitalMap);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
     /*
       HOMEWORK : Print country, capital key value pairs as map object()
        create a map
        then use a loop to add key-value pairs in the map
        use the pattern of indexes
        String countries = sheet1.getRow(row number).getCell(0).toString
        String capitals = sheet1.getRow(row number).getCell(1).toString
        add this to the map
        then print
        {greece = athens, Canada= Ottowa,...}
         */
}
