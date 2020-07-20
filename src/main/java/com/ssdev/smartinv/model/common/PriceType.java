package com.ssdev.smartinv.model.common;

public enum PriceType {
    SIMPLE("Simple"),
    COMPOUND("Compound");

    private final String name;

    PriceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
