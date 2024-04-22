package com.um191;

import com.um191.file_manager.FileManager;
import com.um191.models.PointData;
import com.um191.parser.Parser;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        /**
         * 1) Open file with data
         * 2) Getting data from file(parse)
         * 3) Create .CSV file
         */

        ArrayList<String> rawStringData = FileManager.readData("detector_data.TXT");

        ArrayList<PointData> points = Parser.parsData(rawStringData);

        // write points to csv file;

    }//main

    /**
     * for test sample
     */
    public static String getGreetings(String name) {
        return "Hello and welcome " + name + "!";
    }
}