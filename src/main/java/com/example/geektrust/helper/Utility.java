package com.example.geektrust.helper;

import com.example.geektrust.model.SolarPanelContext;
import com.example.geektrust.model.SolarPanelSpecs;
import com.example.geektrust.model.SolarSystemType;
import com.example.geektrust.model.SubCommunity;

public class Utility {
    private static final int THOUSAND = 1000;

    private Utility() {
    }

    public static void calculateCommunityPowerRequirements(SolarPanelContext solarPanelContext) {
        calculateSubCommunityPowerRequirements(solarPanelContext);
        int totalPowerForCommunityInKW = (int) Math.floor(solarPanelContext.getTotalPowerForCommunityInKW());
        solarPanelContext.setTotalPowerForCommunityInWatts(totalPowerForCommunityInKW * THOUSAND);

        int stockRangeForSolarPanel = SolarPanelSpecs.valueOf(solarPanelContext.getSolarPanelSize()).stockRange;
        int totalPanelsForCommunity = solarPanelContext.getTotalPowerForCommunityInWatts() / stockRangeForSolarPanel;
        int totalNumberOfHomes = solarPanelContext.getSubCommunities().stream().mapToInt(SubCommunity::getNumberOfHouses).sum();
        int totalPanelsPerHome = totalPanelsForCommunity / totalNumberOfHomes;

        solarPanelContext.setTotalPanelsForCommunity(totalPanelsForCommunity);
        solarPanelContext.setTotalPanelsPerHome(totalPanelsPerHome);
    }

    private static void calculateSubCommunityPowerRequirements(SolarPanelContext solarPanelContext) {
        solarPanelContext.getSubCommunities().forEach(subCommunity -> {
            double dailyGeneratedEnergy = subCommunity.getDailyEnergyRequirement() / solarPanelContext.getAverageDurationPerDay();
            double systemEfficiencyFactor = SolarSystemType.valueOf(solarPanelContext.getSystemType()).efficiencyFactor;
            double subCommunityPowerInKW = dailyGeneratedEnergy * subCommunity.getNumberOfHouses() * systemEfficiencyFactor;
            double totalPowerForCommunity = solarPanelContext.getTotalPowerForCommunityInKW();
            totalPowerForCommunity += subCommunityPowerInKW;
            solarPanelContext.setTotalPowerForCommunityInKW(totalPowerForCommunity);
        });
    }

}
