package com.example.geektrust.processor;

import com.example.geektrust.helper.Constants;
import com.example.geektrust.model.SolarPanelContext;

import java.util.List;

public class CommandProcessor {

    private static final int THREE = 3;
    private static final int FOUR = 4;

    private SolarPanelContext solarPanelContext;
    private IProcessor iProcessor;

    public CommandProcessor() {
        solarPanelContext = new SolarPanelContext();
        iProcessor = new SolarProcessor();
    }

    public void readAndProcessCommand(List<String> lines) {
        readSolarCommunityInputs(lines);
        processSolarCommunity(lines);
    }

    public List<String> printSolarCommunity() {
        iProcessor.collateResults(solarPanelContext);
        return solarPanelContext.getSolarPanelOutput();
    }

    private void processSolarCommunity(List<String> lines) {
        lines.remove(Constants.ZERO);

        for (String line : lines) {
            iProcessor.processSubCommunityDetails(solarPanelContext, line);
        }
    }

    private void readSolarCommunityInputs(List<String> lines) {
        String firstCommand = lines.get(Constants.ZERO);
        String[] communityDetails = firstCommand.split(Constants.SPACE);

        solarPanelContext.setSystemType(communityDetails[Constants.TWO]);
        solarPanelContext.setSolarPanelSize(communityDetails[THREE]);
        solarPanelContext.setAverageDurationPerDay(Double.parseDouble(communityDetails[FOUR]));
    }
}
