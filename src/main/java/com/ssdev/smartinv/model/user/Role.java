package com.ssdev.smartinv.model.user;

public enum Role {
    ADMIN("Admin"),
    USER("User"),
    GUEST("Guest"),
    MANAGER("Manager");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
