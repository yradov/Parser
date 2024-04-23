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

    public ParserManager(ArrayList<String> lineData) {
        this.rawData = lineData;
        satellitesParser = new SatellitesParser();
        coordsParser = new CoordsParser();
    }


    public ArrayList<PointData> parsData (){

        for(String line : rawData){
            RawLineData lineData = parseLineData(line);
            System.out.println(lineData);
            /** @TODO create array for lineData and exclude points with same coordinates*/
        }
        return points;
    }

    private RawLineData parseLineData(String line){
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
