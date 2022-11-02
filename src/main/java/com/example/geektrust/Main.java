package com.example.geektrust;

import com.example.geektrust.helper.Constants;
import com.example.geektrust.processor.CommandProcessor;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final String INVALID_INPUT = "INVALID INPUT";

    public static void main(String[] args) {
        try (Stream<String> linesOfFile = Files.lines(new File(args[0]).toPath())) {
            readAndProcessInputFile(linesOfFile);
        } catch (Exception e) {
            System.out.println(INVALID_INPUT);
        }
    }

    private static void readAndProcessInputFile(Stream<String> linesOfFile) {
        CommandProcessor commandProcessor = new CommandProcessor();
        List<String> lines = linesOfFile
                .map(String::trim)
                .filter(s -> !s.matches(Constants.SPACE))
                .collect(Collectors.toList());

        commandProcessor.readAndProcessCommand(lines);
        commandProcessor.printSolarCommunity().forEach(System.out::println);
    }

}
