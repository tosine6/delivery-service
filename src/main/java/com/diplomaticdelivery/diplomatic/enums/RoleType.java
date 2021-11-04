package com.diplomaticdelivery.diplomatic.enums;

public enum RoleType {

    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER"),
    ROLE_SUPER_ADMIN("SUPER_ADMIN");

    private String name;

    private RoleType(String name) {
        this.name= name;
    }
    public String getName() {

        return name;
    }

}