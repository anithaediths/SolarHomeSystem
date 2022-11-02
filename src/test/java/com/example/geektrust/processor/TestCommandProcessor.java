package com.example.geektrust.processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TestCommandProcessor {

    CommandProcessor commandProcessor = new CommandProcessor();

    @BeforeEach
    void setup() {
    }

    @Test
    void testReadAndProcessCommand() {
        List<String> instructions = new ArrayList<>();
        instructions.add("COMM_1 URBAN HOME_SYSTEM LARGE 6.1");
        instructions.add("AREA1 33 15");
        instructions.add("AREA2 20 3");

        Assertions.assertDoesNotThrow(() -> commandProcessor.readAndProcessCommand(instructions));
    }
}
