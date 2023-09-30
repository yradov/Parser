package com.um191.parser;

public class SatellitesParser extends Parser {
    public SatellitesParser(String data) {
        super(data);
    }

    @Override
    public Integer getData() {
        Integer result;
        result = Integer.parseInt(data);
        return result;
    }
}
