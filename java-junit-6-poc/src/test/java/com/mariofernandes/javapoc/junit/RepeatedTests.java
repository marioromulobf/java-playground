package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class RepeatedTests {

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().orElseThrow().getName();
        System.out.println("About to execute repetition " + currentRepetition + " of " + totalRepetitions + " for " + methodName);
    }

    @RepeatedTest(10)
    void repeatedTest() {
    }

    @RepeatedTest(5)
    void repeatedTestWithRepetitionInfoTest(RepetitionInfo info) {
        Assertions.assertEquals(5, info.getTotalRepetitions());
    }

    @RepeatedTest(value = 8, failureThreshold = 3)
    void repeatedTestWithFailureThreshold(RepetitionInfo info) {
        // the last two always be skipped
        if (info.getCurrentRepetition() % 2 == 0) {
            Assertions.fail("Boom!");
        }
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void repeatedTestWithCustomDisplayName(TestInfo info) {
        Assertions.assertEquals("Repeat! 1/1", info.getDisplayName());
    }
}
