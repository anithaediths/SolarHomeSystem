package com.example.geektrust.model;

public enum SolarPanelSpecs {
    LARGE(275),
    MEDIUM(300),
    SMALL(350);

    public final int stockRange;

    SolarPanelSpecs(int stockRange) {
        this.stockRange = stockRange;
    }
}
