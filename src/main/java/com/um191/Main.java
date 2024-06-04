package com.um191;

import com.um191.file_manager.FileManager;
import com.um191.models.PointData;
import com.um191.parser.ParserManager;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        /**
         * 1) Open file with data
         * 2) Getting data from file(parse)
         * 3) Create .CSV file
         */
         //detector_data.TXT
        String filePath = FileManager.getFilePath();
        ArrayList<String> rawStringData = FileManager.readData(filePath);
        ParserManager parser = new ParserManager(rawStringData);
        ArrayList<PointData> points = parser.parsData();
        //System.out.println(points);

        FileManager.writeDataToCsv(points);

    }//main

    /**
     * for test sample
     */
    public static String getGreetings(String name) {
        return "Hello and welcome " + name + "!";
    }
}