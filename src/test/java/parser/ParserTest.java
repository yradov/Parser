package parser;

import com.um191.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest {
    @Test
    public void testParsDataSatellites (){
        int result = Parser.parsDataSatellites("Hi");
        int expected = 12;
        Assert.assertEquals(expected, result);
    }
}
