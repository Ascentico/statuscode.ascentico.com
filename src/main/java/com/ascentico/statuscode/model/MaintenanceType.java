package com.ascentico.statuscode.model;

public enum MaintenanceType {
    OK("OK"),
    DOWN("DOWN"),
    MAINTENANCE("MAINTENANCE"),
    DB_DOWN("DB_DOWN");

    private final String displayName;

    MaintenanceType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
