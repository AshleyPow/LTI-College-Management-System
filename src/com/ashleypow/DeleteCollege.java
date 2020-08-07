package com.ashleypow;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class DeleteCollege {

    public void deleteCollege(String filePath) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter College ID to delete: ");
        String collegeID = sc.nextLine();

        try {
            FileReader filereader = new FileReader(filePath);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader).build();
            List<String[]> allData = csvReader.readAll();

            int rowCount = 0;
            boolean idFound = false;

            for (String[] row : allData) {
                for (String col : row) {
                    //System.out.print(col + ", ");
                    if (col.equals(collegeID)) {
                        idFound = true;
                    }
                }
                if (idFound) {
                    allData.remove(rowCount);
                    writeNewData(allData, filePath);
                    break;
                } else {
                    rowCount += 1;
                }
            }
            if (!idFound) {
                System.out.println("No College ID Found!");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void writeNewData(List<String[]> alLData, String filePath) {

        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(file);

            // create CSVWriter object fileWriter object as parameter
            CSVWriter writer = new CSVWriter(outputFile,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);

            writer.writeAll(alLData);

            // closing writer connection
            writer.close();

            System.out.println("Record Deleted Successfully.\n");

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}
