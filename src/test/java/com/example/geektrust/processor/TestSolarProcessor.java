package com.example.geektrust.processor;

import com.example.geektrust.model.SolarPanelContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolarProcessor {

    SolarPanelContext solarPanelContext = new SolarPanelContext();
    SolarProcessor solarProcessor;

    @BeforeEach
    void setup() {
        solarPanelContext.setSystemType("HOME_SYSTEM");
        solarPanelContext.setSolarPanelSize("LARGE");
        solarPanelContext.setAverageDurationPerDay(6.1);
        solarProcessor = new SolarProcessor();
    }


    @Test
    void testSubCommunityWithOneArea() {

        String subCommunity1 = "AREA1 33 15";
        solarProcessor.processSubCommunityDetails(solarPanelContext, subCommunity1);
        solarProcessor.collateResults(solarPanelContext);
        Assertions.assertEquals(93000, solarPanelContext.getTotalPowerForCommunityInWatts().intValue());
    }

    @Test
    void testSubCommunityWithTwoAreas() {

        String subCommunity1 = "AREA1 33 15";
        String subCommunity2 = "AREA2 20 30";
        solarProcessor.processSubCommunityDetails(solarPanelContext, subCommunity1);
        solarProcessor.processSubCommunityDetails(solarPanelContext, subCommunity2);
        solarProcessor.collateResults(solarPanelContext);
        Assertions.assertEquals(206000, solarPanelContext.getTotalPowerForCommunityInWatts().intValue());
    }
}
