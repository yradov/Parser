package com.um191.parser;

public class SatellitesParser {
    private String lineData;

    public void setLineData(String lineData) {
        this.lineData = lineData;
    }

    public SatellitesParser() {}

    public int getData() {
        int result;

        // Разделяем строку на подстроки по пробелам
        String[] parts = lineData.split("\\s+");

        // Получаем первый элемент массива (первое число)
        String firstNumberString = parts[0];

        // Преобразуем его в int
        result = Integer.parseInt(firstNumberString);

        return result;
    }
}
