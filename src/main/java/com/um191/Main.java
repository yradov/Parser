package com.um191;

import com.um191.parser.CoordsParser;
import com.um191.parser.Parser;
import com.um191.parser.SatellitesParser;

public class Main {
    public static void main(String[] args) {
        /**
         * 1) Open file with data
         * 2) Getting data from file(parse)
         * 3) Create .CSV file
         */
        Parser satelliteP = new SatellitesParser("12");
        int res = satelliteP.<Integer>getData();
        System.out.println("satellites: " + res);

        Parser coordsP = new CoordsParser("46.44529342");
        double resCoords = coordsP.<Double>getData();
        System.out.println("Coordinates: " + resCoords);
    }

    /**
     * for test sample
     */
    public static String getGreetings(String name) {
        return "Hello and welcome " + name + "!";
    }
}