package com.um191.parser;

import com.um191.models.PointData;
import com.um191.models.RawLineData;

import java.util.ArrayList;
import java.util.Date;

public class ParserManager {
    private final ArrayList<String> rawData;
    private final SatellitesParser satellitesParser;
    private CoordsParser coordsParser;
    private final ArrayList<PointData> points = new ArrayList<>();
    private final ArrayList<RawLineData> rawLinesData = new ArrayList<>();

    public ParserManager(ArrayList<String> rawData) {
        this.rawData = rawData;
        satellitesParser = new SatellitesParser();
        coordsParser = new CoordsParser();
    }


    public ArrayList<PointData> parsData() {

        for (String line : rawData) {
            RawLineData lineData = parseLineData(line);
//            System.out.println(lineData);
            addUniqueCoordinatesPoints(lineData);
        }
        System.out.println(rawLinesData);
        return points;
    }

    public ArrayList<RawLineData> getRawLinesData() {
        return rawLinesData;
    }

    private void addUniqueCoordinatesPoints(RawLineData lineData) {
//        for(RawLineData p : rawLinesData){
//            if(p.getLatitude() == lineData.getLatitude()
//                    && p.getLongitude() == lineData.getLongitude()){
//                return;
//            }
//        }

        boolean exists = rawLinesData.stream()
                .anyMatch(p -> p.getLatitude() == lineData.getLatitude() && p.getLongitude() == lineData.getLongitude());

        // Если такие данные уже существуют, выходим из метода
        if (exists) {
            return;
        }
        rawLinesData.add(lineData);
    }

    private RawLineData parseLineData(String line) {
        RawLineData lineData = new RawLineData();

        satellitesParser.setLineData(line);
        int satellites = satellitesParser.getData();
        lineData.setSatellites(satellites);

        coordsParser.setLineData(line);
        double lat = coordsParser.getLat();
        lineData.setLatitude(lat);

        double lng = coordsParser.getLng();
        lineData.setLongitude(lng);

        lineData.setDate(new Date());

        lineData.setRates(new int[]{1, 2, 3, 4});

        return lineData;
    }

} //ParserManager
