package com.um191.parser;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

public class RateParser {
    public int[] getData(String lineData) {
        int[] result = new int[0];
        String[] parts = lineData.split("\\s+");
        if (parts.length > 5) {
            // Создаем новый массив с размером, равным оставшемуся количеству элементов после удаления первых 5
            String[] remainingParts = new String[parts.length - 5];

            // Копируем элементы из исходного массива в новый, начиная с индекса 5
            System.arraycopy(parts, 5, remainingParts, 0, parts.length - 5);

            result = Arrays.stream(remainingParts)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return result;
    }
}
