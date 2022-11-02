package com.example.geektrust.model;

public enum SolarSystemType {
    HOME_SYSTEM(1.15),
    MINI_GRID_SYSTEM(2.25);

    public final double efficiencyFactor;

    SolarSystemType(double efficiencyFactor) {
        this.efficiencyFactor = efficiencyFactor;
    }
}
