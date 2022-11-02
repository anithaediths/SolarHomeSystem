package com.example.geektrust.model;

public class SubCommunity {
    double dailyEnergyRequirement;
    int numberOfHouses;

    public SubCommunity(double dailyEnergyRequirement, int numberOfHouses) {
        this.dailyEnergyRequirement = dailyEnergyRequirement;
        this.numberOfHouses = numberOfHouses;
    }

    public double getDailyEnergyRequirement() {
        return dailyEnergyRequirement;
    }

    public void setDailyEnergyRequirement(int dailyEnergyRequirement) {
        this.dailyEnergyRequirement = dailyEnergyRequirement;
    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    public void setNumberOfHouses(int numberOfHouses) {
        this.numberOfHouses = numberOfHouses;
    }
}
