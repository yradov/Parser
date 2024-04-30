package parser;

import org.junit.Test;
import static org.junit.Assert.*;
import com.um191.parser.ParserManager;

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

        assertEquals(1, pm.getRawLinesData().size());
    }
    @Test
    public void testCheckAddUniqueLines(){
        ArrayList <String> rawData = new ArrayList<>(Arrays.asList(draftLine, differentLine));
        ParserManager pm = new ParserManager(rawData);
        pm.parsData();

        assertEquals(2, pm.getRawLinesData().size());

    }
}
