package com.ssdev.smartinv.model.common;

public enum Country {
    Bangladesh("Bangladesh"),
    India("India"),
    Pakistan("Pakistan"),
    Nepal("Nepal");

    private String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
