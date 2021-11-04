package com.diplomaticdelivery.diplomatic.enums;

public enum ConsignmentStatus {

    ON_TRANSIT("ON_TRANSIT","On transit"),
    ON_HOLD("ON_HOLD","On hold");

    ConsignmentStatus(String name, String description) {
        this.description = description;
        this.name = name;

    }

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
