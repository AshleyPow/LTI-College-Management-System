package com.ashleypow;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import javax.security.sasl.SaslServer;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filePath = "/home/ashleypow/Documents/LTI/Projects/Java Projects/College Management System/src/com/ashleypow/colleges.csv";

        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        boolean exit = false;

        do {
            // Check what operation the user wants to perform
            System.out.println("What Operation would you like to perform?\n1) Add a new College\n2) Display College " +
                    "with Engineering Course\n3) Display all Colleges\n4) Delete a College Record\n5) Exit");

            int operationNum = sc.nextInt();
            System.out.println();

            switch (operationNum) {
                case 1:
                    RegisterCollege college = new RegisterCollege();
                    college.registerCollege(filePath);
                    break;
                case 2:
                    DisplayEnggCollege enggCollege = new DisplayEnggCollege();
                    enggCollege.displayCollege(filePath);
                    break;
                case 3:
                    DisplayAllColleges allColleges = new DisplayAllColleges();
                    allColleges.displayAllColleges(filePath);
                    break;
                case 4:
                    DeleteCollege deleteCollege = new DeleteCollege();
                    deleteCollege.deleteCollege(filePath);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input. Try again!");
            }
        } while (!exit);

    }
}
