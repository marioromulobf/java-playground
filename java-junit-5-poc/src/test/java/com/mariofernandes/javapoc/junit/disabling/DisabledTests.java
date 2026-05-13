package com.mariofernandes.javapoc.junit.disabling;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

import java.util.Random;

public class DisabledTests {

    private final Random random = new Random();

    @Disabled("Disabled until bug #999 has been resolved")
    @Test
    void testWillBeSkipped() {}

    @Test
    void testWillBeExecuted() {}

    @DisabledIf(value = "checkIsDisabled")
    @Test
    void testCanBeSkipped() {}


    private boolean checkIsDisabled() {
        return random.nextBoolean();
    }
}
