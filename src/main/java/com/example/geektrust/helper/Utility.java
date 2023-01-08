package com.example.geektrust.helper;

import com.example.geektrust.model.SolarPanelContext;
import com.example.geektrust.model.SolarPanelSpecs;
import com.example.geektrust.model.SolarSystemType;
import com.example.geektrust.model.SubCommunity;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Utility {
    private static final int THOUSAND = 1000;

    private Utility() {
    }

    public static void calculateCommunityPowerRequirements(SolarPanelContext solarPanelContext) {
        calculateSubCommunityPowerRequirements(solarPanelContext);
        BigInteger oneK = new BigInteger(String.valueOf(THOUSAND));
        BigInteger totalPowerForCommunityInWatts = solarPanelContext.getTotalPowerForCommunityInKW().toBigInteger().multiply(oneK);
        solarPanelContext.setTotalPowerForCommunityInWatts(totalPowerForCommunityInWatts);

        int stockRangeForSolarPanel = SolarPanelSpecs.valueOf(solarPanelContext.getSolarPanelSize()).stockRange;
        BigInteger stockRangeForSolarPanelB = new BigInteger(String.valueOf(stockRangeForSolarPanel));
        BigInteger totalPanelsForCommunityB = solarPanelContext.getTotalPowerForCommunityInWatts().divide(stockRangeForSolarPanelB);
        int totalNumberOfHomes = solarPanelContext.getSubCommunities().stream().mapToInt(SubCommunity::getNumberOfHouses).sum();
        BigInteger totalNumberOfHomesB = new BigInteger(String.valueOf(totalNumberOfHomes));
        BigInteger totalPanelsPerHome = totalPanelsForCommunityB.divide(totalNumberOfHomesB);

        solarPanelContext.setTotalPanelsForCommunity(totalPanelsForCommunityB.intValue());
        solarPanelContext.setTotalPanelsPerHome(totalPanelsPerHome.intValue());
    }

    private static void calculateSubCommunityPowerRequirements(SolarPanelContext solarPanelContext) {
        solarPanelContext.getSubCommunities().forEach(subCommunity -> {
            double dailyGeneratedEnergy = subCommunity.getDailyEnergyRequirement() / solarPanelContext.getAverageDurationPerDay();
            double systemEfficiencyFactor = SolarSystemType.valueOf(solarPanelContext.getSystemType()).efficiencyFactor;
            BigDecimal subCommunityPowerInKW = BigDecimal.valueOf(dailyGeneratedEnergy * subCommunity.getNumberOfHouses() * systemEfficiencyFactor);
            BigDecimal totalPowerForCommunity = solarPanelContext.getTotalPowerForCommunityInKW();
            totalPowerForCommunity = totalPowerForCommunity.add(subCommunityPowerInKW);
            solarPanelContext.setTotalPowerForCommunityInKW(totalPowerForCommunity);
        });
    }

}
