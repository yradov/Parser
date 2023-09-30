package com.um191.parser;

abstract public class Parser implements GettingData {
    String data;

    Parser(String data) {
        this.data = data;
    }

    static public void parsData (String data){
        Parser satelliteP = new SatellitesParser("12");
        int res = satelliteP.<Integer>getData();
        System.out.println("satellites: " + res);

        Parser coordsP = new CoordsParser("46.44529342");
        double resCoords = coordsP.<Double>getData();
        System.out.println("Coordinates: " + resCoords);

    }
    static public int parsDataSatellites (String data){
        Parser satelliteP = new SatellitesParser("12");
        int result = satelliteP.<Integer>getData();
        System.out.println("satellites: " + result);

        return result;
    }

}
