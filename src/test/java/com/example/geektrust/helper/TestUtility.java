package com.example.geektrust.helper;

import com.example.geektrust.model.SolarPanelContext;
import com.example.geektrust.model.SubCommunity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TestUtility {
    SolarPanelContext solarPanelContext = new SolarPanelContext();

    @BeforeEach
    void setup() {
        solarPanelContext.setSystemType("HOME_SYSTEM");
        solarPanelContext.setSolarPanelSize("LARGE");
        solarPanelContext.setAverageDurationPerDay(6.1);
    }

    @Test
    void testGetUpdatedPortfolioSIPAssetAmountFlr() {
        SubCommunity subCommunity1 = new SubCommunity(33, 15);
        SubCommunity subCommunity2 = new SubCommunity(33, 15);
        solarPanelContext.setSubCommunities(Arrays.asList(subCommunity1, subCommunity2));
        Utility.calculateCommunityPowerRequirements(solarPanelContext);
        Assertions.assertEquals(186000, solarPanelContext.getTotalPowerForCommunityInWatts());
        Assertions.assertEquals(676, solarPanelContext.getTotalPanelsForCommunity());
    }


}
