package com.um191.parser;

public class CoordsParser extends Parser {
    public CoordsParser(String data) {
        super(data);
    }

    @Override
    public Double getData() {
        Double result = Double.parseDouble(data);
        return result;
    }
}
