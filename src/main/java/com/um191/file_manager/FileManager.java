package com.um191.file_manager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class FileManager {

    public static void readData(String filePath) {
//      String filePath ="detector_data.TXT";
        readSourceFile(filePath);

    }

    private static void readSourceFile(String filePath) {
        try {
            //String filePath = "detector_data.TXT";
            InputStream inputStream =ClassLoader.getSystemResourceAsStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//readCSV

}//FileManager

