package com.um191.models;

import java.text.SimpleDateFormat;
import java.util.Arrays;

public class PointData {
    private double latitude;
    private double longitude;
    private int rate;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    @Override
    public String toString() {
        return "PointData{" +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", rate=" + rate +
                "}\n=======\n";
    }

}
