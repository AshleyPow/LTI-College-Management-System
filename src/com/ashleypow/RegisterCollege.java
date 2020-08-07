package com.ashleypow;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class RegisterCollege {

    public void registerCollege(String filePath) {

        // create College Class instance
        College college = new College();

        // Get all College Data
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream

        System.out.println("Enter College ID: ");
        college.collegeID = sc.nextLine(); // reads College ID
        System.out.println("Enter College Name: ");
        college.collegeName = sc.nextLine(); // reads College Name
        System.out.println("Enter Course Type: ");
        college.courseName = sc.nextLine(); // reads Course Type
        System.out.println("Enter College City: ");
        college.city = sc.nextLine(); // reads College City
        System.out.println("Enter College Fees: ");
        college.fees = sc.nextLine(); // reads College Fees
        System.out.println("Enter College Pincode: ");
        college.pincode = sc.nextLine(); // reads College Pincode

        // Write to CSV File
        File file = new File(filePath);

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(fileWriter,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);

            String[] collegeData = {college.collegeID, college.collegeName, college.courseName, college.city,
                    college.fees, college.pincode};
            writer.writeNext(collegeData);

            System.out.println("College Added Successfully.");

            writer.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
