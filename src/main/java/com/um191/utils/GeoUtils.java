package com.um191.utils;

import com.um191.models.PointData;

import java.util.ArrayList;

public class GeoUtils {
    public static ArrayList<PointData> createIntermediatePoints(double startLat, double startLng, double endLat, double endLng, int[] rates) {
        //@TODO
        /**
         * double startLat, double startLng, double endLat, double endLng, int[] rates
         * есть начальные и конечные координаты отрезка, который разбит на количество rates, как в джава найти координаты каждой точки которые делят этот отрезок
         * перепеши код используя библиотеку джава для работы с координатами
         */
        ArrayList <PointData> points = new ArrayList<>();
        int n = rates.length;

        double stepLat = (endLat - startLat) / (n + 1);
        double stepLng = (endLng - startLng) / (n + 1);

        for (int i = 0; i < n; i++) {
            PointData point = new PointData();
            point.setLatitude(startLat + stepLat * (i + 1));
            point.setLongitude(startLng + stepLng * (i + 1));
            point.setRate(rates[i]);

            points.add(point);
        }


        return points;
    }

}
