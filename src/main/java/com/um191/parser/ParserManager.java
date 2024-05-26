package com.um191.parser;

import com.um191.models.PointData;
import com.um191.models.RawLineData;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class ParserManager {
    private final ArrayList<String> rawData;
    private final SatellitesParser satellitesParser;
    private CoordsParser coordsParser;
    private DateParser dateParser;
    private RateParser rateParser;
    private ArrayList<PointData> points = new ArrayList<>();
    private final ArrayList<RawLineData> rawLinesData = new ArrayList<>();


    public ParserManager(ArrayList<String> rawData) {
        this.rawData = rawData;
        satellitesParser = new SatellitesParser();
        coordsParser = new CoordsParser();
        dateParser = new DateParser();
        rateParser = new RateParser();
    }


    public ArrayList<PointData> parsData() {

        for (String line : rawData) {
            RawLineData lineData = parseLineData(line);
//            System.out.println(lineData);
            addUniqueCoordinatesPoints(lineData);
        }
        System.out.println(rawLinesData);

        return getPointFromRawLineData();
    }

    private ArrayList<PointData> getPointFromRawLineData() {
        int maxRawPointsIndex = rawLinesData.size() - 1;

        for(int i = 0; i <= maxRawPointsIndex; i++){
            if(i == maxRawPointsIndex) break;

            double startLat = rawLinesData.get(i).getLatitude();
            double startLng = rawLinesData.get(i).getLongitude();
            double endLat = rawLinesData.get(i+1).getLatitude();
            double endLng = rawLinesData.get(i+1).getLongitude();

            PointData point = new PointData();
            point.setLatitude(startLat);
            point.setLongitude(startLng);
            point.setRate(rawLinesData.get(i).getFirstRate());

            points.add(point);

            createIntermediatePoints(startLat, startLng, endLat, endLng, rawLinesData.get(i).getRates());
        }
        System.out.println(points);
        return points;
    }

    private void createIntermediatePoints(double startLat, double startLng, double endLat, double endLng, int[] rates) {
        //@TODO
        /**
         * double startLat, double startLng, double endLat, double endLng, int[] rates
         * есть начальные и конечные координаты отрезка, который разбит на количество rates, как в джава найти координаты каждой точки которые делят этот отрезок
         * перепеши код используя библиотеку джава для работы с координатами
         */
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

        try {
            Date date = dateParser.getData(line);
            lineData.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int[] rates = rateParser.getData(line);
        lineData.setRates(rates);

        return lineData;
    }

} //ParserManager
