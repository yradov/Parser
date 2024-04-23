package parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.um191.parser.CoordsParser;

public class CoordsParserTest {
    private final double lat = 46.44529342;
    private final double lng = 30.73874473;
    private final String testData = "12   " + lat + "  " + lng + "   05/28/2023   11:10:47:00   5  5  5  5  5  5  5";

    @Test
    public void testGetLat() {
        // Создаем экземпляр класса CoordsParser
        CoordsParser parser = new CoordsParser();

        // Устанавливаем тестовую строку с широтой
        parser.setLineData(testData);

        // Вызываем метод getLat() и проверяем результат
        double latitude = parser.getLat();

        // Ожидаем, что широта равна 46.44529342
        assertEquals(lat, latitude, 0); // Указываем допустимую погрешность
    }

    @Test
    public void testGetLng() {
        // Создаем экземпляр класса CoordsParser
        CoordsParser parser = new CoordsParser();

        // Устанавливаем тестовую строку с долготой
        parser.setLineData(testData);

        // Вызываем метод getLng() и проверяем результат
        double longitude = parser.getLng();

        // Ожидаем, что долгота равна 30.73874473
        assertEquals(lng, longitude, 0); // Указываем допустимую погрешность
    }
}
