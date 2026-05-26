package com.mariofernandes.javapoc.junit.repeated;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import java.util.logging.Logger;

public class RepeatedTests {

    Logger logger = Logger.getLogger(RepeatedTests.class.getName());

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        logger.info(String.format("About to execute repetition %d of %d for %s",
                currentRepetition, totalRepetitions, methodName));
    }

     @RepeatedTest(10)
     void testRepeated() {}

    @RepeatedTest(5)
    void testRepeatedWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        Assertions.assertEquals(5, repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 8, failureThreshold = 2)
    void testRepeatedWithFailureThreshold(RepetitionInfo repetitionInfo) {
        if (repetitionInfo.getCurrentRepetition() % 2 == 0) {
            Assertions.fail("Boom!");
        }
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void testCustomDisplayName(TestInfo testInfo) {
        Assertions.assertEquals("Repeat! 1/1", testInfo.getDisplayName());
    }

    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    void testCustomDisplayNameWithLongPattern(TestInfo testInfo) {
        Assertions.assertEquals("Details... :: repetition 1 of 1", testInfo.getDisplayName());
    }

    @RepeatedTest(value = 5, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
    void testRepeatedInGerman() {}
}
