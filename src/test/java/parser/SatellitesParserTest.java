package parser;

import org.junit.Test;
import static org.junit.Assert.*;
import com.um191.parser.SatellitesParser;

public class SatellitesParserTest {
    @Test
    public void testGetData() {
        // Создаем экземпляр класса SatellitesParser
        SatellitesParser parser = new SatellitesParser();

        // Устанавливаем тестовую строку
        Integer satellitesNumber = 12;
        String testData = String.format("%d   46.44529342 30.73874473 05/28/2023   11:10:47:00   5  5  5  5  5  5  5", satellitesNumber);
        parser.setLineData(testData);

        // Вызываем метод getData() и проверяем результат
        Integer result = parser.getData();

        // Ожидаем, что первое число в строке testData равно 12
        assertEquals(satellitesNumber, result);
    }
}
