package com.example.geektrust.model;

import java.util.ArrayList;
import java.util.List;

public class SolarPanelContext {

    private String systemType;
    private String solarPanelSize;
    private double averageDurationPerDay;
    private List<SubCommunity> subCommunities = new ArrayList<>();
    private double totalPowerForCommunityInKW;
    private int totalPowerForCommunityInWatts;
    private int totalPanelsForCommunity;
    private List<String> solarPanelOutput;
    private int totalPanelsPerHome;

    public List<String> getSolarPanelOutput() {
        return solarPanelOutput;
    }

    public void setSolarPanelOutput(List<String> solarPanelOutput) {
        this.solarPanelOutput = solarPanelOutput;
    }

    public int getTotalPanelsPerHome() {
        return totalPanelsPerHome;
    }

    public void setTotalPanelsPerHome(int totalPanelsPerHome) {
        this.totalPanelsPerHome = totalPanelsPerHome;
    }

    public List<SubCommunity> getSubCommunities() {
        return subCommunities;
    }

    public void setSubCommunities(List<SubCommunity> subCommunities) {
        this.subCommunities = subCommunities;
    }

    public int getTotalPowerForCommunityInWatts() {
        return totalPowerForCommunityInWatts;
    }

    public void setTotalPowerForCommunityInWatts(int totalPowerForCommunityInWatts) {
        this.totalPowerForCommunityInWatts = totalPowerForCommunityInWatts;
    }


    public double getTotalPowerForCommunityInKW() {
        return totalPowerForCommunityInKW;
    }

    public void setTotalPowerForCommunityInKW(double totalPowerForCommunityInKW) {
        this.totalPowerForCommunityInKW = totalPowerForCommunityInKW;
    }

    public int getTotalPanelsForCommunity() {
        return totalPanelsForCommunity;
    }

    public void setTotalPanelsForCommunity(int totalPanelsForCommunity) {
        this.totalPanelsForCommunity = totalPanelsForCommunity;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getSolarPanelSize() {
        return solarPanelSize;
    }

    public void setSolarPanelSize(String solarPanelSize) {
        this.solarPanelSize = solarPanelSize;
    }

    public double getAverageDurationPerDay() {
        return averageDurationPerDay;
    }

    public void setAverageDurationPerDay(double averageDurationPerDay) {
        this.averageDurationPerDay = averageDurationPerDay;
    }
}
