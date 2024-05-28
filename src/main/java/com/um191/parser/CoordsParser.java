package com.um191.parser;

public class CoordsParser {
    private String lineData;

    public void setLineData(String lineData) {
        this.lineData = lineData;
    }

    public double getLat() {
        // Разбиваем строку на подстроки по пробелам
        String[] parts = lineData.split("\\s+");

        int latitudeIndex = 1;

        double latitude = Double.parseDouble(parts[latitudeIndex]);

        //System.out.println("Широта: " + latitude);

        return latitude;
    }
    public double getLng() {
        // Разбиваем строку на подстроки по пробелам
        String[] parts = lineData.split("\\s+");

        int longitudeIndex = 2;

        double longitude = Double.parseDouble(parts[longitudeIndex]);

        //System.out.println("Долгота: " + longitude);

        return longitude;
    }
}// CoordsParser
