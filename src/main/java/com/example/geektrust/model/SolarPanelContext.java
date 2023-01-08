package com.example.geektrust.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SolarPanelContext {

    private String systemType;
    private String solarPanelSize;
    private double averageDurationPerDay;
    private List<SubCommunity> subCommunities = new ArrayList<>();
    private BigDecimal totalPowerForCommunityInKW = new BigDecimal(0);
    private BigInteger totalPowerForCommunityInWatts;
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

    public BigInteger getTotalPowerForCommunityInWatts() {
        return totalPowerForCommunityInWatts;
    }

    public void setTotalPowerForCommunityInWatts(BigInteger totalPowerForCommunityInWatts) {
        this.totalPowerForCommunityInWatts = totalPowerForCommunityInWatts;
    }


    public BigDecimal getTotalPowerForCommunityInKW() {
        return totalPowerForCommunityInKW;
    }

    public void setTotalPowerForCommunityInKW(BigDecimal totalPowerForCommunityInKW) {
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
