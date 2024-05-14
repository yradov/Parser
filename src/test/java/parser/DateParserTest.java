package parser;

import com.um191.parser.DateParser;
import com.um191.parser.ParserManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class DateParserTest {

    String testDate = "05/28/2023";
    String wrongDate = "05-28-2023";
    String testTime = "11:10:47:00";

    private final String draftLine = String.format("12   11.1111 11.1111 %s %s   5  5  5  5  5  5  5", testDate, testTime);
    private final String wrongLine = String.format("12   11.1111 11.1111 %s %s   5  5  5  5  5  5  5", wrongDate, testTime);
    @Test
    public void testDateParser() throws ParseException {
        DateParser dateParser = new DateParser();
        Date result = dateParser.getData(draftLine);

        String date = (new SimpleDateFormat("MM/dd/yyyy")).format(result);
        Assert.assertEquals(date, testDate);

        String time = (new SimpleDateFormat("HH:mm:ss:SS")).format(result);
        Assert.assertEquals(time, testTime);
    }

    @Test(expectedExceptions = ParseException.class)
    public void testGetWrongData() throws ParseException{
        DateParser dateParser = new DateParser();
        Date result = dateParser.getData(wrongLine);

    }
}
