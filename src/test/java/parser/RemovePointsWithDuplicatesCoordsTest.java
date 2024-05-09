package parser;

//import org.junit.Test;
//import static org.junit.Assert.*;
import com.um191.parser.ParserManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class RemovePointsWithDuplicatesCoordsTest {
    private final String draftLine = "12   11.1111 11.1111 05/28/2023   11:10:47:00   5  5  5  5  5  5  5";
    private final String differentLine = "12   22.2222 22.2222 05/28/2023   11:10:47:00   5  5  5  5  5  5  5";
    @Test
    public void testCheckRemoveDuplicates(){
        ArrayList <String> rawData = new ArrayList<>(Arrays.asList(draftLine, draftLine));
        ParserManager pm = new ParserManager(rawData);
        pm.parsData();

        Assert.assertEquals(pm.getRawLinesData().size(), 1);
    }
    @Test
    public void testCheckAddUniqueLines(){
        ArrayList <String> rawData = new ArrayList<>(Arrays.asList(draftLine, differentLine));
        ParserManager pm = new ParserManager(rawData);
        pm.parsData();

        Assert.assertEquals(pm.getRawLinesData().size(), 2);
    }
    
    @DataProvider(name = "testData")
    public Object[][] provideData() {
        return new Object[][] {
                {draftLine, draftLine, 1, ""},
                {draftLine, differentLine, 2, ""},
               // {draftLine, differentLine, 1, "expected Error!!!"}
        };
    }

    @Test(dataProvider = "testData")
    public void testUsingDataProvider(String line1, String line2, int expectedResult, String errorMessage){
        ArrayList <String> rawData = new ArrayList<>(Arrays.asList(line1, line2));
        ParserManager pm = new ParserManager(rawData);
        pm.parsData();

        Assert.assertEquals(pm.getRawLinesData().size(), expectedResult, errorMessage);

    }
}
