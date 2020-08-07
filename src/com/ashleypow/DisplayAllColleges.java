package com.ashleypow;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

public class DisplayAllColleges {

    public void displayAllColleges(String filePath) {
        try {
            FileReader filereader = new FileReader(filePath);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader).build();
            List<String[]> allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + ", ");
                }
                System.out.println();
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
