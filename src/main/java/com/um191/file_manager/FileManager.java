package com.um191.file_manager;

import com.um191.models.PointData;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileManager {

    private static ArrayList<String> rawStringData = new ArrayList<>();

    public static ArrayList<String> readData(String filePath) {
        readSourceFile(filePath);
        return rawStringData;
    }

    private static void readSourceFile(String filePath) {
        try {
            //String filePath = "detector_data.TXT";
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
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
    }

    public static void writeDataToCsv(ArrayList<PointData> points) {
        String fileName = "points.csv";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Latitude,Longitude,Rate\n"); // Заголовок CSV файла
            for (PointData point : points) {
                writer.append(String.valueOf(point.getLatitude())).append(",")
                        .append(String.valueOf(point.getLongitude())).append(",")
                        .append(String.valueOf(point.getRate())).append("\n");
            }
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String filePath = scanner.nextLine();

        scanner.close();
        return filePath;
    }
}//FileManager

