package com.um191;

public class Main {
    public static void main(String[] args) {
        System.out.printf(getGreetings("Sasha"));
    }

    public static String getGreetings(String name) {
        return "Hello and welcome " + name + "!";
    }
}