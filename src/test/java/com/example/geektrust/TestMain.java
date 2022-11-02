package com.example.geektrust;

import com.example.geektrust.helper.Constants;
import com.example.geektrust.processor.CommandProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TestMain {

    String inputFilePath = "sample_input/";
    CommandProcessor commandProcessor = new CommandProcessor();

    @ParameterizedTest
    @CsvSource({
            "input1.txt,206000,16",
            "input2.txt,504000,42",
            "input3.txt,1469000,70",
            "input4.txt,190000,22",
    }
    )
    void testValidInputs(String inputFileName, String totalPowerInWatts, String noOfPanels) throws IOException {
        List<String> lines = readInputFile(inputFileName);
        commandProcessor.readAndProcessCommand(lines);
        List<String> printResults = commandProcessor.printSolarCommunity();
        Assertions.assertEquals(Constants.TOTAL_POWER_COMMUNITY_WATTS + totalPowerInWatts, printResults.get(0));
        Assertions.assertEquals(Constants.TOTAL_NUMBER_OF_PANELS + noOfPanels, printResults.get(1));

    }

    @ParameterizedTest
    @CsvSource({
            "input5.txt",
            "input6.txt"
    }
    )
    void testInValidInputs(String inputFileName) throws IOException {
        List<String> lines = readInputFile(inputFileName);
        Assertions.assertThrows(Exception.class, () -> {
            commandProcessor.readAndProcessCommand(lines);
            commandProcessor.printSolarCommunity();
        });
    }

    private List<String> readInputFile(String inputFileName) throws IOException {
        Stream<String> linesOfFile = Files.lines(new File(inputFilePath + inputFileName).toPath());
        List<String> lines = linesOfFile
                .map(String::trim)
                .filter(s -> !s.matches(Constants.SPACE))
                .collect(Collectors.toList());
        return lines;
    }

}
