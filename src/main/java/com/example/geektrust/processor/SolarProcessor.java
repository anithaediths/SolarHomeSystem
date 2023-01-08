package com.example.geektrust.processor;

import com.example.geektrust.helper.Constants;
import com.example.geektrust.helper.Utility;
import com.example.geektrust.model.SolarPanelContext;
import com.example.geektrust.model.SubCommunity;

import java.util.ArrayList;
import java.util.List;

public class SolarProcessor implements IProcessor {
    @Override
    public void processSubCommunityDetails(SolarPanelContext solarPanelContext, String line) {
        String[] subCommunityDetails = line.split(Constants.SPACE);
        double dailyEnergyRequirement = Double.parseDouble(subCommunityDetails[Constants.ONE]);
        int numberOfHouses = Integer.parseInt(subCommunityDetails[Constants.TWO]);
        SubCommunity subCommunity = new SubCommunity(dailyEnergyRequirement, numberOfHouses);
        solarPanelContext.getSubCommunities().add(subCommunity);
    }

    @Override
    public void collateResults(SolarPanelContext solarPanelContext) {
        Utility.calculateCommunityPowerRequirements(solarPanelContext);

        List<String> solarPanelOutput = new ArrayList<>();
        solarPanelOutput.add(Constants.TOTAL_POWER_COMMUNITY_WATTS + solarPanelContext.getTotalPowerForCommunityInWatts());
        solarPanelOutput.add(Constants.TOTAL_NUMBER_OF_PANELS + solarPanelContext.getTotalPanelsPerHome());
        solarPanelContext.setSolarPanelOutput(solarPanelOutput);

    }
}
