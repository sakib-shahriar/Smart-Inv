package com.ssdev.samrtinv.model.product;

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
