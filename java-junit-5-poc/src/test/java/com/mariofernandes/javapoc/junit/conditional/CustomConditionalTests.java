package com.mariofernandes.javapoc.junit.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

public class CustomConditionalTests {
    @Test
    @EnabledIf("customCondition")
    void testEnabled() {
    }

    @Test
    @DisabledIf("customCondition")
    void testDisabled() {}

    @Test
    @DisabledIf(value = "java.awt.GraphicsEnvironment#isHeadless", disabledReason = "headless environment")
    void testDisabledHeadless() {}

    @Test
    @EnabledIf(value = "java.awt.GraphicsEnvironment#isHeadless", disabledReason = "headless environment is false")
    void testEnabledHeadless() {}

    boolean customCondition() {
        return true;
    }
}
