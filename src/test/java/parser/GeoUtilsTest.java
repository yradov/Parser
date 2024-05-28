package parser;

import com.um191.models.PointData;
import com.um191.utils.GeoUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GeoUtilsTest {

    @Test
    public void testPointsCount() {
        int[] internalRates = {1, 1, 1};
        ArrayList<PointData> points = GeoUtils.createIntermediatePoints(1, 1, 2, 2, internalRates);
        assertEquals(internalRates.length, points.size());
    }

    @Test
    public void testPointsDataRates() {
        int[] internalRates = {1, 2, 3};
        ArrayList<PointData> points = GeoUtils.createIntermediatePoints(1, 1, 2, 2, internalRates);
        assertEquals(1, points.get(0).getRate());
        assertEquals(2, points.get(1).getRate());
        assertEquals(3, points.get(2).getRate());
    }
    @Test
    public void testPointsDataCoords() {
        int[] internalRates = {1, 2, 3};
        ArrayList<PointData> points = GeoUtils.createIntermediatePoints(1, 1, 5, 5, internalRates);
        assertEquals(2.0, points.get(0).getLatitude(), 0);
        assertEquals(3.0, points.get(1).getLatitude(), 0);
        assertEquals(4.0, points.get(2).getLatitude(), 0);

        assertEquals(2.0, points.get(0).getLongitude(), 0);
        assertEquals(3.0, points.get(1).getLongitude(), 0);
        assertEquals(4.0, points.get(2).getLongitude(), 0);
    }
}