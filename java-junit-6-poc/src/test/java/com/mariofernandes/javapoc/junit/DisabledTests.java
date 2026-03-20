package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTests {
    @Test
    @Disabled("Disabled until bug #06 has been resolved")
    void testWillBeSkipped() {

    }

    @Test
    void testWillBeExecuted() {

    }
}
