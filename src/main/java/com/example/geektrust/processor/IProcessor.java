package com.example.geektrust.processor;

import com.example.geektrust.model.SolarPanelContext;

public interface IProcessor {

    void processSubCommunityDetails(SolarPanelContext solarPanelContext, String line);

    void collateResults(SolarPanelContext solarPanelContext);

}
