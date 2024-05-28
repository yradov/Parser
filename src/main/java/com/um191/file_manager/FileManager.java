package com.um191.file_manager;

import com.um191.models.RawLineData;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class FileManager {

    private static ArrayList<String> rawStringData = new ArrayList<>();

    public static ArrayList<String> readData(String filePath) {
        readSourceFile(filePath);
        return rawStringData;
    }

    private static void readSourceFile(String filePath) {
        try {
            //String filePath = "detector_data.TXT";
            InputStream inputStream =ClassLoader.getSystemResourceAsStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                rawStringData.add(line);
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//readCSV

}//FileManager

