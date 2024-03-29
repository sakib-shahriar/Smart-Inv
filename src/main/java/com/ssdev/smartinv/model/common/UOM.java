package com.ssdev.smartinv.model.common;

public enum UOM {
    PIECE("piece"),
    KILOGRAM("kg"),
    GRAM("gram"),
    LITTER("l"),
    MILLILITER("ml");

    private final String name;

    UOM(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
