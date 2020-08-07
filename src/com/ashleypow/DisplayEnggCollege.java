package com.ashleypow;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class DisplayEnggCollege {

    public void displayCollege(String filePath) {
        try {
            FileReader filereader = new FileReader(filePath);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader).build();
            List<String[]> allData = csvReader.readAll();

            boolean found = false;

            // print Data
            for (String[] row : allData) {
                if (Arrays.asList(row).contains("Engineering")) {
                    found = true;
                    for (String cell : row) {
                        System.out.print(cell + ", ");
                    }
                    System.out.println();
                }
            }
            if (!found) {
                System.out.println("No College Found!");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
