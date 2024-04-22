package com.um191.parser;

public class SatellitesParser extends Parser {

    private String lineData;

    public void setLineData(String lineData) {
        this.lineData = lineData;
    }

    public SatellitesParser() {}

    @Override
    public Integer getData() {
        Integer result;

        // Разделяем строку на подстроки по пробелам
        String[] parts = lineData.split("\\s+");

        // Получаем первый элемент массива (первое число)
        String firstNumberString = parts[0];

        // Преобразуем его в int
        result = Integer.parseInt(firstNumberString);

        return result;
    }
}
