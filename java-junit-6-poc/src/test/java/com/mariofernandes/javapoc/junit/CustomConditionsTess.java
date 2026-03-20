package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

public class CustomConditionsTess {

    @Test
    @EnabledIf("myCustomCondition")
    void testEnabled() {

    }

    @Test
    @DisabledIf("myCustomCondition")
    void testDisabled() {

    }

    @Test
    @EnabledIf("com.mariofernandes.javapoc.junit.ExternalCondition#myCustomCondition")
    void testEnabledExternal() {

    }

    private boolean myCustomCondition() {
        // should not be static method
        return true;
    }

}

class ExternalCondition {
    static boolean myCustomCondition() {
        // must be static method
        return true;
    }
}
