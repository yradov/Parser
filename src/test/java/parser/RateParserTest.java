package parser;

import com.um191.parser.RateParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class RateParserTest {
    @DataProvider(name = "testData")
    public Object[][] provideData() {
        return new Object[][] {
                {"s lat lng d t 1 1 1 1 1", new int[]{1, 1, 1, 1, 1}},
                {"s lat lng d t 2 2 2 2 2", new int[]{2, 2, 2, 2, 2}},
                {"s lat lng d t 3 3 3 3 3", new int[]{3, 3, 3, 3, 3}},
        };
    }

    @Test(dataProvider = "testData")
    public void testGetRates(String rawLine, int[] expected){
        RateParser rateParser = new RateParser();
        int[] result = rateParser.getData(rawLine);
        Assert.assertEquals(result, expected);
    }
}
