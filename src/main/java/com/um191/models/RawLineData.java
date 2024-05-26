package com.um191.models;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RawLineData {
    private int satellites;
    private double latitude;
    private double longitude;
    private Date date;
    private int[] rates;

    public int getSatellites() {
        return satellites;
    }

    public void setSatellites(int satellites) {
        this.satellites = satellites;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int[] getRates() {
        return rates;
    }

    public void setRates(int[] rates) {
        this.rates = rates;
    }

    public int getFirstRate(){
        if(rates.length == 0) return 0;
        int res = this.rates[0];

        if(rates.length > 1){
            int[] newArray = new int[rates.length - 1];
            System.arraycopy(rates, 1, newArray, 0, rates.length - 1);
            this.rates = newArray;
        }

        return res;
    }

    @Override
    public String toString() {
        String dateForShow = (new SimpleDateFormat("MM/dd/yyyy")).format(date);
        return "RawLineData{" +
                "satellites=" + satellites +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", date=" + dateForShow +
                ", rates=" + Arrays.toString(rates) +
                "}\n=======\n";
    }
}
