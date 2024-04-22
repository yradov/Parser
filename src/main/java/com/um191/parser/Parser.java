package com.um191.parser;

import com.um191.models.PointData;
import com.um191.models.RawLineData;

import java.util.ArrayList;
import java.util.Date;

abstract public class Parser implements GettingData {
    String data;
    static ArrayList<PointData> points = new ArrayList<>();
    private static ArrayList<RawLineData> rawData = new ArrayList<>();

    private SatellitesParser satellitesParser;

    Parser(){

    }

    Parser(String data) {
        this.data = data;
    }

//    static public ArrayList<PointData> parsData (ArrayList<String> rawDataStrings){
//
//        for(String line : rawDataStrings){
//            RawLineData lineData = parseLineData(line);
//
//            rawData.add(lineData);
//        }
//
//        System.out.println(rawData.toString());
//        return points;
//    }
//
//    static public RawLineData parseLineData(String line){
//        RawLineData lineData = new RawLineData();
//        lineData.setSatellites(10);
//
//        lineData.setLatitude(2.4);
//
//        lineData.setLongitude(4.2);
//
//        lineData.setDate(new Date());
//
//        lineData.setRates(new int[]{1, 2, 3, 4});
//
////        Parser satelliteP = new SatellitesParser("12");
////        int res = satelliteP.<Integer>getData();
////        System.out.println("satellites: " + res);
////
////        Parser coordsP = new CoordsParser("46.44529342");
////        double resCoords = coordsP.<Double>getData();
////        System.out.println("Coordinates: " + resCoords);
//
//
//        return lineData;
//    }


//    static public int parsDataSatellites (String data){
//        Parser satelliteP = new SatellitesParser("12");
//        int result = satelliteP.<Integer>getData();
//        System.out.println("satellites: " + result);
//
//        return result;
//    }

}
