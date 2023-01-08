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
        BigInteger totalPowerForCommunityInWatts = solarPanelContext.getTotalPowerForCommunityInKW()
                .toBigInteger().multiply(oneK);
        solarPanelContext.setTotalPowerForCommunityInWatts(totalPowerForCommunityInWatts);

        int stockRangeForSolarPanelSize = SolarPanelSpecs.valueOf(solarPanelContext.getSolarPanelSize()).stockRange;
        BigInteger stockRangeForSolarPanel = new BigInteger(String.valueOf(stockRangeForSolarPanelSize));
        BigInteger totalPanelsForCommunity = solarPanelContext.getTotalPowerForCommunityInWatts()
                .divide(stockRangeForSolarPanel);

        int totalNumberOfHomes = solarPanelContext.getSubCommunities().stream()
                .mapToInt(SubCommunity::getNumberOfHouses).sum();
        BigInteger totalHomes = new BigInteger(String.valueOf(totalNumberOfHomes));
        BigInteger panelsPerHome = totalPanelsForCommunity.divide(totalHomes);

        solarPanelContext.setTotalPanelsForCommunity(totalPanelsForCommunity.intValue());
        solarPanelContext.setTotalPanelsPerHome(panelsPerHome.intValue());
    }

    private static void calculateSubCommunityPowerRequirements(SolarPanelContext solarPanelContext) {
        solarPanelContext.getSubCommunities().forEach(subCommunity -> {
            double dailyGeneratedEnergy = subCommunity.getDailyEnergyRequirement() / solarPanelContext.getAverageDurationPerDay();
            double systemEfficiencyFactor = SolarSystemType.valueOf(solarPanelContext.getSystemType()).efficiencyFactor;
            double subCommunityPower = dailyGeneratedEnergy * subCommunity.getNumberOfHouses() * systemEfficiencyFactor;
            BigDecimal subCommunityPowerInKW = BigDecimal.valueOf(subCommunityPower);
            BigDecimal totalPowerForCommunity = solarPanelContext.getTotalPowerForCommunityInKW();
            totalPowerForCommunity = totalPowerForCommunity.add(subCommunityPowerInKW);
            solarPanelContext.setTotalPowerForCommunityInKW(totalPowerForCommunity);
        });
    }

}
